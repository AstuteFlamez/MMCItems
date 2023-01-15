package mandomc.mmcitems.vehicles;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import mandomc.mmcitems.MMCItems;
import mandomc.mmcitems.handlers.GI;
import mandomc.mmcitems.handlers.ISC;
import mandomc.mmcitems.handlers.RandomMethods;
import mandomc.mmcitems.listeners.VehicleEvents;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.spigotmc.event.entity.EntityDismountEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static mandomc.mmcitems.handlers.RandomMethods.isMobSpawningEnabled;

public class XWing implements Listener {

    private static List<Vehicle> allXWings = new ArrayList<>();
    public final HashMap<UUID, Long> torpedosCooldown = new HashMap<>();

    Vehicle xWing;

    public static List<Vehicle> getAllXWings(){
        return allXWings;
    }

    public void createShip(Player player, int customModelData, ChatColor color){

        if(isMobSpawningEnabled(player.getLocation(), player) && !player.getWorld().getName().equals("JabbasPalace")){

            xWing = new Vehicle();

            Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());

            Entity seat1 = player.getWorld().spawnEntity(loc, EntityType.PHANTOM);
            Entity model = player.getPlayer().getWorld().spawnEntity(loc, EntityType.ZOMBIE);

            int slot = player.getInventory().getHeldItemSlot();
            player.getInventory().setItem(slot, new ItemStack(Material.AIR));

            LivingEntity seat1Living = (Phantom) seat1;
            LivingEntity modelLiving = (Zombie) model;

            seat1Living.setAI(false);
            seat1Living.setSilent(true);
            seat1Living.setInvisible(true);
            seat1Living.setCollidable(true);
            seat1Living.setRotation(player.getLocation().getYaw(), 0);

            modelLiving.setAI(false);
            modelLiving.setSilent(true);
            modelLiving.setInvisible(true);
            modelLiving.setCollidable(true);
            modelLiving.setRotation(player.getLocation().getYaw(), 0);
            modelLiving.getEquipment().setHelmet(GI.xWingColored(customModelData, color));

            player.sendMessage(MMCItems.prefix + ChatColor.GRAY + "You spawned in your " + color + "X-Wing Starfighter" + ChatColor.GRAY + "!");

            xWing.setSeat1(seat1);
            xWing.setModel(model);

            getAllXWings().add(xWing);

            VehicleEvents.entitiesInShip.add(xWing.getSeat1());
            VehicleEvents.entitiesInShip.add(xWing.getModel());
        }else{
            player.sendMessage(MMCItems.prefix + ChatColor.GRAY + "You cannot spawn in your " + color + "X-Wing Starfighter" + ChatColor.GRAY + " here!");
        }
    }

    public void rideShip(Player player, Vehicle xWing){

        Entity model = xWing.getModel();
        LivingEntity livingModel = (Zombie) model;
        int customModelData = livingModel.getEquipment().getHelmet().getItemMeta().getCustomModelData();

        Entity seat1 = xWing.getSeat1();
        LivingEntity seat1Living = (Phantom) seat1;
        seat1Living.addPassenger(player);

        xWing.setPilot(player);

        VehicleEvents.playersInShip.add(xWing.getPilot());

        if(customModelData == 6){
            player.sendMessage(MMCItems.prefix + ChatColor.RED + "You mounted your X-Wing Starfighter!");
        }else if(customModelData == 7){
            player.sendMessage(MMCItems.prefix + ChatColor.DARK_GREEN + "You mounted your X-Wing Starfighter!");
        }
    }

    public static void removeShip(Player player, Vehicle xWing){

        Entity seat1 = xWing.getSeat1();
        Entity model = xWing.getModel();

        LivingEntity modelLiving = (Zombie) model;
        int customModelData = modelLiving.getEquipment().getHelmet().getItemMeta().getCustomModelData();

        VehicleEvents.entitiesInShip.remove(seat1);
        VehicleEvents.entitiesInShip.remove(model);

        seat1.remove();
        model.remove();

        xWing.setPilot(null);
        xWing.setGunner(null);
        xWing.setSeat1(null);
        xWing.setSeat2(null);
        xWing.setModel(null);

        allXWings.remove(xWing);

        if(customModelData == 6){
            player.getInventory().addItem(GI.xWingColored(customModelData, ChatColor.RED));
            player.sendMessage(MMCItems.prefix + ChatColor.GRAY + "You dismounted your " + ChatColor.RED + "X-Wing Starfighter" + ChatColor.GRAY + "!");
        }else if(customModelData == 7){
            player.getInventory().addItem(GI.xWingColored(customModelData, ChatColor.DARK_GREEN));
            player.sendMessage(MMCItems.prefix + ChatColor.GRAY + "You dismounted your " + ChatColor.DARK_GREEN + "X-Wing Starfighter" + ChatColor.GRAY + "!");
        }
    }

    public void openGUI(Player player, Vehicle xWing, ChatColor color){

        String seat1;

        if(xWing.getSeat1().getPassengers().isEmpty()){
            seat1 = ChatColor.translateAlternateColorCodes('&', "&a&lUNOCCUPIED");
        }else{
            seat1 = ChatColor.translateAlternateColorCodes('&', "&c&lOCCUPIED");
        }

        xWing.setSeat1Item(1);

        Inventory xWingGUI = Bukkit.createInventory(player, 54, color + "X-Wing Starfighter");
        xWingGUI.setItem(12, GI.xWingColored(7, ChatColor.DARK_GREEN));
        xWingGUI.setItem(14, GI.xWing());
        xWingGUI.setItem(22, ISC.createItem(Material.WOODEN_HOE, ChatColor.translateAlternateColorCodes('&', "&e&lPilot Seat"), 1, ChatColor.GRAY + "Click to enter the pilot's seat!", "", seat1));

        player.openInventory(xWingGUI);
    }

    public void shootTorpedos(Player player) {

        if (!this.torpedosCooldown.containsKey(player.getUniqueId())) {
            this.torpedosCooldown.put(player.getUniqueId(), System.currentTimeMillis());
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + "You shot your proton torpedos!");
            Location loc = player.getLocation();
            Vector direction = loc.getDirection();

            for (double t = 0; t < 128; t++) {
                loc.add(direction);

                player.getWorld().spawnParticle(Particle.REDSTONE, loc, 30, new Particle.DustOptions(Color.RED, 1F));

                if (loc.getBlock().getType().isSolid() || t == 127) {
                    player.getWorld().spawnParticle(Particle.CLOUD, loc, 30);
                    player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc, 30);
                    if (isMobSpawningEnabled(loc, player)) {
                        loc.getWorld().createExplosion(loc, 1);
                    }
                }
            }
        } else {
            long timeElapsed = System.currentTimeMillis() - torpedosCooldown.get(player.getUniqueId());
            if (timeElapsed >= 60000) {
                this.torpedosCooldown.remove(player.getUniqueId());
            } else {
                player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + "You are out of proton torpedos, try again in " + ChatColor.RED + "" + ((60000 - timeElapsed) / 1000) + "" + ChatColor.GOLD + " seconds!");

            }
        }
    }

    @EventHandler
    public void onPlayerInteractXWing(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && player.getItemInHand().getType() == Material.WOODEN_SWORD && player.getItemInHand().getItemMeta().hasCustomModelData() && player.getItemInHand().getItemMeta() != null) {
            //checks if player spawns in a ship
            if (player.getItemInHand().getItemMeta() != null && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "X-Wing Starfighter")) {
                createShip(player, 6, ChatColor.RED);
            }
            if (player.getItemInHand().getItemMeta() != null && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GREEN + "X-Wing Starfighter")) {
                if(player.hasPermission("mmc.greenxwing")){
                    createShip(player, 7, ChatColor.DARK_GREEN);
                }else{
                    player.sendMessage(ChatColor.RED + "The force is not with you...");
                }
            }
        }
        if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            for (Vehicle xWing : getAllXWings()){
                if(xWing.getPilot() == player){
                    shootTorpedos(player);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteractEntityXWing(PlayerInteractEntityEvent event) {

        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();

        for(Vehicle xWing: getAllXWings()){
            if(xWing.getModel() == entity){

                LivingEntity modelLiving = (Zombie) entity;

                int customModelData = modelLiving.getEquipment().getHelmet().getItemMeta().getCustomModelData();

                if(customModelData == 6){
                    openGUI(player, xWing, ChatColor.RED);
                }else if(customModelData == 7){
                    openGUI(player, xWing, ChatColor.DARK_GREEN);
                }
            }
        }
    }

    @EventHandler
    public void dismountXWing(EntityDismountEvent event){

        Entity entity = event.getDismounted();

        List<Vehicle> allXWindsCopy = new ArrayList<>(getAllXWings());
        for(Vehicle xWing: allXWindsCopy){
            if(xWing.getSeat1() == entity && event.getEntity() instanceof Player){
                Player player = (Player) event.getEntity();

                LivingEntity modelLiving = (Zombie) xWing.getModel();

                int customModelData = modelLiving.getEquipment().getHelmet().getItemMeta().getCustomModelData();

                if(customModelData == 6){
                    removeShip(player, xWing);
                }else if(customModelData == 7){
                    removeShip(player, xWing);
                }
            }
        }
    }

    @EventHandler
    public void inventoryClickXWing(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "X-Wing Starfighter"))
                || (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "X-Wing Starfighter"))){
            event.setCancelled(true);
            if(event.getCurrentItem() != null){
                for(Vehicle xWing : getAllXWings()) {
                    for(Entity entity : player.getNearbyEntities(3, 3, 3)){

                        LivingEntity modelLiving = (Zombie) xWing.getModel();

                        int customModelData = modelLiving.getEquipment().getHelmet().getItemMeta().getCustomModelData();

                        if(xWing.getSeat1() == entity){
                            switch (event.getSlot()){
                                case 12:
                                    event.setCancelled(true);
                                    if(player.hasPermission("mmc.greenxwing")){
                                        player.closeInventory();
                                        modelLiving.getEquipment().setHelmet(GI.xWingColored(7, ChatColor.DARK_GREEN));
                                        removeShip(player, xWing);
                                    }
                                    player.updateInventory();
                                    break;
                                case 14:
                                    event.setCancelled(true);
                                    player.closeInventory();
                                    modelLiving.getEquipment().setHelmet(GI.xWing());
                                    removeShip(player, xWing);
                                    player.updateInventory();
                                    break;
                                case 22:
                                    event.setCancelled(true);
                                    player.closeInventory();
                                    if(xWing.getSeat1().getPassengers().isEmpty()){

                                        if(customModelData == 6){
                                            rideShip(player, xWing);
                                        }else if(customModelData == 7){
                                            if(player.hasPermission("mmc.greenxwing")){
                                                rideShip(player, xWing);
                                            }else{
                                                player.sendMessage(ChatColor.RED + "The force is not with you...");
                                            }
                                        }
                                    }
                                    player.updateInventory();
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean isMobSpawningEnabled(Location location, Player player){
        LocalPlayer localPlayer = WorldGuardPlugin.inst().wrapPlayer(player);
        RegionContainer regionContainer = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionQuery query = regionContainer.createQuery();

        com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(location);

        return query.testState(loc, localPlayer, Flags.MOB_SPAWNING);
    }

}

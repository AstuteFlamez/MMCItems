package mandomc.mmcitems.vehicles;

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

    public void createShip(Player player){

        if(isMobSpawningEnabled(player.getLocation(), player) && !player.getWorld().getName().equals("BuildWorld")){

            xWing = new Vehicle();

            allXWings.add(xWing);

            Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());

            Entity seat1 = player.getWorld().spawnEntity(loc, EntityType.PHANTOM);
            Entity model = player.getWorld().spawnEntity(loc, EntityType.ZOMBIE);

            int slot = player.getInventory().getHeldItemSlot();
            player.getInventory().setItem(slot, new ItemStack(Material.AIR));

            LivingEntity livingSeat1 = (Phantom) seat1;
            LivingEntity livingModel = (Zombie) model;

            livingSeat1.setAI(false);
            livingSeat1.setInvisible(true);
            livingSeat1.setSilent(true);
            livingSeat1.setCollidable(false);
            livingSeat1.setRotation(player.getLocation().getYaw(), 0);

            livingModel.getEquipment().setHelmet(GI.xWing(), true);
            livingModel.setInvisible(true);
            livingModel.setCollidable(false);
            livingModel.setAI(false);
            livingModel.setSilent(true);
            livingModel.setRotation(player.getLocation().getYaw(), 0);

            player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You spawned in your &cX-Wing Starfighter&7!"));

            xWing.setSeat1(seat1);
            xWing.setModel(model);

            VehicleEvents.entitiesInShip.add(xWing.getSeat1());
            VehicleEvents.entitiesInShip.add(xWing.getModel());

        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou cannot spawn in your X-Wing Starfighter here!"));
        }
    }

    public void rideShip(Player player, Vehicle xWing){

        xWing.setPilot(player);

        VehicleEvents.playersInShip.add(xWing.getPilot());

        Entity seat1 = xWing.getSeat1();

        LivingEntity livingSeat1 = (Phantom) seat1;
        livingSeat1.addPassenger(player);
        livingSeat1.setAI(true);

        player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You mounted your &cX-Wing Starfighter&7!"));
    }

    public void removeShip(Player player, Vehicle xWing){

        Entity seat1 = xWing.getSeat1();
        Entity model = xWing.getModel();

        VehicleEvents.entitiesInShip.remove(seat1);
        VehicleEvents.entitiesInShip.remove(model);

        allXWings.remove(xWing);

        xWing.setPilot(null);
        xWing.setGunner(null);
        xWing.setSeat1(null);
        xWing.setSeat2(null);
        xWing.setModel(null);

        seat1.remove();
        model.remove();

        player.getInventory().addItem(GI.xWing());

        player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You dismounted your &cX-Wing Starfighter&7!"));
    }

    public void openGUI(Player player, Vehicle xWing){

        String seat1;

        if(xWing.getSeat1().getPassengers().isEmpty()){
            seat1 = ChatColor.translateAlternateColorCodes('&', "&a&lUNOCCUPIED");
        }else{
            seat1 = ChatColor.translateAlternateColorCodes('&', "&c&lOCCUPIED");
        }

        xWing.setSeat1Item(1);

        Inventory xWingGUI = Bukkit.createInventory(player, 54, ChatColor.RED + "X-Wing Starfighter");
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
    public void onPlayerInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && player.getItemInHand().getType() == Material.WOODEN_SWORD && player.getItemInHand().getItemMeta().hasCustomModelData() && player.getItemInHand().getItemMeta() != null) {
            //checks if player spawns in a ship
            if (player.getItemInHand().getItemMeta() != null && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "X-Wing Starfighter")) {
                createShip(player);
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
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {

        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();

        for(Vehicle xWing: getAllXWings()){
            if(xWing.getSeat1() == entity || xWing.getModel() == entity){
                openGUI(player, xWing);
            }
        }
    }

    @EventHandler
    public void dismount(EntityDismountEvent event){

        Entity entity = event.getDismounted();

        List<Vehicle> allXWindsCopy = new ArrayList<>(getAllXWings());
        for(Vehicle xWing: allXWindsCopy){
            if((xWing.getSeat1() == entity || xWing.getModel() == entity) && event.getEntity() instanceof Player){
                Player player = (Player) event.getEntity();
                removeShip(player, xWing);
            }
        }
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "X-Wing Starfighter") && event.getCurrentItem() != null) {
            for(Vehicle xWing : getAllXWings()) {
                if(event.getCurrentItem().getItemMeta().getCustomModelData() == xWing.getSeat1Item()){
                    switch (event.getCurrentItem().getItemMeta().getCustomModelData()){
                        case 1:
                            player.closeInventory();
                            rideShip(player, xWing);
                            break;
                    }
                }
            }
            event.setCancelled(true);
        }
    }

}

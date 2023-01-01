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

public class TieFighter implements Listener {

    private static List<Vehicle> allTieFighters = new ArrayList<>();
    public final HashMap<UUID, Long> cannonsCooldown = new HashMap<>();

    Vehicle tieFighter;

    public static List<Vehicle> getAllTieFighters(){
        return allTieFighters;
    }

    public void createShip(Player player){

        if(isMobSpawningEnabled(player.getLocation(), player) && !player.getWorld().getName().equals("BuildWorld")){

            tieFighter = new Vehicle();

            allTieFighters.add(tieFighter);

            Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());

            Entity seat1 = player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            //Entity seat1 = player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
            //Entity model = player.getWorld().spawnEntity(loc, EntityType.ZOMBIE);

            int slot = player.getInventory().getHeldItemSlot();
            player.getInventory().setItem(slot, new ItemStack(Material.AIR));

            ArmorStand armorStandSeat1 = (ArmorStand) seat1;
            //LivingEntity livingSeat1 = (Phantom) seat1;
            //LivingEntity livingModel = (Zombie) model;

            armorStandSeat1.setInvulnerable(true);
            armorStandSeat1.setGravity(false);
            armorStandSeat1.setCollidable(true);
            armorStandSeat1.setRotation(player.getLocation().getYaw(), 0);
            armorStandSeat1.setHelmet(GI.tieFighter());

            //livingSeat1.setAI(false);
            //livingSeat1.setInvisible(true);
            //livingSeat1.setSilent(true);
            //livingSeat1.setCollidable(false);
            //livingSeat1.setRotation(player.getLocation().getYaw(), 0);

            //livingModel.getEquipment().setHelmet(GI.tieFighter(), true);
            //livingModel.setInvisible(true);
            //livingModel.setCollidable(false);
            //livingModel.setAI(false);
            //livingModel.setSilent(true);
            //livingModel.setRotation(player.getLocation().getYaw(), 0);

            player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You spawned in your &8Tie-Fighter&7!"));

            tieFighter.setSeat1(seat1);
            //tieFighter.setSeat1(seat1);
            //tieFighter.setModel(model);

            VehicleEvents.entitiesInShip.add(tieFighter.getSeat1());
            //VehicleEvents.entitiesInShip.add(tieFighter.getSeat1());
            //VehicleEvents.entitiesInShip.add(tieFighter.getModel());

        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou cannot spawn in your &8Tie-Fighter &chere!"));
        }
    }

    public void rideShip(Player player, Vehicle tieFighter){

        tieFighter.setPilot(player);

        VehicleEvents.playersInShip.add(tieFighter.getPilot());

        Entity seat1 = tieFighter.getSeat1();

        ArmorStand armorStandSeat1 = (ArmorStand) seat1;

        armorStandSeat1.addPassenger(player);

        /*Entity seat1 = tieFighter.getSeat1();

        LivingEntity livingSeat1 = (Phantom) seat1;
        livingSeat1.addPassenger(player);
        livingSeat1.setAI(true);
        */

        player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You mounted your &8Tie-Fighter&7!"));
    }

    public void removeShip(Player player, Vehicle tieFighter){

        Entity seat1 = tieFighter.getSeat1();

        VehicleEvents.entitiesInShip.remove(seat1);

        //Entity seat1 = tieFighter.getSeat1();
        //Entity model = tieFighter.getModel();

        //VehicleEvents.entitiesInShip.remove(seat1);
        //VehicleEvents.entitiesInShip.remove(model);

        allTieFighters.remove(tieFighter);

        tieFighter.setPilot(null);
        tieFighter.setGunner(null);
        tieFighter.setSeat1(null);
        tieFighter.setSeat2(null);
        tieFighter.setModel(null);

        seat1.remove();

        //seat1.remove();
        //model.remove();

        player.getInventory().addItem(GI.tieFighter());

        player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You dismounted your &8Tie-Fighter&7!"));
    }

    public void openGUI(Player player, Vehicle tieFighter){

        String seat1;

        if(tieFighter.getSeat1().getPassengers().isEmpty()){
            seat1 = ChatColor.translateAlternateColorCodes('&', "&a&lUNOCCUPIED");
        }else{
            seat1 = ChatColor.translateAlternateColorCodes('&', "&c&lOCCUPIED");
        }

        tieFighter.setSeat1Item(4);

        Inventory tieFighterGUI = Bukkit.createInventory(player, 54, ChatColor.BLACK + "Tie-Fighter");
        tieFighterGUI.setItem(22, ISC.createItem(Material.WOODEN_HOE, ChatColor.translateAlternateColorCodes('&', "&e&lPilot Seat"), 4, ChatColor.GRAY + "Click to enter the pilot's seat!", "", seat1));

        player.openInventory(tieFighterGUI);
    }

    public void shootCannons(Player player) {
        if (!this.cannonsCooldown.containsKey(player.getUniqueId())) {
            this.cannonsCooldown.put(player.getUniqueId(), System.currentTimeMillis());
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + "You shot your laser cannons!");
            Location loc = player.getLocation();
            Vector direction = loc.getDirection();

            for (double t = 0; t < 128; t++) {
                loc.add(direction);

                player.getWorld().spawnParticle(Particle.REDSTONE, loc, 30, new Particle.DustOptions(Color.GREEN, 1F));

                if (loc.getBlock().getType().isSolid() || t == 127) {
                    player.getWorld().spawnParticle(Particle.CLOUD, loc, 30);
                    player.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc, 30);
                    if (isMobSpawningEnabled(loc, player)) {
                        for (Entity entity : loc.getWorld().getNearbyEntities(loc, 8.0, 8.0, 8.0)) {
                            Vector vector = RandomMethods.genVec(player.getLocation(), entity.getLocation());
                            vector.setY(1.2);
                            entity.setVelocity(vector);
                        }
                    }
                }
            }
        } else {
            long timeElapsed = System.currentTimeMillis() - cannonsCooldown.get(player.getUniqueId());
            if (timeElapsed >= 2000) {
                this.cannonsCooldown.remove(player.getUniqueId());
            } else {
                player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + "You are out of laser cannons, try again in " + ChatColor.RED + "" + ((2000 - timeElapsed) / 1000) + "" + ChatColor.GOLD + " seconds!");

            }
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && player.getItemInHand().getType() == Material.WOODEN_SWORD && player.getItemInHand().getItemMeta().hasCustomModelData() && player.getItemInHand().getItemMeta() != null) {
            //checks if player spawns in a ship
            if (player.getItemInHand().getItemMeta() != null && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.DARK_GRAY + "Tie-Fighter")) {
                createShip(player);
            }
        }
        if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            for (Vehicle tieFighter : getAllTieFighters()){
                if(tieFighter.getPilot() == player){
                    shootCannons(player);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {

        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();

        for(Vehicle tieFighter: getAllTieFighters()){
            if(tieFighter.getSeat1() == entity || tieFighter.getModel() == entity){
                openGUI(player, tieFighter);
            }
        }
    }

    @EventHandler
    public void dismount(EntityDismountEvent event){

        Entity entity = event.getDismounted();

        List<Vehicle> allTieFightersCpy = new ArrayList<>(getAllTieFighters());
        for(Vehicle tieFighter: allTieFightersCpy){
            if((tieFighter.getSeat1() == entity || tieFighter.getModel() == entity) && event.getEntity() instanceof Player){
                Player player = (Player) event.getEntity();
                removeShip(player, tieFighter);
            }
        }
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.BLACK + "Tie-Fighter") && event.getCurrentItem() != null) {
            for(Vehicle tieFighter : getAllTieFighters()) {
                if(event.getCurrentItem().getItemMeta().getCustomModelData() == tieFighter.getSeat1Item()){
                    switch (event.getCurrentItem().getItemMeta().getCustomModelData()){
                        case 4:
                            player.closeInventory();
                            if(tieFighter.getSeat1().getPassengers().isEmpty()){
                                rideShip(player, tieFighter);
                            }
                    }
                }
            }
            event.setCancelled(true);
        }
    }
}

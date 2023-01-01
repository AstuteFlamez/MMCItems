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

public class N1Starfighter implements Listener {

    private static List<Vehicle> allN1Starfighters = new ArrayList<>();
    public final HashMap<UUID, Long> cannonsCooldown = new HashMap<>();

    Vehicle n1starfighter;

    public static List<Vehicle> getAllN1Starfighters() {
        return allN1Starfighters;
    }

    public void createShip(Player player) {

        if (isMobSpawningEnabled(player.getLocation(), player) && !player.getWorld().getName().equals("BuildWorld")) {

            n1starfighter = new Vehicle();

            getAllN1Starfighters().add(n1starfighter);

            Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
            Vector vector = player.getLocation().getDirection().normalize();
            vector = vector.clone().multiply(-1);

            Entity seat1 = player.getWorld().spawnEntity(loc, EntityType.PHANTOM);
            Entity model = player.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            Entity seat2 = player.getWorld().spawnEntity(loc.add(vector), EntityType.PHANTOM);

            int slot = player.getInventory().getHeldItemSlot();
            player.getInventory().setItem(slot, new ItemStack(Material.AIR));

            LivingEntity livingSeat1 = (Phantom) seat1;
            LivingEntity livingModel = (Zombie) model;
            LivingEntity livingSeat2 = (Phantom) seat2;

            livingSeat1.setAI(false);
            //livingSeat1.setInvisible(true);
            livingSeat1.setSilent(true);
            livingSeat1.setCollidable(false);
            livingSeat1.setRotation(player.getLocation().getYaw(), 0);

            livingSeat2.setAI(false);
            //livingSeat2.setInvisible(true);

            //livingModel.getEquipment().setHelmet(GI.n1(), true);
            //livingModel.setInvisible(true);
            livingModel.setCollidable(false);
            livingModel.setAI(false);
            livingModel.setSilent(true);
            livingModel.setRotation(player.getLocation().getYaw(), 0);

            n1starfighter.setSeat1(seat1);
            n1starfighter.setModel(model);
            n1starfighter.setSeat2(seat2);

            VehicleEvents.entitiesInShip.add(n1starfighter.getSeat1());
            VehicleEvents.entitiesInShip.add(n1starfighter.getModel());
            VehicleEvents.entitiesInShip.add(n1starfighter.getSeat2());

            player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You spawned in your N-1 Starfighter!"));


        } else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou cannot spawn in your &7N-1 Starfighter &chere!"));
        }
    }

    public void rideShipAsPilot(Player player, Vehicle n1starfighter) {

        n1starfighter.setPilot(player);

        VehicleEvents.playersInShip.add(n1starfighter.getPilot());

        Entity seat1 = n1starfighter.getSeat1();
        Entity seat2 = n1starfighter.getSeat2();

        LivingEntity livingSeat1 = (Phantom) seat1;
        LivingEntity livingSeat2 = (Phantom) seat2;

        livingSeat1.addPassenger(player);
        livingSeat1.setAI(true);
        livingSeat2.setAI(true);

        player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You mounted the &epilot &7position in your N-1 Starfighter!"));
    }

    public void rideShipAsGunner(Player player, Vehicle n1starfighter) {

        n1starfighter.setGunner(player);

        VehicleEvents.playersInShip.add(n1starfighter.getGunner());

        Entity seat2 = n1starfighter.getSeat2();

        LivingEntity livingSeat2 = (Phantom) seat2;
        livingSeat2.addPassenger(player);

        player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You mounted the &6gunner &7position in your N-1 Starfighter!"));
    }

    public void removeShip(Player player, Vehicle n1starfighter) {

        Entity seat1 = n1starfighter.getSeat1();
        Entity model = n1starfighter.getModel();
        Entity seat2 = n1starfighter.getSeat2();

        VehicleEvents.entitiesInShip.remove(seat1);
        VehicleEvents.entitiesInShip.remove(model);
        VehicleEvents.entitiesInShip.remove(seat2);

        allN1Starfighters.remove(n1starfighter);

        n1starfighter.setPilot(null);
        n1starfighter.setGunner(null);
        n1starfighter.setSeat1(null);
        n1starfighter.setSeat2(null);
        n1starfighter.setModel(null);

        seat1.remove();
        model.remove();
        seat2.remove();

        player.getInventory().addItem(GI.n1());

        player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You dismounted your N-1 Starfighter!"));
    }

    public void openGUI(Player player, Vehicle n1starfighter) {

        String seat1;
        String seat2;

        if (n1starfighter.getSeat1().getPassengers().isEmpty()) {
            seat1 = ChatColor.translateAlternateColorCodes('&', "&a&lUNOCCUPIED");
        } else {
            seat1 = ChatColor.translateAlternateColorCodes('&', "&c&lOCCUPIED");
        }

        if (n1starfighter.getSeat2().getPassengers().isEmpty()) {
            seat2 = ChatColor.translateAlternateColorCodes('&', "&a&lUNOCCUPIED");
        } else {
            seat2 = ChatColor.translateAlternateColorCodes('&', "&c&lOCCUPIED");
        }

        n1starfighter.setSeat1Item(2);
        n1starfighter.setSeat2Item(3);

        Inventory n1StarfighterGUI = Bukkit.createInventory(player, 54, ChatColor.BLACK + "N-1 Starfighter");

        n1StarfighterGUI.setItem(21, ISC.createItem(Material.WOODEN_HOE, ChatColor.translateAlternateColorCodes('&', "&e&lPilot Seat"), 2, ChatColor.GRAY + "Click to enter the pilot's seat!", "", seat1));
        n1StarfighterGUI.setItem(23, ISC.createItem(Material.WOODEN_HOE, ChatColor.translateAlternateColorCodes('&', "&6&lGunner Seat"), 3, ChatColor.GRAY + "Click to enter the gunners's seat!", "", seat2));

        player.openInventory(n1StarfighterGUI);
    }

    public void shootCannons(Player player) {
        if (!this.cannonsCooldown.containsKey(player.getUniqueId())) {
            this.cannonsCooldown.put(player.getUniqueId(), System.currentTimeMillis());
            player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + "You shot your laser cannons!");
            Location loc = player.getLocation();
            Vector direction = loc.getDirection();

            for (double t = 0; t < 128; t++) {
                loc.add(direction);

                player.getWorld().spawnParticle(Particle.REDSTONE, loc, 30, new Particle.DustOptions(Color.RED, 1F));

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
            if (player.getItemInHand().getItemMeta() != null && player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "N-1 Starfighter")) {
                createShip(player);
            }
        }
        if (event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            for (Vehicle n1Starfighter : getAllN1Starfighters()){
                if(n1Starfighter.getGunner() == player){
                    shootCannons(player);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {

        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();

        for(Vehicle n1Starfighter: getAllN1Starfighters()){
            if(n1Starfighter.getSeat1() == entity || n1Starfighter.getModel() == entity || n1Starfighter.getSeat2() == entity){
                openGUI(player, n1Starfighter);
            }
        }
    }

    @EventHandler
    public void dismount(EntityDismountEvent event){

        Entity entity = event.getDismounted();

        List<Vehicle> allN1StarfightersCpy = new ArrayList<>(getAllN1Starfighters());
        for(Vehicle n1Starfighter: allN1StarfightersCpy){
            if((n1Starfighter.getSeat1() == entity || n1Starfighter.getModel() == entity) && event.getEntity() instanceof Player){
                Player player = (Player) event.getEntity();
                removeShip(player, n1Starfighter);
            }
        }
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.BLACK + "N-1 Starfighter") && event.getCurrentItem() != null) {
            for(Vehicle n1Starfighter : getAllN1Starfighters()) {
                if(event.getCurrentItem().getItemMeta().getCustomModelData() == n1Starfighter.getSeat1Item() || event.getCurrentItem().getItemMeta().getCustomModelData() == n1Starfighter.getSeat2Item() ){
                    switch (event.getCurrentItem().getItemMeta().getCustomModelData()){
                        case 2:
                            player.closeInventory();
                            rideShipAsPilot(player, n1Starfighter);
                            break;
                        case 3:
                            player.closeInventory();
                            rideShipAsGunner(player, n1Starfighter);
                            break;
                    }
                }
            }
            event.setCancelled(true);
        }
    }

}

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


public class TieFighter implements Listener {

    private static List<Vehicle> allTieFighters = new ArrayList<>();
    public final HashMap<UUID, Long> cannonsCooldown = new HashMap<>();

    Vehicle tieFighter;

    public static List<Vehicle> getAllTieFighters(){
        return allTieFighters;
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
            for (Vehicle tieFighter : getAllTieFighters()) {
                if (tieFighter.getPilot() == player) {
                    shootCannons(player);
                }
            }
        }
    }

    public void createShip(Player player){

        if(isMobSpawningEnabled(player.getLocation(), player) && !player.getWorld().getName().equals("JabbasPalace")){

            tieFighter = new Vehicle();

            Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());

            Entity seat1 = player.getWorld().spawnEntity(loc, EntityType.PHANTOM);
            Entity model = player.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);

            int slot = player.getInventory().getHeldItemSlot();
            player.getInventory().setItem(slot, new ItemStack(Material.AIR));

            LivingEntity seat1Living = (Phantom) seat1;
            ArmorStand armorStandModel = (ArmorStand) model;

            seat1Living.setAI(false);
            seat1Living.setSilent(true);
            seat1Living.setInvisible(true);
            seat1Living.setCollidable(true);
            seat1Living.setRotation(player.getLocation().getYaw(), 0);

            armorStandModel.setInvulnerable(true);
            armorStandModel.setGravity(true);
            armorStandModel.setInvisible(true);
            armorStandModel.setCollidable(true);
            armorStandModel.setRotation(player.getLocation().getYaw(), 0);
            armorStandModel.setHelmet(GI.tieFighter());

            tieFighter.setSeat1(seat1);
            tieFighter.setModel(model);

            allTieFighters.add(tieFighter);

            VehicleEvents.entitiesInShip.add(tieFighter.getSeat1());
            VehicleEvents.armorStandsInShip.add(tieFighter.getModel());

            rideShip(player, tieFighter);

        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou cannot spawn in your &8Tie-Fighter &chere!"));
        }
    }

    public void rideShip(Player player, Vehicle tieFighter){

        tieFighter.setPilot(player);

        VehicleEvents.playersInShip.add(tieFighter.getPilot());

        Entity seat1 = tieFighter.getSeat1();
        LivingEntity seat1Living = (Phantom) seat1;
        seat1Living.addPassenger(player);

        player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You mounted your &8Tie-Fighter&7!"));
    }

    public static void removeShip(Player player, Vehicle tieFighter){

        Entity seat1 = tieFighter.getSeat1();
        Entity model = tieFighter.getModel();

        VehicleEvents.entitiesInShip.remove(seat1);
        VehicleEvents.armorStandsInShip.remove(model);

        tieFighter.setPilot(null);
        tieFighter.setGunner(null);
        tieFighter.setSeat1(null);
        tieFighter.setSeat2(null);
        tieFighter.setModel(null);

        seat1.remove();
        model.remove();

        allTieFighters.remove(tieFighter);

        player.getInventory().addItem(GI.tieFighter());

        player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7You dismounted your &8Tie-Fighter&7!"));
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
    public void dismount(EntityDismountEvent event){

        Entity entity = event.getDismounted();

        List<Vehicle> allTieFightersCpy = new ArrayList<>(getAllTieFighters());
        for(Vehicle tieFighter: allTieFightersCpy){
            if(tieFighter.getSeat1() == entity && event.getEntity() instanceof Player){
                Player player = (Player) event.getEntity();
                removeShip(player, tieFighter);
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

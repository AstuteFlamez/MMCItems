package mandomc.mmcitems.listeners.vehicles;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;
import org.spigotmc.event.entity.EntityDismountEvent;

import java.util.*;

public class Ships implements Listener {

    String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » ";

    List<Entity> passiveMobs = new ArrayList<>();
    List<Player> playersInShip = new ArrayList<>();
    List<LivingEntity> entitiesInShip = new ArrayList<>();

    public static ArrayList<Entity> phantomXWings = new ArrayList<>();

    public static HashMap<Player, Entity> xWingMap = new HashMap<>();
    private final HashMap<UUID, Long> torpedoCooldown;
    public static HashMap<Entity, Entity> zombiesMap = new HashMap<>();

    public Ships(HashMap<UUID, Long> torpedoCooldown) {
        this.torpedoCooldown = torpedoCooldown;
    }

    @EventHandler
    public void mount(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && player.getItemInHand().getType() == Material.WOODEN_SWORD && player.getItemInHand().getItemMeta().hasCustomModelData()) {
            //checks if ship is an xwing
            if(player.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "X-Wing Starfighter")) {
                createShip("xwing", player, 6);
            }
        }

        if((event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK))){
            if(playersInShip.contains(player)){
                if (!this.torpedoCooldown.containsKey(player.getUniqueId())) {
                    this.torpedoCooldown.put(player.getUniqueId(), System.currentTimeMillis());
                    player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + "You shot your proton torpedo!");
                    Location loc = player.getLocation();
                    Vector direction = loc.getDirection();

                    for(double t = 0; t < 64; t++){
                        loc.add(direction);

                        player.getWorld().spawnParticle(Particle.REDSTONE, loc, 30, new Particle.DustOptions(Color.RED, 1F));

                        if(loc.getBlock().getType().isSolid()){
                            player.getWorld().spawnParticle(Particle.CLOUD, loc, 30);
                            player.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, loc, 30);
                            player.getWorld().createExplosion(loc, 1);
                        }
                    }
                } else {
                    long timeElapsed = System.currentTimeMillis() - torpedoCooldown.get(player.getUniqueId());
                    if (timeElapsed >= 5000) {
                        this.torpedoCooldown.remove(player.getUniqueId());
                    } else {
                        player.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » " + ChatColor.GOLD + "You are out of proton torpedos, try again in " + ChatColor.RED + "" + ((5000 - timeElapsed) / 1000) + "" + ChatColor.GOLD + " seconds!");

                    }
                }
            }
        }
    }

    @EventHandler
    public void dismount(EntityDismountEvent event){
        for(int i = 0; i < phantomXWings.size(); i++){
            if(event.getDismounted() == phantomXWings.get(i)){
                if(event.getEntity() instanceof Player){
                    Player player = (Player) event.getEntity();
                    leaveShip("xwing", player, 6, event.getDismounted());
                }
            }
        }
    }


    @EventHandler
    public void onTarget(EntityTargetLivingEntityEvent event){
        if(passiveMobs.contains(event.getEntity())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        for(int i = 0; i < entitiesInShip.size(); i++){
            if(event.getEntity() == entitiesInShip.get(i)){
                if(event.getCause() == EntityDamageEvent.DamageCause.FIRE || event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK){
                    event.setCancelled(true);
                }
            }
        }
    }
    @EventHandler
    public void onBurn(EntityCombustEvent event){
        for(int i = 0; i < entitiesInShip.size(); i++){
            if(event.getEntity() == entitiesInShip.get(i)){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event){

        for(Entity entity : entitiesInShip){
            if(event.getEntity() == entity){
                event.getDrops().clear();
                entitiesInShip.remove(entity);
            }
        }

    }

    public void createShip(String key, Player player, int customModelData){

        if(key.equalsIgnoreCase("xwing")){

            Entity phantom = player.getWorld().spawnEntity(player.getLocation(), EntityType.PHANTOM);
            Entity zombie = player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);

            ItemStack item = new ItemStack(Material.WOODEN_SWORD);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(ChatColor.RED + "X-Wing Starfighter");
            itemMeta.setCustomModelData(customModelData);
            item.setItemMeta(itemMeta);

            int slot = player.getInventory().getHeldItemSlot();
            player.getInventory().setItem(slot, new ItemStack(Material.AIR));

            LivingEntity livingPhantom = (Phantom) phantom;
            LivingEntity livingZombie = (Zombie) zombie;

            livingPhantom.addPassenger(player);
            livingPhantom.setInvisible(true);
            livingPhantom.setSilent(true);
            livingPhantom.setCollidable(false);

            livingZombie.getEquipment().setHelmet(item, true);
            livingZombie.setInvisible(true);
            livingZombie.setCollidable(false);
            livingZombie.setAI(false);
            livingZombie.setSilent(true);

            player.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&7You mounted your &cX-Wing Starfighter&7!"));

            playersInShip.add(player);

            passiveMobs.add(phantom);
            passiveMobs.add(zombie);

            entitiesInShip.add(livingPhantom);
            entitiesInShip.add(livingZombie);

            phantomXWings.add(phantom);

            xWingMap.put(player, phantom);
            zombiesMap.put(phantom, zombie);

        }

    }
    public void leaveShip(String key, Player player, int customModelData, Entity phantom){

        if(key.equalsIgnoreCase("xwing")){

            Entity zombie = zombiesMap.get(phantom);

            playersInShip.remove(player);

            passiveMobs.remove(phantom);
            passiveMobs.remove(zombie);

            phantomXWings.remove(phantom);

            xWingMap.remove(player);
            zombiesMap.remove(phantom);

            phantom.remove();
            zombie.remove();

            ItemStack item = new ItemStack(Material.WOODEN_SWORD);
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(ChatColor.RED + "X-Wing Starfighter");
            itemMeta.setCustomModelData(customModelData);
            item.setItemMeta(itemMeta);

            player.getInventory().addItem(item);

            player.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', "&7You dismounted your &cX-Wing Starfighter&7!"));
        }
    }
}

package mandomc.mmcitems.listeners;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.ArrayList;

public class VehicleEvents implements Listener {

    public static ArrayList<Entity> entitiesInShip = new ArrayList<>();
    public static ArrayList<Player> playersInShip = new ArrayList<>();
    public static ArrayList<Entity> armorStandsInShip = new ArrayList<>();

    @EventHandler
    public void onTarget(EntityTargetLivingEntityEvent event){
        if(entitiesInShip.contains(event.getEntity())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event){
        if((entitiesInShip.contains(event.getEntity())) && event.getCause() == EntityDamageEvent.DamageCause.FIRE || event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK || event.getCause() == EntityDamageEvent.DamageCause.SUFFOCATION){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBreak(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            if(entitiesInShip.contains(event.getEntity()) && playersInShip.contains(event.getDamager())){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBurn(EntityCombustEvent event){
        if(entitiesInShip.contains(event.getEntity())){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event){
        if(entitiesInShip.contains(event.getEntity())){
            event.getDrops().clear();
            entitiesInShip.remove(event.getEntity());
        }
    }

    @EventHandler
    public void onInteraction(PlayerInteractEntityEvent event){
        if(armorStandsInShip.contains(event.getRightClicked())){
            event.setCancelled(true);
        }
    }

}

package mandomc.mmcitems.handlers;

import mandomc.mmcitems.MMCItems;
import mandomc.mmcitems.listeners.vehicles.Ships;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ShipsRunnable extends BukkitRunnable {

    MMCItems plugin;

    public ShipsRunnable(MMCItems plugin){
        this.plugin = plugin;
    }

    @Override
    public void run() {
        //looks through all online players
        for(Player player : Bukkit.getOnlinePlayers()) {
                if(Ships.xWingMap.get(player) != null){
                    Entity entity = Ships.xWingMap.get(player);
                    entity.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                    entity.setVelocity(entity.getLocation().getDirection().multiply(1.5));
                    if(Ships.zombiesMap.get(entity) != null){
                        Entity zombie = Ships.zombiesMap.get(entity);
                        zombie.teleport(entity.getLocation());
                        zombie.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                        zombie.setVelocity(entity.getLocation().getDirection().multiply(1.5));
                    }
                }

            }

    }
}

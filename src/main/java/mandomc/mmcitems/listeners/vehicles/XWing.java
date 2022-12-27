package mandomc.mmcitems.listeners.vehicles;

import mandomc.mmcitems.MMCItems;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Objects;

public class XWing implements Listener {

    int task = 0;

    public static ArrayList<Entity> xwings = new ArrayList<>();

    @EventHandler
    public void mount(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if ((event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && player.getItemInHand().getType() == Material.DIRT) {
            for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
                if (entity instanceof Phantom) {
                    entity.addPassenger(player);
                    //((Phantom) entity).setAI(false);
                    xwings.add(entity);

                }
            }
        }
    }
    
    @EventHandler
    public void unmount(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();

        for(Entity entity : player.getNearbyEntities(15,15,15)){
            for(int i = 0; i < xwings.size(); i++){
                if(entity == xwings.get(i)){
                    xwings.remove(i);
                }
            }
        }
    }
}

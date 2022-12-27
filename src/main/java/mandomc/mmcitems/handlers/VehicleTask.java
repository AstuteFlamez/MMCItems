package mandomc.mmcitems.handlers;

import mandomc.mmcitems.MMCItems;
import mandomc.mmcitems.listeners.vehicles.XWing;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class VehicleTask extends BukkitRunnable {

    MMCItems plugin;

    public VehicleTask(MMCItems plugin){
        this.plugin = plugin;
    }

    @Override
    public void run() {
        //looks through all online players
        for(Player player : Bukkit.getOnlinePlayers()) {
            //looks through all xwing entities which are placed
            for(int i = 0; i < XWing.xwings.size(); i++){
                Entity entity = XWing.xwings.get(i);
                //looks through all xwing entities passangers
                for(int j = 0; j < entity.getPassengers().size(); j++){
                    //checks if passenger is player
                    if(entity.getPassengers().get(j) instanceof Player){
                        Player passenger = (Player) entity.getPassengers().get(j);
                        //checks if passenger = player
                        if(player.getDisplayName().equalsIgnoreCase(passenger.getDisplayName())){
                            entity.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                            entity.setVelocity(entity.getLocation().getDirection().multiply(1.5));
                        }
                    }
                }

            }
        }
    }
}

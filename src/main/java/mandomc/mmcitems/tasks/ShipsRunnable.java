package mandomc.mmcitems.tasks;

import mandomc.mmcitems.MMCItems;
import mandomc.mmcitems.vehicles.TieFighter;
import mandomc.mmcitems.vehicles.Vehicle;
import mandomc.mmcitems.vehicles.XWing;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.List;

public class ShipsRunnable extends BukkitRunnable {

    MMCItems plugin;

    public ShipsRunnable(MMCItems plugin){
        this.plugin = plugin;
    }

    @Override
    public void run() {
        //looks through all online players
        for(Player player : Bukkit.getOnlinePlayers()) {

            List<Vehicle> allTieFighters = TieFighter.getAllTieFighters();
            for (Vehicle tieFighter : allTieFighters) {
                if (tieFighter != null) {
                    if (tieFighter.getPilot() == player) {

                        Entity seat1 = tieFighter.getSeat1();
                        Entity model = tieFighter.getModel();
                        LivingEntity seat1Living = (Phantom) seat1;
                        seat1Living.setAI(true);

                        seat1.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                        seat1.setVelocity(seat1.getLocation().getDirection().multiply(2));

                        model.teleport(seat1.getLocation());
                    }
                    if(tieFighter.getPilot() == null){
                        Entity seat1 = tieFighter.getSeat1();
                        Entity model = tieFighter.getModel();

                        seat1.teleport(model);
                    }
                }
            }
            List<Vehicle> allXWings = XWing.getAllXWings();
            for (Vehicle xWing : allXWings) {
                if (xWing != null) {
                    if (xWing.getPilot() == player) {

                        Entity seat1 = xWing.getSeat1();
                        Entity model = xWing.getModel();
                        LivingEntity seat1Living = (Phantom) seat1;
                        seat1Living.setAI(true);

                        seat1.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                        seat1.setVelocity(seat1.getLocation().getDirection().multiply(1.5));

                        model.teleport(seat1.getLocation());
                    }
                    if(xWing.getPilot() == null){
                        Entity seat1 = xWing.getSeat1();
                        Entity model = xWing.getModel();

                        seat1.teleport(model);
                    }
                }
            }

        }
    }
}

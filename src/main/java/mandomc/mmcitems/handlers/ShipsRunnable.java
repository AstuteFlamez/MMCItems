package mandomc.mmcitems.handlers;

import mandomc.mmcitems.MMCItems;
import mandomc.mmcitems.vehicles.N1Starfighter;
import mandomc.mmcitems.vehicles.TieFighter;
import mandomc.mmcitems.vehicles.Vehicle;
import mandomc.mmcitems.vehicles.XWing;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
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
                        seat1.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                        seat1.setVelocity(seat1.getLocation().getDirection().multiply(2));
                        //Entity model = tieFighter.getModel();
                        //model.teleport(seat1.getLocation());
                        //model.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                    }
                }
            }
            List<Vehicle> allXWings = XWing.getAllXWings();
            for (Vehicle xWing : allXWings) {
                if (xWing != null) {
                    if (xWing.getPilot() == player) {
                        Entity seat1 = xWing.getSeat1();
                        seat1.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                        seat1.setVelocity(seat1.getLocation().getDirection().multiply(1.5));
                        Entity model = xWing.getModel();
                        model.teleport(seat1.getLocation());
                        model.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                    }
                }
            }

            List<Vehicle> allN1 = N1Starfighter.getAllN1Starfighters();
            for (Vehicle n1 : allN1) {
                if (n1 != null) {
                    if (n1.getPilot() == player) {
                        Entity seat1 = n1.getSeat1();
                        seat1.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                        seat1.setVelocity(seat1.getLocation().getDirection().multiply(1.5));

                        Entity model = n1.getModel();
                        model.teleport(seat1.getLocation());
                        model.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                        //zombie.setVelocity(entity.getLocation().getDirection().multiply(1.5));

                        if (n1.getSeat2() != null) {

                            Entity seat2 = n1.getSeat2();
                            Player gunner = n1.getGunner();

                            LivingEntity livingSeat2 = (Phantom) seat2;

                            if (livingSeat2.getPassengers().contains(gunner)) {
                                //livingSeat2.removePassenger(gunner);

                                Vector vector = player.getLocation().getDirection().normalize();
                                vector = vector.clone().multiply(-1);

                                int x = vector.getBlockX();
                                int y = vector.getBlockY();
                                int z = vector.getBlockZ();

                                Location newLoc = new Location(player.getWorld(), x, y, z);

                                //if(seat2.getLocation().distance(seat1.getLocation()) > 1)
                                seat2.teleport(newLoc);
                                //}

                                livingSeat2.addPassenger(gunner);
                                seat2.setRotation(gunner.getLocation().getYaw(), gunner.getLocation().getPitch());
                                seat2.setVelocity(seat1.getLocation().getDirection().multiply(1.5));
                            } else {
                                Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());
                                Vector vector = player.getLocation().getDirection().normalize();
                                vector = vector.clone().multiply(-1);
                                seat2.teleport(loc.add(vector));
                                seat2.setRotation(player.getLocation().getYaw(), player.getLocation().getPitch());
                                seat2.setVelocity(seat1.getLocation().getDirection().multiply(1.5));
                            }

                        }
                    }
                }

            }

        }
    }
}

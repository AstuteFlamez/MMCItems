package mandomc.mmcitems.listeners;

import mandomc.mmcitems.handlers.GI;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class BleedEvent implements Listener {

    @EventHandler
    public void bleedCrystal(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getHand() == EquipmentSlot.HAND){
            if(player.getWorld().getName().equalsIgnoreCase("Mustafar")){
                if(event.getClickedBlock() != null){
                    if(event.getClickedBlock().getLocation().getX() == -3 && event.getClickedBlock().getLocation().getY() == 62 && event.getClickedBlock().getLocation().getZ() == -48) {
                        if(player.getInventory().getItemInMainHand().getType() == Material.NETHER_STAR && (Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getCustomModelData() == 2 ||
                                Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getCustomModelData() == 3 ||
                                Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getCustomModelData() == 4 ||
                                Objects.requireNonNull(player.getInventory().getItemInMainHand().getItemMeta()).getCustomModelData() == 5)){
                            if(player.getInventory().getItemInMainHand().getAmount() > 1){
                                ItemStack kybers = new ItemStack(player.getInventory().getItemInMainHand());
                                kybers.setAmount(kybers.getAmount() - 1);
                                player.getInventory().setItem(player.getInventory().getHeldItemSlot(), kybers);
                                player.getInventory().addItem(GI.redKyber());
                            }else if(player.getInventory().getItemInMainHand().getAmount() == 1){
                                player.getInventory().setItem(player.getInventory().getHeldItemSlot(), GI.redKyber());
                            }
                            summonCircle(new Location(player.getWorld(), -2.5, 63, -47.5), 1);
                            player.playSound(new Location(player.getWorld(), -3, 63, -48), Sound.ENTITY_ENDER_DRAGON_HURT, 10, 1);
                        }
                    }
                }
            }
        }
    }

    public void summonCircle(Location location, int size) {
        for (int d = 0; d <= 90; d += 1) {
            Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
            particleLoc.setX(location.getX() + Math.cos(d) * size);
            particleLoc.setZ(location.getZ() + Math.sin(d) * size);
            location.getWorld().spawnParticle(Particle.REDSTONE, particleLoc, 1, new Particle.DustOptions(Color.RED, 5));
        }
    }
}

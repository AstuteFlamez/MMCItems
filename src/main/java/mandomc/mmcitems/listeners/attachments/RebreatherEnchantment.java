package mandomc.mmcitems.listeners.attachments;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.enchantments.EnchantmentWrapper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class RebreatherEnchantment extends Enchantment implements Listener {

    public RebreatherEnchantment(NamespacedKey x) {
        super(x);
    }

    @Override
    public String getName() {
        return "Rebreather";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ARMOR_HEAD;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        // allow the enchantment to be applied only to helmet items
        return item.getType().name().contains("HELMET");
    }

    /*@Override
    public boolean conflictsWith(Enchantment other) {
        // make the enchantment incompatible with the Aqua Infinity and Protection enchantments
        return other.getName().equals("Aqua Infinity") || other.getName().equals("Protection");
    }*/

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @EventHandler
    public void onDrown(EntityDamageEvent event){

        Entity entity = event.getEntity();

        if(entity instanceof Player){
            Player player = (Player) entity;
            if(event.getCause() == EntityDamageEvent.DamageCause.DROWNING && player.getInventory().getHelmet() != null) {
                player.sendMessage("e");
                ItemStack helmet = player.getInventory().getHelmet();
                if (helmet.containsEnchantment(this)) {
                    player.sendMessage("e");
                    event.setCancelled(true);
                }
            }
        }

    }
}

package mandomc.mmcitems.handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class LISC {

    public static ItemStack createItem(String displayName, int customModelData, String nameSpacedKey, ItemStack kyber, ItemStack core, ItemStack hilt){

        ItemStack i = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(displayName);
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        /*rLL.add(ChatColor.GOLD + "Ability: Block ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " RIGHT CLICK");*/
        iM.setLore(iL);
        iM.setCustomModelData(customModelData);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft(nameSpacedKey), i);
        recipe.shape(" C ",
                " L ",
                " H ");
        recipe.setIngredient('C', new RecipeChoice.ExactChoice(kyber));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(core));
        recipe.setIngredient('H', new RecipeChoice.ExactChoice(hilt));
        Bukkit.getServer().addRecipe(recipe);
        return  i;
    }

}

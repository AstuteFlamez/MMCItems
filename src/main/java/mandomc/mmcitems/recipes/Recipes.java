package mandomc.mmcitems.recipes;

import mandomc.mmcitems.handlers.LISC;
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

public class Recipes {

    public static void init(){createRecipe();}

    private static void createRecipe(){

        ItemStack crossGuardHilt = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta crossGuardMeta = crossGuardHilt.getItemMeta();
        crossGuardMeta.setDisplayName(ChatColor.GRAY + "Crossguard Hilt");
        crossGuardMeta.setCustomModelData(3);
        crossGuardMeta.setUnbreakable(true);
        crossGuardMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        crossGuardHilt.setItemMeta(crossGuardMeta);
        ShapedRecipe recipe = new ShapedRecipe(NamespacedKey.minecraft("crossguardhilt"), crossGuardHilt);
        recipe.shape("SN ",
                "NIR",
                " GN");
        recipe.setIngredient('S', Material.NETHERITE_SCRAP);
        recipe.setIngredient('N', Material.NETHERITE_INGOT);
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('G', Material.GLOWSTONE);
        Bukkit.getServer().addRecipe(recipe);

        ItemStack doubleBladedHilt = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta doubleBladedHiltItemMeta = doubleBladedHilt.getItemMeta();
        doubleBladedHiltItemMeta.setDisplayName(ChatColor.GRAY + "Double-Bladed Hilt");
        doubleBladedHiltItemMeta.setCustomModelData(4);
        doubleBladedHiltItemMeta.setUnbreakable(true);
        doubleBladedHiltItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        doubleBladedHilt.setItemMeta(doubleBladedHiltItemMeta);
        ShapedRecipe doubleBladedHiltRecipe = new ShapedRecipe(NamespacedKey.minecraft("doublebladedhilt"), doubleBladedHilt);
        doubleBladedHiltRecipe.shape("NI ",
                "IRI",
                " IN");
        doubleBladedHiltRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        doubleBladedHiltRecipe.setIngredient('I', Material.IRON_INGOT);
        doubleBladedHiltRecipe.setIngredient('R', Material.REDSTONE);
        Bukkit.getServer().addRecipe(doubleBladedHiltRecipe);

        ItemStack singleBladedHilt = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta singleBladedHiltItemMeta = singleBladedHilt.getItemMeta();
        singleBladedHiltItemMeta.setDisplayName(ChatColor.GRAY + "Single-Bladed Hilt");
        singleBladedHiltItemMeta.setCustomModelData(5);
        singleBladedHiltItemMeta.setUnbreakable(true);
        singleBladedHiltItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        singleBladedHilt.setItemMeta(singleBladedHiltItemMeta);
        ShapedRecipe singleBladedHiltRecipe = new ShapedRecipe(NamespacedKey.minecraft("singlebladedhilt"), singleBladedHilt);
        singleBladedHiltRecipe.shape("NR ",
                "IIN",
                " NN");
        singleBladedHiltRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        singleBladedHiltRecipe.setIngredient('I', Material.IRON_INGOT);
        singleBladedHiltRecipe.setIngredient('R', Material.REDSTONE);
        Bukkit.getServer().addRecipe(singleBladedHiltRecipe);

        ItemStack core = new ItemStack(Material.BEACON);
        ItemMeta coreMeta = core.getItemMeta();
        coreMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core"));
        core.setItemMeta(coreMeta);
        ShapedRecipe coreRecipe = new ShapedRecipe(NamespacedKey.minecraft("core"), core);
        coreRecipe.shape("INI", "BSB", "INI");
        coreRecipe.setIngredient('S', Material.NETHER_STAR);
        coreRecipe.setIngredient('B', Material.NETHERITE_BLOCK);
        coreRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        coreRecipe.setIngredient('I', Material.IRON_INGOT);
        Bukkit.getServer().addRecipe(coreRecipe);

        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&c&lCrossguard Lightsaber"), 13, "redcrossguardlightsaber", Material.RED_STAINED_GLASS_PANE, core, crossGuardHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&9&lCrossguard Lightsaber"), 14, "bluecrossguardlightsaber", Material.BLUE_STAINED_GLASS_PANE, core, crossGuardHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&a&lCrossguard Lightsaber"), 15, "greencrossguardlightsaber", Material.GREEN_STAINED_GLASS_PANE, core, crossGuardHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&5&lCrossguard Lightsaber"), 16, "purplecrossguardlightsaber", Material.PURPLE_STAINED_GLASS_PANE, core, crossGuardHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&e&lCrossguard Lightsaber"), 17, "yellowcrossguardlightsaber", Material.YELLOW_STAINED_GLASS_PANE, core, crossGuardHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&f&lCrossguard Lightsaber"), 18, "whitecrossguardlightsaber", Material.WHITE_STAINED_GLASS_PANE, core, crossGuardHilt);

        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&c&lDouble-Bladed Lightsaber"), 1, "reddoublebladedlightsaber", Material.RED_STAINED_GLASS_PANE, core, doubleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&9&lDouble-Bladed Lightsaber"), 2, "bluedoublebladedlightsaber", Material.BLUE_STAINED_GLASS_PANE, core, doubleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&a&lDouble-Bladed Lightsaber"), 3, "greendoublebladedlightsaber", Material.GREEN_STAINED_GLASS_PANE, core, doubleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&5&lDouble-Bladed Lightsaber"), 4, "purpledoublebladedlightsaber", Material.PURPLE_STAINED_GLASS_PANE, core, doubleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&e&lDouble-Bladed Lightsaber"), 5, "yellowdoublebladedlightsaber", Material.YELLOW_STAINED_GLASS_PANE, core, doubleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&f&lDouble-Bladed Lightsaber"), 6, "whitedoublebladedlightsaber", Material.WHITE_STAINED_GLASS_PANE, core, doubleBladedHilt);

        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&c&lSingle-Bladed Lightsaber"), 7, "redsinglebladedlightsaber", Material.RED_STAINED_GLASS_PANE, core, singleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&9&lSingle-Bladed Lightsaber"), 8, "bluesinglebladedlightsaber", Material.BLUE_STAINED_GLASS_PANE, core, singleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&a&lSingle-Bladed Lightsaber"), 9, "greensinglebladedlightsaber", Material.GREEN_STAINED_GLASS_PANE, core, singleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&5&lSingle-Bladed Lightsaber"), 10, "purplesinglebladedlightsaber", Material.PURPLE_STAINED_GLASS_PANE, core, singleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&e&lSingle-Bladed Lightsaber"), 11, "yellowsinglebladedlightsaber", Material.YELLOW_STAINED_GLASS_PANE, core, singleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&f&lSingle-Bladed Lightsaber"), 12, "whitesinglebladedlightsaber", Material.WHITE_STAINED_GLASS_PANE, core, singleBladedHilt);


    }

}
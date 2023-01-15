package mandomc.mmcitems.recipes;

import mandomc.mmcitems.handlers.GI;
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

        ItemStack redKyber = GI.redKyber();
        ShapedRecipe redKyberRecipe = new ShapedRecipe(NamespacedKey.minecraft("redkyber"), redKyber);
        redKyberRecipe.shape("PPP", "PKP", "PPP");
        redKyberRecipe.setIngredient('P', Material.RED_STAINED_GLASS_PANE);
        redKyberRecipe.setIngredient('K', new RecipeChoice.ExactChoice(GI.kyberite()));
        Bukkit.getServer().addRecipe(redKyberRecipe);

        ItemStack blueKyber = GI.blueKyber();
        ShapedRecipe blueKyberRecipe = new ShapedRecipe(NamespacedKey.minecraft("bluekyber"), blueKyber);
        blueKyberRecipe.shape("PPP", "PKP", "PPP");
        blueKyberRecipe.setIngredient('P', Material.BLUE_STAINED_GLASS_PANE);
        blueKyberRecipe.setIngredient('K', new RecipeChoice.ExactChoice(GI.kyberite()));
        Bukkit.getServer().addRecipe(blueKyberRecipe);

        ItemStack greenKyber = GI.greenKyber();
        ShapedRecipe greenKyberRecipe = new ShapedRecipe(NamespacedKey.minecraft("greenkyber"), greenKyber);
        greenKyberRecipe.shape("PPP", "PKP", "PPP");
        greenKyberRecipe.setIngredient('P', Material.GREEN_STAINED_GLASS);
        greenKyberRecipe.setIngredient('K', new RecipeChoice.ExactChoice(GI.kyberite()));
        Bukkit.getServer().addRecipe(greenKyberRecipe);

        ItemStack purpleKyber = GI.purpleKyber();
        ShapedRecipe purpleKyberRecipe = new ShapedRecipe(NamespacedKey.minecraft("purplekyber"), purpleKyber);
        purpleKyberRecipe.shape("PPP", "PKP", "PPP");
        purpleKyberRecipe.setIngredient('P', Material.PURPLE_STAINED_GLASS_PANE);
        purpleKyberRecipe.setIngredient('K', new RecipeChoice.ExactChoice(GI.kyberite()));
        Bukkit.getServer().addRecipe(purpleKyberRecipe);

        ItemStack yellowKyber = GI.yellowKyber();
        ShapedRecipe yellowKyberRecipe = new ShapedRecipe(NamespacedKey.minecraft("yellowkyber"), yellowKyber);
        yellowKyberRecipe.shape("PPP", "PKP", "PPP");
        yellowKyberRecipe.setIngredient('P', Material.YELLOW_STAINED_GLASS_PANE);
        yellowKyberRecipe.setIngredient('K', new RecipeChoice.ExactChoice(GI.kyberite()));
        Bukkit.getServer().addRecipe(yellowKyberRecipe);

        ItemStack whiteKyber = GI.whiteKyber();
        ShapedRecipe whiteKyberRecipe = new ShapedRecipe(NamespacedKey.minecraft("whitekyber"), whiteKyber);
        whiteKyberRecipe.shape("PPP", "PKP", "PPP");
        whiteKyberRecipe.setIngredient('P', Material.WHITE_STAINED_GLASS_PANE);
        whiteKyberRecipe.setIngredient('K', new RecipeChoice.ExactChoice(GI.kyberite()));
        Bukkit.getServer().addRecipe(whiteKyberRecipe);

        ItemStack crossGuardHilt = GI.crossGuardHilt();
        ShapedRecipe crossGuardHiltRecipe = new ShapedRecipe(NamespacedKey.minecraft("crossguardhilt"), crossGuardHilt);
        crossGuardHiltRecipe.shape("SN ",
                "NIR",
                " GN");
        crossGuardHiltRecipe.setIngredient('S', Material.NETHERITE_SCRAP);
        crossGuardHiltRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        crossGuardHiltRecipe.setIngredient('I', Material.IRON_INGOT);
        crossGuardHiltRecipe.setIngredient('R', Material.REDSTONE);
        crossGuardHiltRecipe.setIngredient('G', Material.GLOWSTONE);
        Bukkit.getServer().addRecipe(crossGuardHiltRecipe);

        ItemStack doubleBladedHilt = GI.doubleBladedHilt();
        ShapedRecipe doubleBladedHiltRecipe = new ShapedRecipe(NamespacedKey.minecraft("doublebladedhilt"), doubleBladedHilt);
        doubleBladedHiltRecipe.shape("NI ",
                "IRI",
                " IN");
        doubleBladedHiltRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        doubleBladedHiltRecipe.setIngredient('I', Material.IRON_INGOT);
        doubleBladedHiltRecipe.setIngredient('R', Material.REDSTONE);
        Bukkit.getServer().addRecipe(doubleBladedHiltRecipe);

        ItemStack singleBladedHilt = GI.singleBladedHilt();
        ShapedRecipe singleBladedHiltRecipe = new ShapedRecipe(NamespacedKey.minecraft("singlebladedhilt"), singleBladedHilt);
        singleBladedHiltRecipe.shape("NR ",
                "IIN",
                " NN");
        singleBladedHiltRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        singleBladedHiltRecipe.setIngredient('I', Material.IRON_INGOT);
        singleBladedHiltRecipe.setIngredient('R', Material.REDSTONE);
        Bukkit.getServer().addRecipe(singleBladedHiltRecipe);

        ItemStack core = GI.lightsaberCore();
        ShapedRecipe coreRecipe = new ShapedRecipe(NamespacedKey.minecraft("core"), core);
        coreRecipe.shape("INI", "BSB", "INI");
        coreRecipe.setIngredient('S', Material.NETHER_STAR);
        coreRecipe.setIngredient('B', Material.NETHERITE_BLOCK);
        coreRecipe.setIngredient('N', Material.IRON_BLOCK);
        coreRecipe.setIngredient('I', Material.IRON_INGOT);
        Bukkit.getServer().addRecipe(coreRecipe);

        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&c&lCrossguard Lightsaber"), 13, "redcrossguardlightsaber", redKyber, core, crossGuardHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&9&lCrossguard Lightsaber"), 14, "bluecrossguardlightsaber", blueKyber, core, crossGuardHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&a&lCrossguard Lightsaber"), 15, "greencrossguardlightsaber", greenKyber, core, crossGuardHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&5&lCrossguard Lightsaber"), 16, "purplecrossguardlightsaber", purpleKyber, core, crossGuardHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&e&lCrossguard Lightsaber"), 17, "yellowcrossguardlightsaber", yellowKyber, core, crossGuardHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&f&lCrossguard Lightsaber"), 18, "whitecrossguardlightsaber", GI.whiteKyber(), core, crossGuardHilt);

        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&c&lDouble-Bladed Lightsaber"), 1, "reddoublebladedlightsaber", redKyber, core, doubleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&9&lDouble-Bladed Lightsaber"), 2, "bluedoublebladedlightsaber", blueKyber, core, doubleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&a&lDouble-Bladed Lightsaber"), 3, "greendoublebladedlightsaber", greenKyber, core, doubleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&5&lDouble-Bladed Lightsaber"), 4, "purpledoublebladedlightsaber", purpleKyber, core, doubleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&e&lDouble-Bladed Lightsaber"), 5, "yellowdoublebladedlightsaber", yellowKyber, core, doubleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&f&lDouble-Bladed Lightsaber"), 6, "whitedoublebladedlightsaber", GI.whiteKyber(), core, doubleBladedHilt);

        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&c&lSingle-Bladed Lightsaber"), 7, "redsinglebladedlightsaber", redKyber, core, singleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&9&lSingle-Bladed Lightsaber"), 8, "bluesinglebladedlightsaber", blueKyber, core, singleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&a&lSingle-Bladed Lightsaber"), 9, "greensinglebladedlightsaber", greenKyber, core, singleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&5&lSingle-Bladed Lightsaber"), 10, "purplesinglebladedlightsaber", purpleKyber, core, singleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&e&lSingle-Bladed Lightsaber"), 11, "yellowsinglebladedlightsaber", yellowKyber, core, singleBladedHilt);
        LISC.createItem(ChatColor.translateAlternateColorCodes('&', "&f&lSingle-Bladed Lightsaber"), 12, "whitesinglebladedlightsaber", GI.whiteKyber(), core, singleBladedHilt);


    }

}
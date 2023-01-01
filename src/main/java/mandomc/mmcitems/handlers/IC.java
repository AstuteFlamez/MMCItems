package mandomc.mmcitems.handlers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class IC {

    public static Inventory recipes(Player player){
        Inventory recipes = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Recipes");

        recipes.setItem(0, ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weapon Recipes", 1, ChatColor.GRAY + "Inside you will find weapons from a more civilized age!"));
        recipes.setItem(1, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&2&lParts Recipes"),2,ChatColor.GRAY + "Use these recipes to create larger items!"));
        recipes.setItem(8, ISC.createItem(Material.BARRIER, ChatColor.translateAlternateColorCodes('&', "&c&lCLOSE")));
        return recipes;
    }

    public static Inventory weapons(Player player){
        Inventory weapons = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weapon Recipes");

        weapons.setItem(0, ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Lightsabers", 1, ChatColor.GRAY + "The ancient weapon of force users..."));
        weapons.setItem(7, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back!"));
        weapons.setItem(8, ISC.createItem(Material.BARRIER, ChatColor.translateAlternateColorCodes('&', "&c&lCLOSE")));
        return weapons;
    }

    public static Inventory parts(Player player){
        Inventory parts = Bukkit.createInventory(player, 9, ChatColor.translateAlternateColorCodes('&', "&2&lParts Recipes"));

        parts.setItem(0, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Crossguard Hilt"), 3));
        parts.setItem(1, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Double-Bladed Hilt"), 4));
        parts.setItem(2, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Single-Bladed Hilt"), 5));
        parts.setItem(3, ISC.createItem(Material.BEACON, ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core")));
        parts.setItem(4, ISC.createItem(Material.NETHER_STAR, ChatColor.WHITE + "Kyber Crystal"));
        parts.setItem(7, ISC.createItem(Material.ARROW, ChatColor.translateAlternateColorCodes('&', "&c&lBack"), ChatColor.translateAlternateColorCodes('&', "&7Click to go back!")));
        parts.setItem(8, ISC.createItem(Material.BARRIER, ChatColor.translateAlternateColorCodes('&', "&c&lCLOSE")));
        return parts;
    }

    public static Inventory lightsabers(Player player){
        Inventory sabers = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Recipes");

        sabers.setItem(0, ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crossguard Lightsaber Recipes", 13, ChatColor.GRAY + "An ancient lightsaber design for force users..."));
        sabers.setItem(1, ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Double-Bladed Lightsaber Recipes", 1, ChatColor.GRAY + "Designed to be a more agile saber."));
        sabers.setItem(2, ISC.createItem(Material.NETHERITE_SWORD, ChatColor.BLUE + "" + ChatColor.BOLD + "Single-Bladed Lightsaber Recipes", 8, ChatColor.GRAY + "Basic, but good too."));
        sabers.setItem(7, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back!"));
        sabers.setItem(8, ISC.createItem(Material.BARRIER, ChatColor.translateAlternateColorCodes('&', "&c&lCLOSE")));
        return sabers;
    }

    public static Inventory crossGuardHilt(Player player){
        Inventory crossGuardHilt = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Crossguard Hilt Recipe");

        crossGuardHilt.setItem(10, ISC.createItem(Material.NETHERITE_SCRAP));
        crossGuardHilt.setItem(11, ISC.createItem(Material.NETHERITE_INGOT));
        crossGuardHilt.setItem(19, ISC.createItem(Material.NETHERITE_INGOT));
        crossGuardHilt.setItem(20, ISC.createItem(Material.IRON_INGOT));
        crossGuardHilt.setItem(21, ISC.createItem(Material.REDSTONE));
        crossGuardHilt.setItem(25, ISC.createItem(Material.WOODEN_SWORD, ChatColor.GRAY + "Crossguard Hilt", 3));
        crossGuardHilt.setItem(29, ISC.createItem(Material.GLOWSTONE));
        crossGuardHilt.setItem(30, ISC.createItem(Material.NETHERITE_INGOT));
        crossGuardHilt.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
        crossGuardHilt.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
        crossGuardHilt.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));
        return crossGuardHilt;
    }

    public static Inventory doubleBladedHilt(Player player){
        Inventory dbHilt = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Double-Bladed Hilt Recipe");

        dbHilt.setItem(10, ISC.createItem(Material.NETHERITE_INGOT));
        dbHilt.setItem(11, ISC.createItem(Material.IRON_INGOT));
        dbHilt.setItem(19, ISC.createItem(Material.IRON_INGOT));
        dbHilt.setItem(20, ISC.createItem(Material.REDSTONE));
        dbHilt.setItem(21, ISC.createItem(Material.IRON_INGOT));
        dbHilt.setItem(25, ISC.createItem(Material.WOODEN_SWORD, ChatColor.GRAY + "Double-Bladed Hilt", 4));
        dbHilt.setItem(29, ISC.createItem(Material.IRON_INGOT));
        dbHilt.setItem(30, ISC.createItem(Material.NETHERITE_INGOT));
        dbHilt.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
        dbHilt.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
        dbHilt.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));
        return dbHilt;
    }

    public static Inventory singleBladedHilt(Player player){
        Inventory sHilt = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Single-Bladed Hilt Recipe");

        sHilt.setItem(10, ISC.createItem(Material.NETHERITE_INGOT));
        sHilt.setItem(11, ISC.createItem(Material.REDSTONE));
        sHilt.setItem(19, ISC.createItem(Material.IRON_INGOT));
        sHilt.setItem(20, ISC.createItem(Material.IRON_INGOT));
        sHilt.setItem(21, ISC.createItem(Material.NETHERITE_INGOT));
        sHilt.setItem(25, ISC.createItem(Material.WOODEN_SWORD, ChatColor.GRAY + "Single-Bladed Hilt", 5));
        sHilt.setItem(29, ISC.createItem(Material.NETHERITE_INGOT));
        sHilt.setItem(30, ISC.createItem(Material.NETHERITE_INGOT));
        sHilt.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
        sHilt.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
        sHilt.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));
        return sHilt;
    }

    public static Inventory lightsaberCore(Player player){
        Inventory core = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Core Recipe");

        core.setItem(10, ISC.createItem(Material.IRON_INGOT));
        core.setItem(11, ISC.createItem(Material.NETHERITE_INGOT));
        core.setItem(12, ISC.createItem(Material.IRON_INGOT));
        core.setItem(19, ISC.createItem(Material.NETHERITE_BLOCK));
        core.setItem(20, ISC.createItem(Material.NETHER_STAR));
        core.setItem(21, ISC.createItem(Material.NETHERITE_BLOCK));
        core.setItem(25, ISC.createItem(Material.BEACON, ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core")));
        core.setItem(28, ISC.createItem(Material.IRON_INGOT));
        core.setItem(29, ISC.createItem(Material.NETHERITE_INGOT));
        core.setItem(30, ISC.createItem(Material.IRON_INGOT));
        core.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table",  ChatColor.GRAY + "Craft this recipe using a work bench!"));
        core.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back",  ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
        core.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));
        return core;
    }
}

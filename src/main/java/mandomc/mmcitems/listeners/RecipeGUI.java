package mandomc.mmcitems.listeners;

import mandomc.mmcitems.handlers.ISC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class RecipeGUI implements Listener {

    List<Inventory> crossGuardInvs = new ArrayList<>();
    public static ItemStack[] crossGuardContents;
    public static ItemStack[] crossGuardContents2;
    private int crossGuardItemIndex = 0;
    private int crossGuardItemIndex2 = 0;

    List<Inventory> dBInvs = new ArrayList<>();
    public static ItemStack[] dBContents;
    public static ItemStack[] dBContents2;
    private int dBItemIndex = 0;
    private int dBItemIndex2 = 0;

    List<Inventory> sInvs = new ArrayList<>();
    public static ItemStack[] sContents;
    public static ItemStack[] sContents2;
    private int sItemIndex = 0;
    private int sItemIndex2 = 0;

    private final JavaPlugin plugin;

    public RecipeGUI(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null) {
            return;
        }

        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta cIM = close.getItemMeta();
        cIM.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "CLOSE");
        close.setItemMeta(cIM);

        Inventory recipes = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Recipes");

        recipes.setItem(0, ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weapon Recipes", 1, ChatColor.GRAY + "Inside you will find weapons from a more civilized age!"));
        recipes.setItem(1, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&2&lParts Recipes"),2,ChatColor.GRAY + "Use these recipes to create larger items!"));
        recipes.setItem(8, close);

        Inventory weapons = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weapon Recipes");

        weapons.setItem(0, ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Lightsabers", 1, ChatColor.GRAY + "The ancient weapon of force users..."));
        weapons.setItem(7, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back!"));
        weapons.setItem(8, close);

        Inventory sabers = Bukkit.createInventory(player, 9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Recipes");

        sabers.setItem(0, ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crossguard Lightsaber Recipes", 13, ChatColor.GRAY + "An ancient lightsaber design for force users..."));
        sabers.setItem(1, ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Double-Bladed Lightsaber Recipes", 1, ChatColor.GRAY + "Designed to be a more agile saber."));
        sabers.setItem(2, ISC.createItem(Material.NETHERITE_SWORD, ChatColor.BLUE + "" + ChatColor.BOLD + "Single-Bladed Lightsaber Recipes", 8, ChatColor.GRAY + "Basic, but good too."));
        sabers.setItem(7, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", 0, ChatColor.GRAY + "Click to go back!"));
        sabers.setItem(8, close);

        Inventory parts = Bukkit.createInventory(player, 9, ChatColor.translateAlternateColorCodes('&', "&2&lParts Recipes"));

        //parts.setItem(0, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Dooku's Hilt"), 0));
        //parts.setItem(1, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Inquisitor's Hilt"), 1));
        parts.setItem(0, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Crossguard Hilt"), 3));
        parts.setItem(1, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Double-Bladed Hilt"), 4));
        parts.setItem(2, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&7Single-Bladed Hilt"), 5));
        parts.setItem(3, ISC.createItem(Material.BEACON, ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core")));
        parts.setItem(7, ISC.createItem(Material.ARROW, ChatColor.translateAlternateColorCodes('&', "&c&lBack"), ChatColor.translateAlternateColorCodes('&', "&7Click to go back!")));
        parts.setItem(8, close);

        /*Inventory dookuHilt = Bukkit.createInventory(player, 54, ChatColor.GRAY + "Dooku's Hilt Recipe");

        dookuHilt.setItem(10, ISC.createItem(Material.IRON_BARS));
        dookuHilt.setItem(11, ISC.createItem(Material.IRON_INGOT));
        dookuHilt.setItem(19, ISC.createItem(Material.IRON_INGOT));
        dookuHilt.setItem(20, ISC.createItem(Material.NETHERITE_INGOT));
        dookuHilt.setItem(21, ISC.createItem(Material.IRON_INGOT));
        dookuHilt.setItem(29, ISC.createItem(Material.IRON_INGOT));
        dookuHilt.setItem(30, ISC.createItem(Material.NETHERITE_SCRAP));
        dookuHilt.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", 0, ChatColor.GRAY + "Craft this recipe using a work bench!"));
        dookuHilt.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", 0, ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
        dookuHilt.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));
         */

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

        Inventory core = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Core");

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


        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Recipes")) {
            switch (event.getCurrentItem().getType()) {
                case NETHERITE_SWORD:
                    player.openInventory(weapons);
                    break;
                case WOODEN_SWORD:
                    player.openInventory(parts);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weapon Recipes")) {
            switch (event.getCurrentItem().getType()) {
                case NETHERITE_SWORD:
                    player.openInventory(sabers);
                    break;
                case ARROW:
                    player.openInventory(recipes);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
            }
            event.setCancelled(true);
        }

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Recipes")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(weapons);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4&lCrossguard Lightsaber Recipes"))){
                spinCrossguard(player);
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4&lDouble-Bladed Lightsaber Recipes"))){
                spinDB(player);
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&9&lSingle-Bladed Lightsaber Recipes"))){
                spinS(player);
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crossguard Lightsaber Recipes")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(sabers);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case CRAFTING_TABLE:
                    player.openWorkbench(null, true);
                    break;
                case WOODEN_SWORD:
                    player.openInventory(crossGuardHilt);
                    break;
                case BEACON:
                    player.openInventory(core);
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Double-Bladed Lightsaber Recipes")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(sabers);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case CRAFTING_TABLE:
                    player.openWorkbench(null, true);
                    break;
                case WOODEN_SWORD:
                    player.openInventory(dbHilt);
                    break;
                case BEACON:
                    player.openInventory(core);
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "" + ChatColor.BOLD + "Single-Bladed Lightsaber Recipes")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(sabers);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case CRAFTING_TABLE:
                    player.openWorkbench(null, true);
                    break;
                case WOODEN_SWORD:
                    player.openInventory(sHilt);
                    break;
                case BEACON:
                    player.openInventory(core);
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Parts Recipes")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(recipes);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&7Crossguard Hilt"))){
                player.openInventory(crossGuardHilt);
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&7Double-Bladed Hilt"))){
                player.openInventory(dbHilt);
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&7Single-Bladed Hilt"))){
                player.openInventory(sHilt);
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core"))){
                player.openInventory(core);
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Crossguard Hilt Recipe")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(parts);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case CRAFTING_TABLE:
                    player.openWorkbench(null, true);
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Double-Bladed Hilt Recipe")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(parts);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case CRAFTING_TABLE:
                    player.openWorkbench(null, true);
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Single-Bladed Hilt Recipe")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(parts);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case CRAFTING_TABLE:
                    player.openWorkbench(null, true);
                    break;
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Core")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(parts);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case CRAFTING_TABLE:
                    player.openWorkbench(null, true);
                    break;
            }
            event.setCancelled(true);
        }

    }

    public void shuffleCrossguard(Inventory inv) {
        if (crossGuardContents == null && crossGuardContents2 == null) {
            ItemStack[] items = new ItemStack[6];
            ItemStack[] sabers = new ItemStack[6];

            items[0] = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            items[1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            items[2] = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
            items[3] = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
            items[4] = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
            items[5] = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);

            //sabers[0] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Darksaber", 3, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            //sabers[2] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Purple Lightsaber", 1, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            //sabers[1] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.GREEN + "" + ChatColor.BOLD + "Green Lightsaber", 2, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            //sabers[3] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.RED + "" + ChatColor.BOLD + "Red Lightsaber", 0, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");

            sabers[0] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&c&lCrossguard Lightsaber"), 13, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[1] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&a&lCrossguard Lightsaber"), 15, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[2] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&9&lCrossguard Lightsaber"), 14, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[3] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&5&lCrossguard Lightsaber"), 16, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[4] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&e&lCrossguard Lightsaber"), 17, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[5] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&f&lCrossguard Lightsaber"), 18, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");

            crossGuardContents = items;
            crossGuardContents2 = sabers;
        }

        int startingIndex = ThreadLocalRandom.current().nextInt(crossGuardContents.length);
        int startingIndex2 = ThreadLocalRandom.current().nextInt(crossGuardContents2.length);

        for (int i = 0; i < startingIndex; i++) {
            inv.setItem(11, crossGuardContents[(11 + crossGuardItemIndex) % crossGuardContents.length]);
            crossGuardItemIndex++;
        }
        for (int j = 0; j < startingIndex2; j++) {
            inv.setItem(25, crossGuardContents2[(11 + crossGuardItemIndex2) % crossGuardContents2.length]);
            crossGuardItemIndex2++;
        }

        inv.setItem(20, ISC.createItem(Material.BEACON, ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core")));
        inv.setItem(29, ISC.createItem(Material.WOODEN_SWORD, ChatColor.GRAY + "Crossguard Hilt", 2));
        inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", 0, ChatColor.GRAY + "Craft this recipe using a work bench!"));
        inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", 0, ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
        inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));
    }

    public void spinCrossguard(final Player player) {

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crossguard Lightsaber Recipes");
        shuffleCrossguard(inv);
        crossGuardInvs.add(inv);
        player.openInventory(inv);

        new BukkitRunnable() {

            @Override
            public void run() {
                if (player.getOpenInventory().getTitle().equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crossguard Lightsaber Recipes")) {
                    inv.setItem(11, crossGuardContents[(11 + crossGuardItemIndex) % crossGuardContents.length]);
                    crossGuardItemIndex++;
                    inv.setItem(25, crossGuardContents2[(25 + crossGuardItemIndex2) % crossGuardContents2.length]);
                    crossGuardItemIndex2++;
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 15, 15);
    }

    public void shuffleDB(Inventory inv) {
        if (dBContents == null && dBContents2 == null) {
            ItemStack[] items = new ItemStack[6];
            ItemStack[] sabers = new ItemStack[6];

            items[0] = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            items[1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            items[2] = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
            items[3] = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
            items[4] = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
            items[5] = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);

            //sabers[0] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Darksaber", 3, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            //sabers[2] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Purple Lightsaber", 1, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            //sabers[1] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.GREEN + "" + ChatColor.BOLD + "Green Lightsaber", 2, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            //sabers[3] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.RED + "" + ChatColor.BOLD + "Red Lightsaber", 0, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");

            sabers[0] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&c&lDouble-Bladed Lightsaber"), 1, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[1] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&9&lDouble-Bladed Lightsaber"), 2, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[2] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&a&lDouble-Bladed Lightsaber"), 3, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[3] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&5&lDouble-Bladed Lightsaber"), 4, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[4] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&e&lDouble-Bladed Lightsaber"), 5, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[5] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&f&lDouble-Bladed Lightsaber"), 6, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");

            dBContents = items;
            dBContents2 = sabers;
        }

        int startingIndex = ThreadLocalRandom.current().nextInt(dBContents.length);
        int startingIndex2 = ThreadLocalRandom.current().nextInt(dBContents2.length);

        for (int i = 0; i < startingIndex; i++) {
            inv.setItem(11, dBContents[(11 + dBItemIndex) % dBContents.length]);
            dBItemIndex++;
        }
        for (int j = 0; j < startingIndex2; j++) {
            inv.setItem(25, dBContents2[(11 + dBItemIndex2) % dBContents2.length]);
            dBItemIndex2++;
        }

        inv.setItem(20, ISC.createItem(Material.BEACON, ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core")));
        inv.setItem(29, ISC.createItem(Material.WOODEN_SWORD, ChatColor.GRAY + "Double-Bladed Hilt", 4));
        inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table",  ChatColor.GRAY + "Craft this recipe using a work bench!"));
        inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back",  ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
        inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));
    }

    public void spinDB(final Player player) {

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Double-Bladed Lightsaber Recipes");
        shuffleDB(inv);
        dBInvs.add(inv);
        player.openInventory(inv);

        new BukkitRunnable() {

            @Override
            public void run() {
                if (player.getOpenInventory().getTitle().equals(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Double-Bladed Lightsaber Recipes")) {
                    inv.setItem(11, dBContents[(11 + dBItemIndex) % dBContents.length]);
                    dBItemIndex++;
                    inv.setItem(25, dBContents2[(25 + dBItemIndex2) % dBContents2.length]);
                    dBItemIndex2++;
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 15, 15);
    }
    public void shuffleS(Inventory inv) {
        if (sContents == null && sContents2 == null) {
            ItemStack[] items = new ItemStack[6];
            ItemStack[] sabers = new ItemStack[6];

            items[0] = new ItemStack(Material.RED_STAINED_GLASS_PANE);
            items[1] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            items[2] = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
            items[3] = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
            items[4] = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
            items[5] = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);

            //sabers[0] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Darksaber", 3, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            //sabers[2] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Purple Lightsaber", 1, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            //sabers[1] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.GREEN + "" + ChatColor.BOLD + "Green Lightsaber", 2, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            //sabers[3] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.RED + "" + ChatColor.BOLD + "Red Lightsaber", 0, ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"", "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");

            sabers[0] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&c&lSingle-Bladed Lightsaber"), 7, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[1] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&a&lSingle-Bladed Lightsaber"), 9, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[2] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&9&lSingle-Bladed Lightsaber"), 8, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[3] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&5&lSingle-Bladed Lightsaber"), 10, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[4] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&e&lSingle-Bladed Lightsaber"), 11, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
            sabers[5] = ISC.createItem(Material.NETHERITE_SWORD, ChatColor.translateAlternateColorCodes('&', "&f&lSingle-Bladed Lightsaber"), 12, ChatColor.translateAlternateColorCodes('&', "&7\"An elegant weapon from a more civilized age.\""), "", ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17", "", ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK", ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24", ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");

            sContents = items;
            sContents2 = sabers;
        }

        int startingIndex = ThreadLocalRandom.current().nextInt(sContents.length);
        int startingIndex2 = ThreadLocalRandom.current().nextInt(sContents2.length);

        for (int i = 0; i < startingIndex; i++) {
            inv.setItem(11, sContents[(11 + sItemIndex) % sContents.length]);
            sItemIndex++;
        }
        for (int j = 0; j < startingIndex2; j++) {
            inv.setItem(25, sContents2[(11 + sItemIndex2) % sContents2.length]);
            sItemIndex2++;
        }

        inv.setItem(20, ISC.createItem(Material.BEACON, ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core")));
        inv.setItem(29, ISC.createItem(Material.WOODEN_SWORD, ChatColor.GRAY + "Single-Bladed Hilt", 5));
        inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table",  ChatColor.GRAY + "Craft this recipe using a work bench!"));
        inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back",  ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
        inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));
    }

    public void spinS(final Player player) {

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.BLUE + "" + ChatColor.BOLD + "Single-Bladed Lightsaber Recipes");
        shuffleS(inv);
        sInvs.add(inv);
        player.openInventory(inv);

        new BukkitRunnable() {

            @Override
            public void run() {
                if (player.getOpenInventory().getTitle().equals(ChatColor.BLUE + "" + ChatColor.BOLD + "Single-Bladed Lightsaber Recipes")) {
                    inv.setItem(11, sContents[(11 + sItemIndex) % sContents.length]);
                    sItemIndex++;
                    inv.setItem(25, sContents2[(25 + sItemIndex2) % sContents2.length]);
                    sItemIndex2++;
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(plugin, 15, 15);
    }
}
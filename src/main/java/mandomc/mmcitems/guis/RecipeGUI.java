package mandomc.mmcitems.guis;

import mandomc.mmcitems.handlers.GI;
import mandomc.mmcitems.handlers.IC;
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

    private int kyberIndex = 0;
    private int crossguardIndex = 0;
    private int doublebladedIndex = 0;
    private int singlebladedIndex = 0;

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

        Inventory recipes = IC.recipes(player);

        Inventory weapons = IC.weapons(player);

        Inventory lightsabers = IC.lightsabers(player);

        Inventory parts = IC.parts(player);

        Inventory crossGuardHilt = IC.crossGuardHilt(player);

        Inventory dbHilt = IC.doubleBladedHilt(player);

        Inventory sHilt = IC.singleBladedHilt(player);

        Inventory core = IC.lightsaberCore(player);


        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Recipes"))) {
            switch (event.getCurrentItem().getType()) {
                case SHIELD:
                    player.openInventory(weapons);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case WOODEN_SWORD:
                    player.openInventory(parts);
            }
            event.setCancelled(true);
        }

        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weapon Recipes"))) {
            switch (event.getCurrentItem().getType()) {
                case SHIELD:
                    player.openInventory(lightsabers);
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

        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Recipes"))) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(weapons);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4&lCrossguard Lightsaber Recipes"))){
                crossGuardAnimation(player);
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4&lDouble-Bladed Lightsaber Recipes"))){
                doubleBladedAnimation(player);
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&9&lSingle-Bladed Lightsaber Recipes"))){
                singleBladedAnimation(player);
            }
            event.setCancelled(true);
        }

        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Part Recipes"))) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(recipes);
                    break;
                case BARRIER:
                    player.closeInventory();
                    break;
                case BEACON:
                    player.openInventory(core);
                    break;
                /*case NETHER_STAR:
                    kyberAnimation(player);
                    break;*/
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
            event.setCancelled(true);
        }
        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Crossguard Hilt Recipe"))) {
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
        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Double-Bladed Hilt Recipe"))) {
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
        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Single-Bladed Hilt Recipe"))) {
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
        if ((event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Lightsaber Core Recipe"))) {
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
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Kyber Crystal Recipes")) {
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

        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crossguard Saber Recipes")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(lightsabers);
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
                /*case NETHER_STAR:
                    kyberAnimation(player);
                    break;*/
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Double-Bladed Saber Recipes")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(lightsabers);
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
                /*case NETHER_STAR:
                    kyberAnimation(player);
                    break;*/
            }
            event.setCancelled(true);
        }
        if (event.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "" + ChatColor.BOLD + "Single-Bladed Saber Recipes")) {
            switch (event.getCurrentItem().getType()) {
                case ARROW:
                    player.openInventory(lightsabers);
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
                /*case NETHER_STAR:
                    kyberAnimation(player);
                    break;*/
            }
            event.setCancelled(true);
        }
    }

    public void kyberAnimation(Player player){
        ItemStack[] kybers = new ItemStack[6];
        ItemStack[] glass = new ItemStack[6];

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Kyber Crystal Recipes");

        player.openInventory(inv);

        glass[0] = ISC.createItem(Material.RED_STAINED_GLASS_PANE);
        glass[1] = ISC.createItem(Material.BLUE_STAINED_GLASS_PANE);
        glass[2] = ISC.createItem(Material.GREEN_STAINED_GLASS_PANE);
        glass[3] = ISC.createItem(Material.PURPLE_STAINED_GLASS_PANE);
        glass[4] = ISC.createItem(Material.YELLOW_STAINED_GLASS_PANE);
        glass[5] = ISC.createItem(Material.WHITE_STAINED_GLASS_PANE);

        kybers[0] = GI.redKyber();
        kybers[1] = GI.blueKyber();
        kybers[2] = GI.greenKyber();
        kybers[3] = GI.purpleKyber();
        kybers[4] = GI.yellowKyber();
        kybers[5] = GI.whiteKyber();

        new BukkitRunnable(){
            @Override
            public void run(){

                if(kyberIndex < 5){
                    kyberIndex++;
                }else{
                    kyberIndex = 0;
                }

                inv.setItem(10, glass[kyberIndex]);
                inv.setItem(11, glass[kyberIndex]);
                inv.setItem(12, glass[kyberIndex]);
                inv.setItem(19, glass[kyberIndex]);
                inv.setItem(21, glass[kyberIndex]);
                inv.setItem(28, glass[kyberIndex]);
                inv.setItem(29, glass[kyberIndex]);
                inv.setItem(30, glass[kyberIndex]);

                inv.setItem(20, GI.kyberite());

                inv.setItem(25, kybers[kyberIndex]);

                inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
                inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
                inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));

                player.updateInventory();
            }
        }.runTaskTimer(plugin, 15, 15);

    }

    public void crossGuardAnimation(Player player){
        ItemStack[] kybers = new ItemStack[6];
        ItemStack[] sabers = new ItemStack[6];

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Crossguard Saber Recipes");

        player.openInventory(inv);

        sabers[0] = GI.crossGuardRed();
        sabers[1] = GI.crossGuardBlue();
        sabers[2] = GI.crossGuardGreen();
        sabers[3] = GI.crossGuardPurple();
        sabers[4] = GI.crossGuardYellow();
        sabers[5] = GI.crossGuardWhite();

        kybers[0] = GI.redKyber();
        kybers[1] = GI.blueKyber();
        kybers[2] = GI.greenKyber();
        kybers[3] = GI.purpleKyber();
        kybers[4] = GI.yellowKyber();
        kybers[5] = GI.whiteKyber();

        new BukkitRunnable(){
            @Override
            public void run(){

                if(crossguardIndex < 5){
                    crossguardIndex++;
                }else{
                    crossguardIndex = 0;
                }

                inv.setItem(11, kybers[crossguardIndex]);
                inv.setItem(20, GI.lightsaberCore());
                inv.setItem(29, GI.crossGuardHilt());

                inv.setItem(25, sabers[crossguardIndex]);

                inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
                inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
                inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));

                player.updateInventory();
            }
        }.runTaskTimer(plugin, 15, 15);
    }

    public void singleBladedAnimation(Player player){
        ItemStack[] kybers = new ItemStack[6];
        ItemStack[] sabers = new ItemStack[6];

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.BLUE + "" + ChatColor.BOLD + "Single-Bladed Saber Recipes");

        player.openInventory(inv);

        sabers[0] = GI.singleBladedBlue();
        sabers[1] = GI.singleBladedBlue();
        sabers[2] = GI.singleBladedGreen();
        sabers[3] = GI.singleBladedPurple();
        sabers[4] = GI.singleBladedYellow();
        sabers[5] = GI.singleBladedWhite();

        kybers[0] = GI.redKyber();
        kybers[1] = GI.blueKyber();
        kybers[2] = GI.greenKyber();
        kybers[3] = GI.purpleKyber();
        kybers[4] = GI.yellowKyber();
        kybers[5] = GI.whiteKyber();

        new BukkitRunnable(){
            @Override
            public void run(){

                if(singlebladedIndex < 5){
                    singlebladedIndex++;
                }else{
                    singlebladedIndex = 0;
                }

                inv.setItem(11, kybers[singlebladedIndex]);
                inv.setItem(20, GI.lightsaberCore());
                inv.setItem(29, GI.singleBladedHilt());

                inv.setItem(25, sabers[singlebladedIndex]);

                inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
                inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
                inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));

                player.updateInventory();
            }
        }.runTaskTimer(plugin, 15, 15);
    }

    public void doubleBladedAnimation(Player player){
        ItemStack[] kybers = new ItemStack[6];
        ItemStack[] sabers = new ItemStack[6];

        Inventory inv = Bukkit.createInventory(player, 54, ChatColor.DARK_RED + "" + ChatColor.BOLD + "Double-Bladed Saber Recipes");

        player.openInventory(inv);

        sabers[0] = GI.doubleBladedBlue();
        sabers[1] = GI.doubleBladedBlue();
        sabers[2] = GI.doubleBladedGreen();
        sabers[3] = GI.doubleBladedPurple();
        sabers[4] = GI.doubleBladedYellow();
        sabers[5] = GI.doubleBladedWhite();

        kybers[0] = GI.redKyber();
        kybers[1] = GI.blueKyber();
        kybers[2] = GI.greenKyber();
        kybers[3] = GI.purpleKyber();
        kybers[4] = GI.yellowKyber();
        kybers[5] = GI.whiteKyber();

        new BukkitRunnable(){
            @Override
            public void run(){

                if(doublebladedIndex < 5){
                    doublebladedIndex++;
                }else{
                    doublebladedIndex = 0;
                }

                inv.setItem(11, kybers[doublebladedIndex]);
                inv.setItem(20, GI.lightsaberCore());
                inv.setItem(29, GI.doubleBladedHilt());

                inv.setItem(25, sabers[doublebladedIndex]);

                inv.setItem(23, ISC.createItem(Material.CRAFTING_TABLE, ChatColor.DARK_GRAY + "Crafting Table", ChatColor.GRAY + "Craft this recipe using a work bench!"));
                inv.setItem(48, ISC.createItem(Material.ARROW, ChatColor.RED + "" + ChatColor.BOLD + "Back", ChatColor.GRAY + "Click to go back to Weapon Recipes!"));
                inv.setItem(49, ISC.createItem(Material.BARRIER, ChatColor.RED + "" + ChatColor.BOLD + "CLOSE"));

                player.updateInventory();
            }
        }.runTaskTimer(plugin, 15, 15);

    }
}
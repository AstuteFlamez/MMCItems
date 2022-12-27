package mandomc.mmcitems.commands;

import mandomc.mmcitems.handlers.ISC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            ItemStack close = new ItemStack(Material.BARRIER, 1);
            ItemMeta cIM = close.getItemMeta();
            cIM.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "CLOSE");
            close.setItemMeta(cIM);

            Player player = (Player) sender;
            Inventory recipes = Bukkit.createInventory(player,9, ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "MandoMC Recipes");

            recipes.setItem(0, ISC.createItem(Material.NETHERITE_SWORD,ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Weapon Recipes",  0, ChatColor.GRAY + "Inside you will find weapons from a more civilized age!"));
            recipes.setItem(1, ISC.createItem(Material.WOODEN_SWORD, ChatColor.translateAlternateColorCodes('&', "&2&lParts Recipes"),1,ChatColor.GRAY + "Use these recipes to create larger items!"));
            recipes.setItem(8, close);

            player.openInventory(recipes);

        }else{
            System.out.println("You need to be a player to run this command!");
        }
        return true;
    }
}
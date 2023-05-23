package mandomc.mmcitems.commands;

import mandomc.mmcitems.MMCItems;
import mandomc.mmcitems.handlers.GI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MMCGive implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(player.hasPermission("mmc.mmcgive")){
                if(args.length == 2){
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if(args[1].equalsIgnoreCase("kyberite")){
                        if(target == null){
                            player.sendMessage(ChatColor.RED + "You did not provide an online player!");
                        }else{
                            target.getInventory().addItem(GI.kyberite());
                          }
                    }else if(args[1].equalsIgnoreCase("greenkyber")){
                        if(target == null){
                            player.sendMessage(ChatColor.RED + "You did not provide an online player!");
                        }else{
                            target.getInventory().addItem(GI.greenKyber());
                            ((Player) sender).playSound(target, Sound.UI_TOAST_CHALLENGE_COMPLETE, 10 , 1);
                        }
                    }else if(args[1].equalsIgnoreCase("purplekyber")){
                        if(target == null){
                            player.sendMessage(ChatColor.RED + "You did not provide an online player!");
                        }else{
                            target.getInventory().addItem(GI.purpleKyber());
                            ((Player) sender).playSound(target, Sound.UI_TOAST_CHALLENGE_COMPLETE, 10 , 1);
                        }
                    }else if(args[1].equalsIgnoreCase("yellowkyber")){
                        if(target == null){
                            player.sendMessage(ChatColor.RED + "You did not provide an online player!");
                            ((Player) sender).playSound(target, Sound.UI_TOAST_CHALLENGE_COMPLETE, 10 , 1);
                        }else{
                            target.getInventory().addItem(GI.yellowKyber());
                        }
                    }else if(args[1].equalsIgnoreCase("bluekyber")){
                        if(target == null){
                            player.sendMessage(ChatColor.RED + "You did not provide an online player!");
                            ((Player) sender).playSound(target, Sound.UI_TOAST_CHALLENGE_COMPLETE, 10 , 1);
                        }else{
                            target.getInventory().addItem(GI.blueKyber());
                        }
                    }else{
                        player.sendMessage("Incorrect Syntax! /mmcgive <onlinePlayer> <item>");
                    }
                }else{
                    player.sendMessage("Incorrect Syntax! /mmcgive <onlinePlayer> <item>");
                }
            }else{
                player.sendMessage(ChatColor.RED + "The force is not with you...");
            }
        }else{
            if (args.length == 2) {
                String playerName = args[0];
                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (args[1].equalsIgnoreCase("kyberite")) {
                    if (target != null) {
                        target.getInventory().addItem(GI.kyberite());
                    }
                } else if (args[1].equalsIgnoreCase("greenkyber")) {
                    if (target != null) {
                        target.getInventory().addItem(GI.greenKyber());
                    }
                } else if (args[1].equalsIgnoreCase("purplekyber")) {
                    if (target != null) {
                        target.getInventory().addItem(GI.purpleKyber());
                    }
                } else if (args[1].equalsIgnoreCase("yellowkyber")) {
                    if (target != null) {
                        target.getInventory().addItem(GI.yellowKyber());
                    }
                } else if (args[1].equalsIgnoreCase("bluekyber")) {
                    if (target != null) {
                        target.getInventory().addItem(GI.blueKyber());
                    }
                }
            }
        }
        return false;
    }
}

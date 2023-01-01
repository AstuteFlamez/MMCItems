package mandomc.mmcitems.commands;

import mandomc.mmcitems.MMCItems;
import mandomc.mmcitems.handlers.GI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MMCGive implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(player.hasPermission("mmc.mmcgive")){
                if(args.length == 2){
                    String playerName = args[0];
                    Player target = Bukkit.getServer().getPlayerExact(playerName);

                    if(args[1].equalsIgnoreCase("whiteKyber")){
                        if(target == null){
                            player.sendMessage(ChatColor.RED + "You did not provide an online player!");
                        }else{
                            player.getInventory().addItem(GI.whiteKyber());
                            player.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7Congras you defeats the &6Rancor Boss &7and it gave you a white kyber crystal from it's belly!"));
                        }
                    }else{
                        System.out.println("Incorrect Syntax! /mmcgive <onlinePlayer> <item>");
                    }
                }else{
                    System.out.println("Incorrect Syntax! /mmcgive <onlinePlayer> <item>");
                }
            }else{
                player.sendMessage(ChatColor.RED + "The force is not with you...");
            }
        }else{
            if(args.length == 2){
                String playerName = args[0];
                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if(args[1].equalsIgnoreCase("whiteKyber")){
                    if(target == null){
                        System.out.println("You did not provide an online player!");
                    }else{
                        target.getInventory().addItem(GI.whiteKyber());
                        target.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7Congras you defeats the &6Rancor Boss &7and it gave you a white kyber crystal from it's belly!"));
                    }
                }else{
                    System.out.println("Incorrect Syntax! /mmcgive <onlinePlayer> <item>");
                }
            }else{
                System.out.println("Incorrect Syntax! /mmcgive <onlinePlayer> <item>");
            }
        }

        return false;
    }
}

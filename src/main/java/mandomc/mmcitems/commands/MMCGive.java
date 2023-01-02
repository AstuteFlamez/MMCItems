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

                    if(args[1].equalsIgnoreCase("kyberite")){
                        if(target == null){
                            player.sendMessage(ChatColor.RED + "You did not provide an online player!");
                        }else{
                            target.getInventory().addItem(GI.kyberite());
                            target.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7Congras you defeats the &6Rancor Boss &7and it gave you a white kyber crystal from it's belly!"));
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
            if(args.length == 2){
                String playerName = args[0];
                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if(args[1].equalsIgnoreCase("kyberite")){
                    if(target == null){
                        Bukkit.getServer().getConsoleSender().sendMessage("You did not provide an online player");
                    }else{
                        target.getInventory().addItem(GI.kyberite());
                        target.sendMessage(MMCItems.prefix + ChatColor.translateAlternateColorCodes('&', "&7Congras you defeats the &6Rancor Boss &7and it gave you a white kyber crystal from it's belly!"));
                    }
                }else{
                    Bukkit.getServer().getConsoleSender().sendMessage("Incorrect Syntax! /mmcgive <onlinePlayer> <item>");
                }
            }else{
                Bukkit.getServer().getConsoleSender().sendMessage("Incorrect Syntax! /mmcgive <onlinePlayer> <item>");
            }
        }

        return false;
    }
}

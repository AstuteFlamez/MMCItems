package mandomc.mmcitems.commands;

import mandomc.mmcitems.handlers.GI;
import mandomc.mmcitems.handlers.RandomMethods;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MMCGet implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player player = (Player) sender;

            if(player.hasPermission("mmc.mmcget")){
                if(args.length == 0){
                    RandomMethods.itemList(player);
                }else if(args.length == 1){
                    if(args[0].equalsIgnoreCase("xwing")){
                        player.getInventory().addItem(GI.xWing());
                    }else if(args[0].equalsIgnoreCase("n1")){
                        player.getInventory().addItem(GI.n1());
                    }else if(args[0].equalsIgnoreCase("tie")){
                        player.getInventory().addItem(GI.tieFighter());
                    }else if(args[0].equalsIgnoreCase("lightsaberCore")){
                        player.getInventory().addItem(GI.lightsaberCore());
                    }else if(args[0].equalsIgnoreCase("singleBladedHilt")){
                        player.getInventory().addItem(GI.singleBladedHilt());
                    } else if(args[0].equalsIgnoreCase("doubleBladedHilt")){
                        player.getInventory().addItem(GI.doubleBladedHilt());
                    } else if(args[0].equalsIgnoreCase("crossGuardHilt")){
                        player.getInventory().addItem(GI.crossGuardHilt());
                    }else if(args[0].equalsIgnoreCase("dookuHilt")){
                        player.getInventory().addItem(GI.dookuHilt());
                    }else if(args[0].equalsIgnoreCase("inquisitorHilt")){
                        player.getInventory().addItem(GI.inquisitorHilt());
                    }else if(args[0].equalsIgnoreCase("dookuSaber")){
                        player.getInventory().addItem(GI.dookuSaber());
                    }else if(args[0].equalsIgnoreCase("inquisitorSaber")){
                        player.getInventory().addItem(GI.inquisitorSaber());
                    }else if(args[0].equalsIgnoreCase("kyberite")){
                        player.getInventory().addItem(GI.kyberite());
                    }else if(args[0].equalsIgnoreCase("darksaber")){
                        player.getInventory().addItem(GI.darksaber());
                    }else{
                        player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                    }
                }else if(args.length == 2){
                    if(args[0].equalsIgnoreCase("singleBladed")){
                        if(args[1].equalsIgnoreCase("red")){
                            player.getInventory().addItem(GI.singleBladedRed());
                        }else if(args[1].equalsIgnoreCase("blue")){
                            player.getInventory().addItem(GI.singleBladedBlue());
                        }else if(args[1].equalsIgnoreCase("green")){
                            player.getInventory().addItem(GI.singleBladedGreen());
                        }else if(args[1].equalsIgnoreCase("purple")){
                            player.getInventory().addItem(GI.singleBladedPurple());
                        }else if(args[1].equalsIgnoreCase("yellow")){
                            player.getInventory().addItem(GI.singleBladedYellow());
                        }else if(args[1].equalsIgnoreCase("white")){
                            player.getInventory().addItem(GI.singleBladedWhite());
                        }else{
                            player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                        }
                    }else if(args[0].equalsIgnoreCase("doubleBladed")){
                        if(args[1].equalsIgnoreCase("red")){
                            player.getInventory().addItem(GI.doubleBladedRed());
                        }else if(args[1].equalsIgnoreCase("blue")){
                            player.getInventory().addItem(GI.doubleBladedBlue());
                        }else if(args[1].equalsIgnoreCase("green")){
                            player.getInventory().addItem(GI.doubleBladedGreen());
                        }else if(args[1].equalsIgnoreCase("purple")){
                            player.getInventory().addItem(GI.doubleBladedPurple());
                        }else if(args[1].equalsIgnoreCase("yellow")){
                            player.getInventory().addItem(GI.doubleBladedYellow());
                        }else if(args[1].equalsIgnoreCase("white")){
                            player.getInventory().addItem(GI.doubleBladedWhite());
                        }else{
                            player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                        }
                    }else if(args[0].equalsIgnoreCase("crossGuard")){
                        if(args[1].equalsIgnoreCase("red")){
                            player.getInventory().addItem(GI.crossGuardRed());
                        }else if(args[1].equalsIgnoreCase("blue")){
                            player.getInventory().addItem(GI.crossGuardBlue());
                        }else if(args[1].equalsIgnoreCase("green")){
                            player.getInventory().addItem(GI.crossGuardGreen());
                        }else if(args[1].equalsIgnoreCase("purple")){
                            player.getInventory().addItem(GI.crossGuardPurple());
                        }else if(args[1].equalsIgnoreCase("yellow")){
                            player.getInventory().addItem(GI.crossGuardYellow());
                        }else if(args[1].equalsIgnoreCase("white")){
                            player.getInventory().addItem(GI.crossGuardWhite());
                        }else{
                            player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                        }
                    }else if(args[0].equalsIgnoreCase("kyber")){
                        if(args[1].equalsIgnoreCase("red")){
                            player.getInventory().addItem(GI.redKyber());
                        }else if(args[1].equalsIgnoreCase("blue")){
                            player.getInventory().addItem(GI.blueKyber());
                        }else if(args[1].equalsIgnoreCase("green")){
                            player.getInventory().addItem(GI.greenKyber());
                        }else if(args[1].equalsIgnoreCase("purple")){
                            player.getInventory().addItem(GI.purpleKyber());
                        }else if(args[1].equalsIgnoreCase("yellow")){
                            player.getInventory().addItem(GI.yellowKyber());
                        }else if(args[1].equalsIgnoreCase("white")){
                            player.getInventory().addItem(GI.whiteKyber());
                        }else{
                            player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                        }
                    }else{
                        player.sendMessage(ChatColor.RED + "Incorrect Syntax! /mmcget <item> [color]");
                    }
                }
            }else{
                player.sendMessage(ChatColor.RED + "The force is not with you...");
            }

        }

        return true;
    }
}

package mandomc.mmcitems.listeners;

import mandomc.mmcitems.MMCItems;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.HashMap;

public class JetpackEvents implements Listener {

    HashMap<Player, BossBar> bossBarHashMap = new HashMap<>();


    @EventHandler
    public void playerJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if(bossBarHashMap.containsKey(player)){
            if(isWearingJetpack(player)){
                bossBarHashMap.get(player).setVisible(true);
            }
        }
        if(!bossBarHashMap.containsKey(player)) {
            BossBar bossBar = Bukkit.createBossBar(ChatColor.translateAlternateColorCodes('&', "&c&lJetpack Fuel"), BarColor.RED, BarStyle.SEGMENTED_10);
            bossBar.addPlayer(player);
            bossBar.setVisible(false);
            bossBarHashMap.put(player, bossBar);
        }
    }

    @EventHandler
    public void testieloxx(PlayerToggleSneakEvent event){

        Player player = event.getPlayer();
        cast(player);
    }


    public void cast(Player player){

        if(!bossBarHashMap.get(player).isVisible()) {

            Bukkit.getScheduler().scheduleSyncRepeatingTask(MMCItems.getInstance(), new Runnable() {

                double progress = 1.0;

                @Override
                public void run() {

                    BossBar bossBar = bossBarHashMap.get(player);

                    if (isWearingJetpack(player)) {
                        bossBar.setVisible(true);
                        if (player.isSneaking() && progress != 0 && bossBar.getColor() != BarColor.BLUE) {
                            progress -= 0.1;
                            if (progress < 0.0) {
                                progress = 0.0;
                            }else{
                                player.setVelocity(player.getLocation().getDirection().multiply(1.5).setY(1));
                            }
                            bossBar.setProgress(progress);
                        }else if(progress == 0){
                            bossBar.setColor(BarColor.BLUE);
                            bossBar.setTitle(ChatColor.translateAlternateColorCodes('&', "&e&lShort Circuit"));
                            progress += 0.001;
                        }else{
                            progress += 0.1;
                            if (progress > 1.0) {
                                progress = 1.0;
                            }
                            bossBar.setProgress(progress);
                            if(bossBar.getProgress() == 1){
                                bossBar.setColor(BarColor.RED);
                                bossBar.setTitle(ChatColor.translateAlternateColorCodes('&', "&c&lJetpack Fuel"));
                            }
                        }
                    } else {
                        bossBar.setVisible(false);
                    }

                    bossBarHashMap.replace(player, bossBar);
                }
            }, 0, 20);
        }
    }

    public boolean isWearingJetpack(Player player){
        if(player.getInventory().getHelmet() != null && player.getInventory().getHelmet().getItemMeta() != null && player.getInventory().getHelmet().getItemMeta().hasCustomModelData() && player.getInventory().getHelmet().getItemMeta().getCustomModelData() == 1){
            return true;
        }
        bossBarHashMap.get(player).setVisible(false);
        return false;
    }

}



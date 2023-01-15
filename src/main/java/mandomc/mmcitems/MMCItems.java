package mandomc.mmcitems;

import mandomc.mmcitems.commands.MMCGet;
import mandomc.mmcitems.commands.MMCGive;
import mandomc.mmcitems.commands.RecipesCommand;
import mandomc.mmcitems.handlers.ShipsRunnable;
import mandomc.mmcitems.listeners.LightsaberThrow;
import mandomc.mmcitems.guis.RecipeGUI;
import mandomc.mmcitems.listeners.VehicleEvents;
import mandomc.mmcitems.recipes.Recipes;
import mandomc.mmcitems.vehicles.N1Starfighter;
import mandomc.mmcitems.vehicles.TieFighter;
import mandomc.mmcitems.vehicles.Vehicle;
import mandomc.mmcitems.vehicles.XWing;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.UUID;

public final class MMCItems extends JavaPlugin implements Listener {

    private final HashMap<UUID, Long> lightsaberCooldown;

    public static String prefix = ChatColor.GREEN + "" + ChatColor.BOLD + "MMCITEMS" + ChatColor.DARK_GRAY + " » ";

    public static MMCItems instance;

    public MMCItems() {
        lightsaberCooldown = new HashMap<>();
    }

    @Override
    public void onEnable() {

        Recipes.init();

        instance = this;

        BukkitTask vehicleTask = new ShipsRunnable(this).runTaskTimer(this, 0L, 1L);

        getCommand("recipes").setExecutor(new RecipesCommand());
        getCommand("mmcget").setExecutor(new MMCGet());
        getCommand("mmcgive").setExecutor(new MMCGive());

        getServer().getPluginManager().registerEvents(new TieFighter(), this);
        getServer().getPluginManager().registerEvents(new XWing(), this);
        getServer().getPluginManager().registerEvents(new N1Starfighter(), this);
        getServer().getPluginManager().registerEvents(new VehicleEvents(), this);
        getServer().getPluginManager().registerEvents(new RecipeGUI(this), this);
        getServer().getPluginManager().registerEvents(new LightsaberThrow(lightsaberCooldown), this);
        getServer().getPluginManager().registerEvents(this, this);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MMCItems]: Plugin is enabled!");

    }

    @Override
    public void onDisable() {

        instance = null;

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MMCItems]: Plugin is disabled!");

        /*for(Vehicle tieFighter : TieFighter.getAllTieFighters()){
            if(tieFighter.getPilot() != null){
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MMCItems]: Removed Tie-Fighter!");
                Player pilot = tieFighter.getPilot();
                TieFighter.removeShip(pilot, tieFighter);
            }else{
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MMCItems]: Removed Tie-Fighter!");
                tieFighter.getSeat1().remove();
                tieFighter.getModel().remove();

            }
        }
        for(Vehicle xWing : XWing.getAllXWings()){
            if(xWing.getPilot() != null){
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MMCItems]: Removed X-Wing!");
                Player pilot = xWing.getPilot();
                XWing.removeShip(pilot, xWing);
            }else{
                getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MMCItems]: Removed X-Wing!");
                xWing.getSeat1().remove();
                xWing.getModel().remove();

            }
        }*/

    }

    public static MMCItems getInstance(){return instance;}
}

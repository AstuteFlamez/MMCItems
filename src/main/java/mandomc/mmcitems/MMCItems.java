package mandomc.mmcitems;

import mandomc.mmcitems.commands.MMCGet;
import mandomc.mmcitems.commands.MMCGive;
import mandomc.mmcitems.commands.RecipesCommand;
import mandomc.mmcitems.tasks.ShipsRunnable;
import mandomc.mmcitems.listeners.BleedEvent;
import mandomc.mmcitems.listeners.JetpackEvents;
import mandomc.mmcitems.listeners.LightsaberThrowEvent;
import mandomc.mmcitems.guis.RecipeGUI;
import mandomc.mmcitems.listeners.VehicleEvents;
import mandomc.mmcitems.recipes.Recipes;
import mandomc.mmcitems.vehicles.TieFighter;
import mandomc.mmcitems.vehicles.XWing;
import org.bukkit.ChatColor;
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

        getServer().getPluginManager().registerEvents(new JetpackEvents(), this);
        getServer().getPluginManager().registerEvents(new BleedEvent(), this);
        getServer().getPluginManager().registerEvents(new TieFighter(), this);
        getServer().getPluginManager().registerEvents(new XWing(), this);
        getServer().getPluginManager().registerEvents(new VehicleEvents(), this);
        getServer().getPluginManager().registerEvents(new RecipeGUI(this), this);
        getServer().getPluginManager().registerEvents(new LightsaberThrowEvent(lightsaberCooldown), this);
        getServer().getPluginManager().registerEvents(this, this);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MMCItems]: Plugin is enabled!");

    }

    @Override
    public void onDisable() {

        instance = null;

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MMCItems]: Plugin is disabled!");

    }

    public static MMCItems getInstance(){return instance;}
}

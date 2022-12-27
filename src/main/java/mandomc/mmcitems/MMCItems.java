package mandomc.mmcitems;

import mandomc.mmcitems.commands.RecipesCommand;
import mandomc.mmcitems.handlers.VehicleTask;
import mandomc.mmcitems.listeners.LightsaberThrow;
import mandomc.mmcitems.listeners.RecipeGUI;
import mandomc.mmcitems.listeners.attachments.RebreatherEnchantment;
import mandomc.mmcitems.listeners.vehicles.XWing;
import mandomc.mmcitems.recipes.Recipes;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.UUID;

public final class MMCItems extends JavaPlugin implements Listener {

    private final HashMap<UUID, Long> lightsaberCooldown;

    //public static final HashMap<Player, String> attachmentAttacher = new HashMap<>();

    public static MMCItems instance;

    public MMCItems() {
        lightsaberCooldown = new HashMap<>();
    }

    public RebreatherEnchantment rebreatherEnchantment = new RebreatherEnchantment(new NamespacedKey(this, "rebreather"));

    @Override
    public void onEnable() {

        Recipes.init();

        instance = this;

        BukkitTask vehicleTask = new VehicleTask(this).runTaskTimer(this, 0L, 5L);

        try{
            try {
                Field f = Enchantment.class.getDeclaredField("acceptingNew");
                f.setAccessible(true);
                f.set(null, true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Enchantment.registerEnchantment(new RebreatherEnchantment(new NamespacedKey(this, "key")));
            } catch (IllegalArgumentException e){
//if this is thrown it means the id is already taken.
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        getCommand("recipes").setExecutor(new RecipesCommand());

        getServer().getPluginManager().registerEvents(new XWing(), this);
        getServer().getPluginManager().registerEvents(new RecipeGUI(this), this);
        getServer().getPluginManager().registerEvents(new LightsaberThrow(lightsaberCooldown), this);
        getServer().getPluginManager().registerEvents(new RebreatherEnchantment(new NamespacedKey(this, "rebreather")), this);
        getServer().getPluginManager().registerEvents(this, this);

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[MMCItems]: Plugin is enabled!");

    }

    @Override
    public void onDisable() {

        instance = null;

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[MMCItems]: Plugin is disabled!");

    }

    public static MMCItems getInstance(){return instance;}

    @EventHandler
    public void playerJoin(PlayerJoinEvent event){

        /*NamespacedKey key = new NamespacedKey(this, "rebreather");

        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta itemMeta = (EnchantmentStorageMeta) item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Rebreather I");
        itemMeta.addStoredEnchant(new RebreatherEnchantment(key), 1, true);
        ArrayList<String> lore = new ArrayList<>();
        //lore.add(ChatColor.GRAY + "Rebreather I");
        //itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        Player player = event.getPlayer(); // sender is the command sender
        player.getInventory().addItem(item);

        ItemStack helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta helmetMeta = item.getItemMeta();
        helmetMeta.addEnchant(new RebreatherEnchantment(key), 1, true);
        ArrayList<String> helmetLore = new ArrayList<>();
        helmetLore.add(ChatColor.GRAY + "Rebreather I");
        helmetMeta.setLore(helmetLore);
        helmet.setItemMeta(helmetMeta);
        player.getInventory().addItem(helmet);*/
    }

    @EventHandler
    public void invClick(InventoryClickEvent event){

        /*ItemStack item = new ItemStack(Material.BOOK);
        item.addUnsafeEnchantment(rebreatherEnchantment, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GREEN + "Rebreather I");
        item.setItemMeta(itemMeta);

        Player player = (Player) event.getWhoClicked();

        boolean leather = event.getCurrentItem().getType().equals(Material.LEATHER_HELMET);
        boolean iron = event.getCurrentItem().getType().equals(Material.IRON_HELMET);
        boolean gold = event.getCurrentItem().getType().equals(Material.GOLDEN_HELMET);
        boolean chainmail = event.getCurrentItem().getType().equals(Material.CHAINMAIL_HELMET);
        boolean diamond = event.getCurrentItem().getType().equals(Material.DIAMOND_HELMET);
        boolean netherite = event.getCurrentItem().getType().equals(Material.NETHERITE_HELMET);

        if (event.getCurrentItem() == null) {
            return;
        }

        if(event.getClickedInventory().getType() == InventoryType.PLAYER) {
            if(event.getCurrentItem() == item){
                attachmentAttacher.put(player, "added");
            }
            if(leather || iron || gold || chainmail || netherite){
                int slot = event.getSlot();
                //ArrayList

                event.getCurrentItem().getItemMeta().setLore();

            }
        }*/
    }
    @EventHandler
    public void onClose(InventoryCloseEvent event){

        /*Player player = (Player) event.getPlayer();

        attachmentAttacher.remove(player);*/
    }
}

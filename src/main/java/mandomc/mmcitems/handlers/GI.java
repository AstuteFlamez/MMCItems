package mandomc.mmcitems.handlers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.UUID;

public class GI {

    public static ItemStack xWing(){
        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.RED + "X-Wing Starfighter");
        ArrayList<String> itemLore = new ArrayList<String>();
        itemLore.add(ChatColor.GRAY + "Right click to spawn!");
        itemLore.add(ChatColor.GRAY + "Right click the cockpit to enter!");
        itemLore.add("");
        itemLore.add(ChatColor.GOLD + "Ability: Proton Torpedos ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK");
        itemLore.add(ChatColor.GRAY + "Proton Torpedos Cooldown:" + ChatColor.RED + " 60 seconds");
        itemMeta.setLore(itemLore);
        itemMeta.setCustomModelData(6);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack xWingColored(int customModelData, ChatColor color){
        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(color + "X-Wing Starfighter");
        ArrayList<String> itemLore = new ArrayList<String>();
        itemLore.add(ChatColor.GRAY + "Right click to spawn!");
        itemLore.add(ChatColor.GRAY + "Right click the cockpit to enter!");
        itemLore.add("");
        itemLore.add(ChatColor.GOLD + "Ability: Proton Torpedos ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK");
        itemLore.add(ChatColor.GRAY + "Proton Torpedos Cooldown:" + ChatColor.RED + " 60 seconds");
        itemMeta.setLore(itemLore);
        itemMeta.setCustomModelData(customModelData);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack n1(){
        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GRAY + "N-1 Starfighter");
        ArrayList<String> itemLore = new ArrayList<String>();
        itemLore.add(ChatColor.GRAY + "Right click to spawn!");
        itemLore.add(ChatColor.GRAY + "Right click the cockpit to enter!");
        itemLore.add("");
        itemLore.add(ChatColor.GOLD + "Gunner Ability: Laser Cannons ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK");
        itemLore.add(ChatColor.GRAY + "Laser Cannons Cooldown:" + ChatColor.RED + " 2 seconds");
        itemMeta.setLore(itemLore);
        itemMeta.setCustomModelData(7);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack tieFighter(){
        ItemStack item = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.DARK_GRAY + "Tie-Fighter");
        ArrayList<String> itemLore = new ArrayList<String>();
        itemLore.add(ChatColor.GRAY + "Right click to spawn!");
        itemLore.add(ChatColor.GRAY + "Right click the cockpit to enter!");
        itemLore.add("");
        itemLore.add(ChatColor.GOLD + "Ability: Laser Cannons ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " LEFT CLICK");
        itemLore.add(ChatColor.GRAY + "Laser Cannons Cooldown:" + ChatColor.RED + " 2 seconds");
        itemMeta.setLore(itemLore);
        itemMeta.setCustomModelData(8);
        item.setItemMeta(itemMeta);
        return item;
    }

    public static ItemStack lightsaberCore(){
        ItemStack core = new ItemStack(Material.BEACON);
        ItemMeta coreMeta = core.getItemMeta();
        coreMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lLightsaber Core"));
        core.setItemMeta(coreMeta);
        return core;
    }

    public static ItemStack singleBladedHilt(){
        ItemStack singleBladedHilt = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta singleBladedHiltItemMeta = singleBladedHilt.getItemMeta();
        singleBladedHiltItemMeta.setDisplayName(ChatColor.GRAY + "Single-Bladed Hilt");
        singleBladedHiltItemMeta.setCustomModelData(5);
        singleBladedHiltItemMeta.setUnbreakable(true);
        singleBladedHiltItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        singleBladedHilt.setItemMeta(singleBladedHiltItemMeta);
        return singleBladedHilt;
    }

    public static ItemStack doubleBladedHilt(){
        ItemStack doubleBladedHilt = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta doubleBladedHiltItemMeta = doubleBladedHilt.getItemMeta();
        doubleBladedHiltItemMeta.setDisplayName(ChatColor.GRAY + "Double-Bladed Hilt");
        doubleBladedHiltItemMeta.setCustomModelData(4);
        doubleBladedHiltItemMeta.setUnbreakable(true);
        doubleBladedHiltItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        doubleBladedHilt.setItemMeta(doubleBladedHiltItemMeta);
        return doubleBladedHilt;
    }

    public static ItemStack crossGuardHilt(){
        ItemStack crossGuardHilt = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta crossGuardMeta = crossGuardHilt.getItemMeta();
        crossGuardMeta.setDisplayName(ChatColor.GRAY + "Crossguard Hilt");
        crossGuardMeta.setCustomModelData(3);
        crossGuardMeta.setUnbreakable(true);
        crossGuardMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        crossGuardHilt.setItemMeta(crossGuardMeta);
        return crossGuardHilt;
    }

    public static ItemStack dookuHilt(){
        ItemStack dookuHilt = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta dookuMeta = dookuHilt.getItemMeta();
        dookuMeta.setDisplayName(ChatColor.RED + "Dooku's Hilt");
        dookuMeta.setCustomModelData(0);
        dookuMeta.setUnbreakable(true);
        dookuMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        dookuHilt.setItemMeta(dookuMeta);
        return dookuHilt;
    }

    public static ItemStack inquisitorHilt(){
        ItemStack inquisitorHilt = new ItemStack(Material.WOODEN_SWORD);
        ItemMeta inquisitorMeta = inquisitorHilt.getItemMeta();
        inquisitorMeta.setDisplayName(ChatColor.RED + "Inquisitor Hilt");
        inquisitorMeta.setCustomModelData(1);
        inquisitorMeta.setUnbreakable(true);
        inquisitorMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        inquisitorHilt.setItemMeta(inquisitorMeta);
        return inquisitorHilt;
    }

    public static ItemStack singleBladedRed(){
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lSingle-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(7);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 15.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack singleBladedBlue(){
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9&lSingle-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(8);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack singleBladedGreen(){
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSingle-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(9);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack singleBladedPurple(){
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lSingle-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(10);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack singleBladedYellow(){
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lSingle-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(11);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack singleBladedWhite(){
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lSingle-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(12);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack doubleBladedRed(){
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lDouble-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(1);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 15.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack doubleBladedBlue(){
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9&lDouble-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(2);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack doubleBladedGreen(){
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lDouble-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(3);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack doubleBladedPurple(){
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lDouble-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(4);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack doubleBladedYellow() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lDouble-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(5);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack doubleBladedWhite() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lDouble-Bladed Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(6);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack crossGuardRed() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lCrossguard Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(13);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 15.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack crossGuardBlue() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9&lCrossguard Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(14);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack crossGuardGreen() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lCrossguard Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(15);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack crossGuardPurple() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lCrossguard Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(16);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack crossGuardYellow() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lCrossguard Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(17);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack crossGuardWhite() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lCrossguard Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(18);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack dookuSaber() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lDooku's Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(19);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 18.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack inquisitorSaber() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lInquisitors's Lightsaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(20);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 18.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack darksaber() {
        ItemStack i = new ItemStack(Material.SHIELD);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&8&lDarksaber"));
        ArrayList<String> iL = new ArrayList<>();
        iL.add(ChatColor.translateAlternateColorCodes('&', "&6&l&oOptifine Required!"));
        iL.add("");
        iL.add(ChatColor.GRAY + "\"An elegant weapon from a more civilized age.\"");
        iL.add("");
        iL.add(ChatColor.GRAY + "Melee Damage:" + ChatColor.RED + " 17");
        iL.add("");
        iL.add(ChatColor.GOLD + "Ability: Saber Throw ->" + ChatColor.YELLOW + "" + ChatColor.BOLD + " SHIFT + LEFT CLICK");
        iL.add(ChatColor.GRAY + "Saber Throw Damage:" + ChatColor.RED + " 24");
        iL.add(ChatColor.GRAY + "Saber Throw Cooldown:" + ChatColor.RED + " 10 seconds");
        iM.setLore(iL);
        iM.setCustomModelData(21);
        iM.setUnbreakable(true);
        iM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        AttributeModifier iD = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 12.0, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        iM.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, iD);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack kyberite() {
        ItemStack i = new ItemStack(Material.NETHER_STAR);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.YELLOW + "Kyberite");
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack redKyber() {
        ItemStack i = new ItemStack(Material.NETHER_STAR);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.RED + "Red Kyber Crystal");
        iM.setCustomModelData(1);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack blueKyber() {
        ItemStack i = new ItemStack(Material.NETHER_STAR);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.BLUE + "Blue Kyber Crystal");
        iM.setCustomModelData(2);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack greenKyber() {
        ItemStack i = new ItemStack(Material.NETHER_STAR);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.GREEN + "Green Kyber Crystal");
        iM.setCustomModelData(3);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack purpleKyber() {
        ItemStack i = new ItemStack(Material.NETHER_STAR);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.DARK_PURPLE + "Purple Kyber Crystal");
        iM.setCustomModelData(4);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack yellowKyber() {
        ItemStack i = new ItemStack(Material.NETHER_STAR);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.YELLOW + "Yellow Kyber Crystal");
        iM.setCustomModelData(5);
        i.setItemMeta(iM);
        return i;
    }

    public static ItemStack whiteKyber() {
        ItemStack i = new ItemStack(Material.NETHER_STAR);
        ItemMeta iM = i.getItemMeta();
        iM.setDisplayName(ChatColor.WHITE + "White Kyber Crystal");
        iM.setCustomModelData(6);
        i.setItemMeta(iM);
        return i;
    }
}

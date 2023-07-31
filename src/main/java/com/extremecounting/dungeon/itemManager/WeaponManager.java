package com.extremecounting.dungeon.itemManager;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class WeaponManager {

    public static ItemStack lightningRod;
    public static ItemStack pSpear;
    public static ItemStack pSlingshot;
    public static ItemStack pClub;
    public static ItemStack pHammer;
    public static ItemStack pDagger;


    public static void init() {
        createLightningRod();
        createPSpear();
        createPSlingshot();
        createPClub();
        createPHammer();
        createPDagger();
    }

    private static void createLightningRod() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§6Lightning Rod");
        meta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        lightningRod = item;
    }

    private static void createPSpear() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fSpear");
        item.setItemMeta(meta);
        pSpear = ItemUtility.primitiveTag(item);
    }

    private static void createPSlingshot() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fSlingshot");
        //meta = ItemUtility.primitiveTag(meta);
        item.setItemMeta(meta);
        pSlingshot = ItemUtility.primitiveTag(item);
    }

    private static void createPClub() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fClub");
        //meta = ItemUtility.primitiveTag(meta);
        item.setItemMeta(meta);
        pClub = ItemUtility.primitiveTag(item);
    }

    private static void createPHammer() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fHammer");
        //meta = ItemUtility.primitiveTag(meta);
        item.setItemMeta(meta);
        pHammer = ItemUtility.primitiveTag(item);
    }

    private static void createPDagger() {
        ItemStack item = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fDagger");
        //meta = ItemUtility.primitiveTag(meta);
        item.setItemMeta(meta);
        pDagger = ItemUtility.primitiveTag(item);
    }


}

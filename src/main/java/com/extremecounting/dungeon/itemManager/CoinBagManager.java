package com.extremecounting.dungeon.itemManager;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CoinBagManager {

    public static ItemStack coinBag;
    public static ItemStack tinCoin;
    public static ItemStack copperCoin;
    public static ItemStack silverCoin;
    public static ItemStack goldCoin;


    public static void init() {
        createCoinBag();
        createTinCoin();
        createCopperCoin();
        createSilverCoin();
        createGoldCoin();
    }

    private static void createCoinBag() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.of("#ffff4d") + "Coin Bag");
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.of("#858585") + "Tier §l§f»1«");
        lore.add(ChatColor.of("#e6e6e6") + "Tin Coins §l§f»0«");
        lore.add(ChatColor.of("#b85233") + "Copper Coins §l§f»0«");
        lore.add(ChatColor.of("#c0c0c0") + "Silver Coins §l§f»0«");
        lore.add(ChatColor.of("#fcc200") + "Gold Coins §l§f»0«");
        meta.setLore(lore);
        item.setItemMeta(meta);
        coinBag = item;
    }

    private static void createTinCoin() {
        ItemStack item = new ItemStack(Material.IRON_NUGGET, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fConvert to Tin Coins");
        List<String> lore = new ArrayList<>();
        lore.add("§fConvert coins into tin coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        tinCoin = item;
    }

    private static void createCopperCoin() {
        ItemStack item = new ItemStack(Material.COPPER_INGOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fConvert to Copper Coins");
        List<String> lore = new ArrayList<>();
        lore.add("§fConvert coins into copper coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        copperCoin = item;
    }

    private static void createSilverCoin() {
        ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fConvert to Silver Coins");
        List<String> lore = new ArrayList<>();
        lore.add("§fConvert coins into silver coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        silverCoin = item;
    }

    private static void createGoldCoin() {
        ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fConvert to Gold Coins");
        List<String> lore = new ArrayList<>();
        lore.add("§fConvert coins into gold coins");
        meta.setLore(lore);
        item.setItemMeta(meta);
        goldCoin = item;
    }
}

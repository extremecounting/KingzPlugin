package com.extremecounting.dungeon.itemManager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    public static List<ItemStack> rapture;
    public static List<ItemStack> poison;
    public static List<ItemStack> scavenger;
    public static List<ItemStack> serrated;

    public static void init() {
        createRapture();
        createPoison();
        createScavenger();
    }

    public static void createRapture() {
        rapture.add(createBook("§fRapture I", "§fIncreases damage by 10%"));
        rapture.add(createBook("§fRapture II", "§fIncreases damage by 20%"));
        rapture.add(createBook("§fRapture III", "§fIncreases damage by 30%"));
        rapture.add(createBook("§fRapture IV", "§fIncreases damage by 40%"));
        rapture.add(createBook("§fRapture V", "§fIncreases damage by 50%"));
        rapture.add(createBook("§fRapture VI", "§fIncreases damage by 60%"));
        rapture.add(createBook("§fRapture VII", "§fIncreases damage by 70%"));
        rapture.add(createBook("§fRapture VIII", "§fIncreases damage by 80%"));
        rapture.add(createBook("§fRapture IX", "§fIncreases damage by 90%"));
        rapture.add(createBook("§fRapture X", "§fIncreases damage by 100%"));

    }

    public static void createPoison() {
        poison.add(createBook("§fPoison I", "§fGives enemies wither 1"));
        poison.add(createBook("§fPoison II", "§fGives enemies wither 2"));
        poison.add(createBook("§fPoison III", "§fGives enemies wither 3"));
        poison.add(createBook("§fPoison IV", "§fGives enemies wither 4"));
        poison.add(createBook("§fPoison V", "§fGives enemies wither 5"));
        poison.add(createBook("§fPoison VI", "fGives enemies wither 6"));
        poison.add(createBook("§fPoison VII", "§fGives enemies wither 7"));
        poison.add(createBook("§fPoison VIII", "§fGives enemies wither 8"));
        poison.add(createBook("§fPoison IX", "§fGives enemies wither 9"));
        poison.add(createBook("§fPoison X", "§fGives enemies wither 10"));
    }

    public static void createScavenger() {
        scavenger.add(createBook("§Scavenger I", "§fGives chance for enemies to drop coins"));
        scavenger.add(createBook("§fScavenger II", "§fGives chance for enemies to drop coins", "§fIncreased by 35%"));
        scavenger.add(createBook("§fScavenger III", "§fGives chance for enemies to drop coins", "§fIncreased by 70%"));
        scavenger.add(createBook("§fScavenger IV", "§fGives chance for enemies to drop coins", "§fIncreased by 105%"));
        scavenger.add(createBook("§fScavenger V", "§fGives chance for enemies to drop coins", "§fIncreased by 140%"));
        scavenger.add(createBook("§fScavenger VI", "§fGives chance for enemies to drop coins", "§fIncreased by 175%"));
        scavenger.add(createBook("§fScavenger VII", "§fGives chance for enemies to drop coins", "§fIncreased by 210%"));
        scavenger.add(createBook("§fScavenger VIII", "§fGives chance for enemies to drop coins", "§fIncreased by 245%"));
        scavenger.add(createBook("§fScavenger IX", "§fGives chance for enemies to drop coins", "§fIncreased by 280%"));
        scavenger.add(createBook("§fScavenger X", "§fGives chance for enemies to drop coins", "§fIncreased by 315%"));
    }

    public static ItemStack createBook(String name, String lore1) {
        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(lore1);
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack createBook(String name, String lore1, String lore2) {
        ItemStack item = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = item.getItemMeta();
        List<String> lore = new ArrayList<>();
        lore.add(lore1);
        lore.add(lore2);
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return item;
    }
}

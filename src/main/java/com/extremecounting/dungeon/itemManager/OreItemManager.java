package com.extremecounting.dungeon.itemManager;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class OreItemManager {


    public static ItemStack tinOre;

    public static void init() {
        createTinOre();
    }


    private static void createTinOre() {
        ItemStack item = new ItemStack(Material.COAL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fTin Ore");
        List<String> lore = new ArrayList<>();
        lore.add("§7A basic ore");
        meta.setLore(lore);
        item.setItemMeta(meta);
        tinOre = item;
    }
}

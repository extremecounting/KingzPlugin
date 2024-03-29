package com.extremecounting.dungeon.itemManager;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ToolManager {


    public static ItemStack pPickaxe;

    public static void init() {
        createPPickaxe();
    }


    private static void createPPickaxe() {
        ItemStack item = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fPickaxe");
        List<String> lore = new ArrayList<>();
        lore.add("§7A weak pickaxe");
        lore.add("§7§lPrimitive I §r§8[0/25]");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        pPickaxe = item;
    }

}

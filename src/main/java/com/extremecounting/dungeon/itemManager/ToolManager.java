package com.extremecounting.dungeon.itemManager;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ToolManager {


    public static ItemStack pPickaxe;

    public static void init() {
        createPPickaxe();
    }


    private static void createPPickaxe() {
        ItemStack item = new ItemStack(Material.STONE_PICKAXE, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fPickaxe");
        meta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        pPickaxe = item;
    }

}

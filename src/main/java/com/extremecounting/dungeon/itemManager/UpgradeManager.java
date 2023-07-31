package com.extremecounting.dungeon.itemManager;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class UpgradeManager {

    public static ItemStack pSharpener;

    public static void init() {
        createPSharpener();
    }

    private static void createPSharpener() {
        ItemStack item = new ItemStack(Material.COAL, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fSharpener");
        item.setItemMeta(meta);
        pSharpener = ItemUtility.primitiveTag(item);
    }
}

package com.extremecounting.dungeon.npcs;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUIUtil {

    public static void createInv(Inventory inv, Material material) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, item);
            inv.setItem(i + 9, item);
            inv.setItem(i + 18, item);
            inv.setItem(i + 27, item);
            inv.setItem((i + 36), item);
        }
        item = new ItemStack(Material.BARRIER);
        meta = item.getItemMeta();
        meta.setDisplayName("§c§lExit");
        item.setItemMeta(meta);
        inv.setItem(40, item);
    }

}

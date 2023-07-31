package com.extremecounting.dungeon.guis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StartGUI {



    public Inventory createStartGUI() {
        ItemStack border = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta meta = border.getItemMeta();
        meta.setDisplayName(" ");
        border.setItemMeta(meta);
        Inventory startGUI = Bukkit.getServer().createInventory(null, 45, "§8Trader Shop");
        startGUI.setItem(0, new ItemStack(Material.STICK));
        for (int i = 0; i < 9; i++) {
            startGUI.setItem(i, border);
            startGUI.setItem((i + 36), border);
        }
        for (int i = 0; i < 3; i++) {
            startGUI.setItem((i*9)+9, border);
            startGUI.setItem((i*9)+17, border);
        }
        startGUI.setItem(40, new ItemStack(Material.BARRIER));
        return startGUI;
    }
}

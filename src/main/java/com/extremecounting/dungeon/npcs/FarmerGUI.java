package com.extremecounting.dungeon.npcs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FarmerGUI {

    public Inventory inv;

    public FarmerGUI() {

        inv = Bukkit.createInventory(null, 45, "§aFarmer");
        init();


    }

    public void init() {
        GUIUtil.createInv(inv, Material.YELLOW_STAINED_GLASS_PANE);


    }

}

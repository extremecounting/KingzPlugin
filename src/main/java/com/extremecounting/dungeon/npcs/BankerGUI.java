package com.extremecounting.dungeon.npcs;

import com.extremecounting.dungeon.itemManager.CoinBagManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;

public class BankerGUI {

    public Inventory inv;

    public BankerGUI() {
        inv = Bukkit.createInventory(null, 45, "§aFarmer");
        GUIUtil.createInv(inv, Material.YELLOW_STAINED_GLASS_PANE);
        inv.setItem(10, CoinBagManager.tinCoin);
        inv.setItem(11, CoinBagManager.copperCoin);
        inv.setItem(12, CoinBagManager.silverCoin);
        inv.setItem(13, CoinBagManager.goldCoin);

    }
}

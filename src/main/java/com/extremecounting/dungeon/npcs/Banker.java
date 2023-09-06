package com.extremecounting.dungeon.npcs;

import com.extremecounting.dungeon.guis.StartGUI;
import com.extremecounting.dungeon.itemManager.CoinBagManager;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Banker implements Listener {

    public static void spawnFarmer(Location location) {
        Villager villager = location.getWorld().spawn(location, Villager.class);
        NPCUtil.setupNPC(villager, "Banker");
        villager.addScoreboardTag("Banker");
    }

    @EventHandler
    public void onRightClick(PlayerInteractEntityEvent event) {
        if ((event.getRightClicked().getType() == EntityType.VILLAGER) &&
                (event.getRightClicked().getName().equals("Banker"))) {
            event.setCancelled(true);
            BankerGUI bankerGUI = new BankerGUI();
            event.getPlayer().openInventory(bankerGUI.inv);
        }
    }

    @EventHandler
    public void onInteract(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) {
            return;
        }
        if (!event.getInventory().getItem(10).equals(CoinBagManager.tinCoin)) {
            return;
        }
        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§c§lExit");
        item.setItemMeta(meta);
        if (event.getCurrentItem().equals(item)) {
            player.closeInventory();
        }
        if (event.getCurrentItem().equals(CoinBagManager.tinCoin)) {
            event.getInventory().clear();
            GUIUtil.createInv(event.getInventory(), Material.YELLOW_STAINED_GLASS_PANE);

        }
    }
}

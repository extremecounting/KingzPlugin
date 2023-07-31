package com.extremecounting.dungeon.events;

import com.extremecounting.dungeon.guis.StartGUI;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

public class InteractEvent implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEntityEvent event) {
        if (event.getRightClicked().getType() == EntityType.IRON_GOLEM) {
            event.setCancelled(true);
            Inventory inventory = new StartGUI().createStartGUI();
            event.getPlayer().openInventory(inventory);
        }

    }
}

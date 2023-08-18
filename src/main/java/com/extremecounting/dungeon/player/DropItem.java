package com.extremecounting.dungeon.player;

import com.extremecounting.dungeon.coins.Coinbag;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class DropItem implements Listener {

    @EventHandler
    public void dropItem(PlayerDropItemEvent event) {

        if (event.getPlayer().isOp()) {
            return;
        }
        event.setCancelled(true);
    }
}

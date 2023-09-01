package com.extremecounting.dungeon.player;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItem implements Listener {

    @EventHandler
    public void dropItem(PlayerDropItemEvent event) {

        World world = event.getPlayer().getWorld();

        if (event.getPlayer().isOp()) {
            return;
        }
        event.setCancelled(true);
    }
}

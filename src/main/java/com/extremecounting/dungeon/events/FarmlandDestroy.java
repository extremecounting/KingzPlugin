package com.extremecounting.dungeon.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class FarmlandDestroy implements Listener {

    @EventHandler
    public void onFarmDestroy(PlayerInteractEvent event) {
        if (event.getAction() == Action.PHYSICAL) {
            Block block = event.getClickedBlock();
            if (block == null) return;

            // If the block is farmland (soil)
            if (block.getType() == Material.FARMLAND){

                // Deny event and set the block
                event.setUseInteractedBlock(org.bukkit.event.Event.Result.DENY);
                event.setCancelled(true);
            }
        }

        if (event.getAction() != Action.PHYSICAL) {
            return;
        }

        Block block = event.getClickedBlock();
        if (block == null) return;
        if (block.getType() != Material.FARMLAND) return;

        event.setCancelled(true);
    }
}

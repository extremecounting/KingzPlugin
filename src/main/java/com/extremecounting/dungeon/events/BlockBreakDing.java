package com.extremecounting.dungeon.events;


import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;
import java.util.Random;

public class BlockBreakDing implements Listener {

    @EventHandler
    public void BlockBreak(BlockBreakEvent event) {
        /*
        Random random = new Random();

        Player player = event.getPlayer();
        String name = player.getName();
        player.sendMessage(name);
        player.playNote(player.getLocation(), Instrument.BELL, new Note(random.nextInt(0,14)));
        List<Entity> entities = player.getWorld().getEntities();
        for (Entity entity : entities) {
            if (entity instanceof Player) {
                continue;
            }
            if (entity.getLocation().distance(player.getLocation()) < 5) {
                player.sendMessage(String.valueOf(entity.getLocation().distance(player.getLocation())));
                player.sendMessage(entity.getName());
            }
        }

         */
    }
}

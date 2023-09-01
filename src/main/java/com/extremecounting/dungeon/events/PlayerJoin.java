package com.extremecounting.dungeon.events;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.player.PlayerConfig;
import com.extremecounting.dungeon.player.ScoreboardUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.UUID;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws IOException {
        UUID playerUUID = event.getPlayer().getUniqueId();
        PlayerConfig.playerConfigCreate(Dungeon.usersFolder, playerUUID);
        event.getPlayer().sendMessage("§3Hey, " + event.getPlayer().getName() + "!");
        ScoreboardUtil.loadScoreboard(event.getPlayer());
        //Bukkit.broadcastMessage(event.getPlayer().getLocation().toString());

    }


}

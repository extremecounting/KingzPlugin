package com.extremecounting.dungeon.rpg;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.island.IslandUtility;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.io.IOException;

public class Kills implements Listener {

    @EventHandler
    public static void onKill(EntityDamageByEntityEvent event) {
        if (!event.getEntity().isDead()) {
            return;
        }
        if (!(event.getDamager() instanceof Player)) {
            event.setCancelled(true);
            event.getEntity().remove();
            return;
        }
        Player player = (Player) event.getDamager();

        if (event.getEntity() instanceof Zombie) {
            if (event.getEntity().getScoreboardTags().contains("bandit")) {

            }
        }

        FileConfiguration playerData = IslandUtility.getIslandConfig(Dungeon.usersFolder, player);
        playerData.set("basic.kills", ((int) playerData.get("basic.kills")) + 1);
        try {
            playerData.save(IslandUtility.getIslandFile(Dungeon.usersFolder, player));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

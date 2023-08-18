package com.extremecounting.dungeon.rpg;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.coins.Coinbag;
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
import java.util.Set;

public class Kills implements Listener {

    @EventHandler
    public static void onKill(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            event.setCancelled(true);
            event.getEntity().remove();
            return;
        }
        Player player = (Player) event.getDamager();

        if (event.getEntity() instanceof Zombie) {
            Zombie zombie = (Zombie) event.getEntity();
            /*
            if (zombie.getHealth() > 0) {
                Bukkit.broadcastMessage("not dead");
                return;
            }
            Set<String> scoreboards = event.getEntity().getScoreboardTags();
            for (String string : scoreboards) {
                Bukkit.broadcastMessage(string);
            }

             */
            if (event.getEntity().getScoreboardTags().contains("bandit1")) {
                Coinbag coinbag = new Coinbag(player);
                if (coinbag.coinBag != null) {
                    player.sendMessage("test123");
                    coinbag.addTinCoins(5);
                    coinbag.reload();
                }
            }
        }

        /*
        FileConfiguration playerData = IslandUtility.getIslandConfig(Dungeon.usersFolder, player);
        playerData.set("basic.kills", ((int) playerData.get("basic.kills")) + 1);
        try {
            playerData.save(IslandUtility.getIslandFile(Dungeon.usersFolder, player));
        } catch (IOException e) {
            e.printStackTrace();
        }

         */


    }
}

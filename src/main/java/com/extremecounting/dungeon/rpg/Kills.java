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
    public static void onKill(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();

        if (event.getEntity() instanceof Zombie) {
            Zombie zombie = (Zombie) event.getEntity();
            if (event.getEntity().getScoreboardTags().contains("bandit1")) {
                Coinbag coinbag = new Coinbag(player);
                if (coinbag.coinBag != null) {
                    coinbag.addTinCoins(5);
                }
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

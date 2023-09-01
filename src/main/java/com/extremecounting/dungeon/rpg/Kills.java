package com.extremecounting.dungeon.rpg;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.coins.Coinbag;
import com.extremecounting.dungeon.island.IslandUtility;
import com.extremecounting.dungeon.itemManager.QuestItemManager;
import com.extremecounting.dungeon.itemManager.WeaponManager;
import com.extremecounting.dungeon.mobs.Bandit;
import com.extremecounting.dungeon.player.PlayerConfig;
import com.extremecounting.dungeon.player.ScoreboardUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Set;

public class Kills implements Listener {

    @EventHandler
    public static void onKill(EntityDeathEvent event) {

        if (event.getEntity().getKiller() == null) {
            Bukkit.broadcastMessage("somehow null?");
            return;
        }

        Player player = event.getEntity().getKiller();

        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(file);
        ScoreboardUtil.saveScoreboard(player);
        if (event.getEntity() instanceof Zombie) {
            if (event.getEntity().getScoreboardTags().contains("bandit1")) {
                if (playerConfig.contains("questmob.bandit")) {
                    if (playerConfig.getInt("questmob.bandit") < 2) {
                        playerConfig.set("questmob.bandit", 0);
                    } else {
                        playerConfig.set("questmob.bandit", playerConfig.getInt("questmob.bandit") - 1);
                    }
                    ScoreboardUtil.questScoreboard(player, "Kill bandits:",
                            playerConfig.getInt("questmob.bandit"));
                }
                Coinbag coinbag = new Coinbag(player);
                if (coinbag.coinBag != null) {
                    coinbag.addTinCoins(5);
                }
                Bandit.dropTable(player, 0);
                if (playerConfig.contains("getwalkingstick.walkingstick")) {
                    Random random = new Random();
                    if (random.nextInt(0, 100) < 3) {
                        player.getInventory().addItem(QuestItemManager.walkingStick);
                        playerConfig.set("getwalkingstick.walkingstick", null);
                    }
                }
                try {
                    playerConfig.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
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

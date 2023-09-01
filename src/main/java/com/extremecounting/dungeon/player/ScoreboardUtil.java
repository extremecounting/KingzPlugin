package com.extremecounting.dungeon.player;

import com.extremecounting.dungeon.Dungeon;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ScoreboardUtil {





    public static void setupScoreboard(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Criteria criteria = Criteria.DUMMY;
        Objective objective = scoreboard.registerNewObjective("kingz", criteria, "§c§lKingz");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        Score onlineName = objective.getScore(ChatColor.GRAY + "» Online");
        onlineName.setScore(15);
        player.setScoreboard(scoreboard);

    }



    public static Scoreboard questScoreboard(Player player, String name, int amount) {
        Objective objective = player.getScoreboard().getObjective("kingz");
        objective.getScore(name).setScore(amount);
        player.setScoreboard(objective.getScoreboard());
        return null;
    }

    public static Scoreboard removeQuestScoreboard(Player player, String name) {
        Objective objective = player.getScoreboard().getObjective("kingz");
        objective.getScoreboard().resetScores(name);
        player.setScoreboard(objective.getScoreboard());
        return null;
    }

    public static void saveScoreboard(Player player) {
        Scoreboard scoreboard = player.getScoreboard();
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(file);
        Set<Objective> objectiveSet = scoreboard.getObjectives();
        Iterator<String> Entries = scoreboard.getEntries().iterator();
        List<String> ScoreList = new ArrayList<>();
        playerConfig.set("scoreboard.entries", scoreboard.getEntries().stream().toList());
        for (Objective objective : objectiveSet) {
            while (Entries.hasNext()) {
                playerConfig.set("scoreboard.name", objective.getDisplayName());
                String entry = Entries.next();
                ScoreList.add(String.valueOf(objective.getScore(entry).getScore()));

            }
        }
        playerConfig.set("scoreboard.scores", ScoreList);
        try {
            playerConfig.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadScoreboard(Player player) {
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(file);
        if (playerConfig.get("scoreboard.name") == null) {
            setupScoreboard(player);
            Bukkit.broadcastMessage("SETUP");
            return;
        }
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Criteria criteria = Criteria.DUMMY;
        Objective objective = scoreboard.registerNewObjective("kingz", criteria, playerConfig.getString("scoreboard.name"));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        List<String> entries = (List<String>) playerConfig.getList("scoreboard.entries");
        Iterator<String> scores = (Iterator<String>) playerConfig.getList("scoreboard.scores").iterator();
        for (String entry : entries) {
            String score = scores.next();
            objective.getScore(entry).setScore(Integer.parseInt(score));
        }

        player.setScoreboard(scoreboard);
    }


}

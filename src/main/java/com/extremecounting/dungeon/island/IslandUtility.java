package com.extremecounting.dungeon.island;

import com.extremecounting.dungeon.Dungeon;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class IslandUtility {

    public static boolean[][] islands = new boolean[12][10000];


    public static void createConfigMain() throws IOException {

        File islandFile = new File(Dungeon.islandFolder, "main.yml");
        islandFile.createNewFile();

        List<Integer> originCords = new ArrayList<>();
        originCords.add(0);
        originCords.add(50);
        originCords.add(0);

        FileConfiguration islandConfig = YamlConfiguration.loadConfiguration(islandFile);
        islandConfig.set("world.name", "world");
        islandConfig.set("world.origin", originCords);
        islandConfig.set("world.offset", 350);
        islandConfig.set("world.baseSize", 100);

        islandConfig.set("antiLag.allowRedstone", false);
        islandConfig.set("antiLag.doorCount", 16);
        islandConfig.set("antiLag.maxEntities", 30);
        islandConfig.set("antiLag.tntExplosion", false);

        islandConfig.save(islandFile);
    }

    public static void createIslandConfig(int x, int z, Player player) throws IOException {
        String fileName = x + "," + z + "_" + player.getUniqueId() + ".yml";
        File playerIslandFile = new File(Dungeon.islandFolder, fileName);
            playerIslandFile.createNewFile();

        FileConfiguration playerIslandConfig = YamlConfiguration.loadConfiguration(playerIslandFile);

        playerIslandConfig.set("player.name", player.getName());

        List<Integer> cords = new ArrayList<>();
        cords.add(x);
        cords.add(200);
        cords.add(z);
        playerIslandConfig.set("island.public", false);
        playerIslandConfig.set("island.location", cords);
        playerIslandConfig.set("island.level", 1);
        playerIslandConfig.set("island.doorCount", 0);
        playerIslandConfig.set("island.entitiyCount", 0);

        playerIslandConfig.save(playerIslandFile);

    }

    public static boolean islandLocationTaken(int x, int z) {
        File[] islandFiles = Dungeon.islandFolder.listFiles();
        if (islandFiles == null) {
            return false;
        }
        String location = x + "," + z;
        for (File file : islandFiles) {
            if (file.getName().startsWith(location)) {
                Bukkit.broadcastMessage(x + " " + z);
                return true;
            }
        }
        return false;
    }

    public static boolean playerHasIsland(Player player) {
        File[] islandFiles = Dungeon.islandFolder.listFiles();
        if (islandFiles == null) {
            return false;
        }
        for (File file : islandFiles) {
            if (file.getName().endsWith(player.getUniqueId() + ".yml")) {
                return true;
            }
        }
        return false;
    }

    public static File getIslandFile(File islandFolder, Player player) {
        File[] islandFiles = islandFolder.listFiles();
        if (islandFiles == null) {
            return null;
        }
        List<UUID> playerFileNames = new ArrayList<>();
        for (File file : islandFiles) {
            playerFileNames.add(UUID.fromString(file.getName().substring(0, file.getName().length() - 4)));
        }
        if (!playerFileNames.contains(player.getUniqueId())) {
            return null;
        }
        return new File(islandFolder, player.getUniqueId() + ".yml");
    }

    public static FileConfiguration getIslandConfig(File islandFolder, Player player) {
        File file = getIslandFile(islandFolder, player);
        return YamlConfiguration.loadConfiguration(file);
    }
}

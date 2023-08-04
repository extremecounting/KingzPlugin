package com.extremecounting.dungeon.mobs;

import com.extremecounting.dungeon.Dungeon;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpawnerUtil {


    public static Plugin pluginInstance;
    final static int spawnDelayTicks = 40;

    public static List<BanditSpawner> banditSpawners = new ArrayList<>();
    public static boolean spawnerOn;

    public static void startSpawning() {
        Bukkit.broadcastMessage("Starting!");

        new BukkitRunnable() {
            @Override
            public void run() {
                if (spawnerOn) {
                    for (BanditSpawner banditSpawner : banditSpawners) {
                        if (!banditSpawner.maxMobsReached()) {
                            banditSpawner.spawnBandit();
                            banditSpawner.mobsIntIncr();
                            Bukkit.broadcastMessage("Total mobs " + banditSpawner.name + " : " + banditSpawner.mobsInt);
                        }
                    }
                }
            }
        }.runTaskTimer(pluginInstance, 0, spawnDelayTicks);
    }

    public static void getBanditSpawners(String folderName) {
        List<BanditSpawner> banditSpawnerList = new ArrayList<>();
        File folder = new File(Dungeon.spawnerFolder, folderName);
        File[] files = folder.listFiles();
        for (File file : files) {
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            BanditSpawner banditSpawner = new BanditSpawner((String) config.get("name"),
                    (Location) config.get("location"), (Integer) config.get("maxmobs"),
                    (Integer) config.get("spawnrate"), (Integer) config.get("mobsperspawn"),
                    (Integer) config.get("sizeX"), (Integer) config.get("sizeZ"));
            banditSpawnerList.add(banditSpawner);
        }
        if (banditSpawnerList.size() < 1) {
            return;
        }
        banditSpawners = banditSpawnerList;
    }


    public static void createSpawnerConfigFolder(String folderName) {
        File file = new File(Dungeon.spawnerFolder, folderName);
        file.mkdirs();
    }

    public static FileConfiguration getSpawnerConfigFile(String parent, String name) {
        File parent1 = new File(Dungeon.spawnerFolder, parent);
        File file = new File(parent1, name + ".yml");
        return YamlConfiguration.loadConfiguration(file);
    }

    public static void reloadSpawners(String parent, String type) {
        File parent1 = new File(Dungeon.spawnerFolder, parent);
        File[] files = parent1.listFiles();
        if (type.equalsIgnoreCase("bandit")) {
            banditSpawners = new ArrayList<>();
            for (File file : files) {
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);
                BanditSpawner banditSpawner = new BanditSpawner((String) config.get("name"),
                        (Location) config.get("location"), (Integer) config.get("maxmobs"),
                        (Integer) config.get("spawnrate"), (Integer) config.get("mobsperspawn"),
                        (Integer) config.get("sizeX"), (Integer) config.get("sizeZ"));
                banditSpawners.add(banditSpawner);
            }
        }

    }
}

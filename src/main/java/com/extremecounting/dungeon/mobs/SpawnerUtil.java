package com.extremecounting.dungeon.mobs;

import com.extremecounting.dungeon.Dungeon;
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
    final int spawnDelayTicks = 40;

    public void startSpawning() {

        List<BanditSpawner> banditSpawners = new ArrayList<>();

        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimer(pluginInstance, 0, spawnDelayTicks);
    }


    public static void createSpawnerConfigFolder(String folderName) {
        File file = new File(Dungeon.spawnerFolder, folderName);
        file.mkdirs();
    }

    public static void createSpawnerConfigFile(String folderName, String fileName) {
        File parent = new File(Dungeon.spawnerFolder, folderName);

        File file = new File(parent, fileName + ".yml");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveToConfigSpawner(String folderName, String fileName, String name, Object object) {
        File parent = new File(Dungeon.spawnerFolder, folderName);
        File file = new File(parent, fileName + ".yml");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileConfiguration spawnerConfig = YamlConfiguration.loadConfiguration(file);

        spawnerConfig.set(name, object);
        try {
            spawnerConfig.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

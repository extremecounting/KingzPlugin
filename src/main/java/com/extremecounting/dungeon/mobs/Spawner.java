package com.extremecounting.dungeon.mobs;

import com.extremecounting.dungeon.Dungeon;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Spawner {

        public String name;
        public Location location;
        public int maxMobs;
        public int spawnRate;
        public int mobsPerSpawn;
        public int sizeX;
        public int sizeZ;
        public int mobsInt;


        //Mob ??
        public Spawner(String name1, Location location1, int maxMobs1, int spawnRate1, int mobsPerSpawn1, int sizeX1, int sizeZ1) {

            name = name1;
            location = location1;
            maxMobs = maxMobs1;
            spawnRate = spawnRate1;
            mobsPerSpawn = mobsPerSpawn1;
            sizeX = sizeX1;
            sizeZ = sizeZ1;
            mobsInt = 0;


        }

        public String getName() {
            return name;
        }

        public Location getLocation() {
            return location;
        }

        public int getMaxMobs() {
            return maxMobs;
        }

        public int getSpawnRate() {
            return spawnRate;
        }

        public int getMobsPerSpawn() {
            return mobsPerSpawn;
        }

        public int getSizeX() {
            return sizeX;
        }

        public int getSizeZ() {
            return sizeZ;
        }

        public int getMobsInt() {return mobsInt;}

        public void setName(String name1) {
            name = name1;
        }

        public void setLocation(Location location1) {
            location = location1;
        }

        public void setMaxMobs(int maxMobs1) {
            maxMobs = maxMobs1;
        }

        public void setSpawnRate(int spawnRate1) {
            spawnRate = spawnRate1;
        }

        public void setMobsPerSpawn(int mobsPerSpawn1) {
            mobsPerSpawn = mobsPerSpawn1;
        }

        public void setSizeX(int sizeX1) {
            sizeX = sizeX1;
        }

        public void setSizeZ(int sizeZ1) {
            sizeZ = sizeZ1;
        }

        public void setMobsInt(int mobsInt1) {mobsInt = mobsInt1;}

        public void mobsIntIncr() {
            mobsInt = mobsInt + 1;
        }

        public void mobsIntDecr() {
            mobsInt = mobsInt - 1;
        }

        public boolean maxMobsReached() {
            if (mobsInt >= maxMobs) {
                return true;
            }
            return false;
        }




        public void createSpawnerConfig() {
            File parent = new File(Dungeon.spawnerFolder, "banditspawner");
            File file = new File(parent, name + ".yml");

            FileConfiguration spawnerConfig = YamlConfiguration.loadConfiguration(file);

            spawnerConfig.set("name", name);
            spawnerConfig.set("location", location);
            spawnerConfig.set("maxmobs", maxMobs);
            spawnerConfig.set("spawnrate", spawnRate);
            spawnerConfig.set("mobsperspawn", mobsPerSpawn);
            spawnerConfig.set("sizeX", sizeX);
            spawnerConfig.set("sizeZ", sizeZ);
            Bukkit.broadcastMessage("test1233");
            try {
                spawnerConfig.save(file);
            } catch (IOException e) {
                Bukkit.broadcastMessage("EH");
                e.printStackTrace();
            }

            Bukkit.broadcastMessage("Test1344");
        }




}

package com.extremecounting.dungeon.mobs;

import com.extremecounting.dungeon.Dungeon;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
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
        public int variant;


        //Mob ??
        public Spawner(String name, Location location, int maxMobs, int spawnRate,
                       int mobsPerSpawn, int sizeX, int sizeZ, int variant) {

            this.name = name;
            this.location = location;
            this.maxMobs = maxMobs;
            this.spawnRate = spawnRate;
            this.mobsPerSpawn = mobsPerSpawn;
            this.sizeX = sizeX;
            this.sizeZ = sizeZ;
            this.mobsInt = 0;
            this.variant = variant;
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

        public int getVar() {return variant;}

        public void setName(String name) {
            this.name = name;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public void setMaxMobs(int maxMobs) {
            this.maxMobs = maxMobs;
        }

        public void setSpawnRate(int spawnRate) {
            this.spawnRate = spawnRate;
        }

        public void setMobsPerSpawn(int mobsPerSpawn) {
            this.mobsPerSpawn = mobsPerSpawn;
        }

        public void setSizeX(int sizeX) {
            this.sizeX = sizeX;
        }

        public void setSizeZ(int sizeZ) {
            this.sizeZ = sizeZ;
        }

        public void setMobsInt(int mobsInt) {this.mobsInt = mobsInt;}

        public void setVar(int variant) {this.variant = variant;}

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




        public void createSpawnerConfig(String type) {
            File parent = new File(Dungeon.spawnerFolder, type);
            File file = new File(parent, name + ".yml");

            FileConfiguration spawnerConfig = YamlConfiguration.loadConfiguration(file);

            spawnerConfig.set("name", name);
            spawnerConfig.set("location", location);
            spawnerConfig.set("maxmobs", maxMobs);
            spawnerConfig.set("spawnrate", spawnRate);
            spawnerConfig.set("mobsperspawn", mobsPerSpawn);
            spawnerConfig.set("sizeX", sizeX);
            spawnerConfig.set("sizeZ", sizeZ);
            spawnerConfig.set("variant", variant);
            try {
                spawnerConfig.save(file);
            } catch (IOException e) {
                Bukkit.broadcastMessage("EH");
                e.printStackTrace();
            }


        }


    public boolean onGround(Location location) {
        Location location1 = new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ());
        if (location1.getBlock().getType() != Material.AIR) {
            if (location1.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                return true;
            }
        } else if (location.getY() < 2) {
            return true;
        }
        return false;
    }
}

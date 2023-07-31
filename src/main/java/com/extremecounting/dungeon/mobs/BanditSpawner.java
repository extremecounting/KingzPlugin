package com.extremecounting.dungeon.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class BanditSpawner {

    public String name;
    public Location location;
    public int maxMobs;
    public int spawnRate;
    public int mobsPerSpawn;
    public int spawnRadius;

    List<Entity> bandits = new ArrayList<>();


    //Mob ??
    public BanditSpawner(String name1, Location location1, int maxMobs1, int spawnRate1, int mobsPerSpawn1, int spawnRadius1) {

        name = name1;
        location = location1;
        maxMobs = maxMobs1;
        spawnRate = spawnRate1;
        mobsPerSpawn = mobsPerSpawn1;
        spawnRadius = spawnRadius1;
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

    public int getSpawnRadius() {
        return spawnRadius;
    }

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

    public void setSpawnRadius(int spawnRadius1) {
        spawnRadius = spawnRadius1;
    }




    /*
    public static void createSpawner(Player player, double x, double y, double z, String name) {
        SpawnerManager spawnerManager = new SpawnerManager(MythicBukkit.inst());
        Location location = new Location(player.getWorld(), x, y, z);
        spawnerManager.createSpawner(name, location, "Zombie");
        PlaceholderInt placeholderInt = PlaceholderInt.of("15");
        spawnerManager.getSpawnerByName(name).setMaxMobs(placeholderInt);
        spawnerManager.getSpawnerByName(name).setCooldownSeconds(4);
        spawnerManager.getSpawnerByName(name).setActivationRange(15);
        spawnerManager.getSpawnerByName(name).setSpawnRadius(6);
        spawnerManager.getSpawnerByName(name).setMobsPerSpawn(3);
        spawnerManager.getSpawnerByName(name).ActivateSpawner();
        spawnerManager.getSpawnerByName(name).Enable();
    }

     */




}

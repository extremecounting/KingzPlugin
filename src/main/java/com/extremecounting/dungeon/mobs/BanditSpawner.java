package com.extremecounting.dungeon.mobs;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BanditSpawner extends Spawner {

    public List<Zombie> bandits = new ArrayList<>();

    //Mob ??
    public BanditSpawner(String name1, Location location1, int maxMobs1, int spawnRate1, int mobsPerSpawn1, int sizeX1, int sizeZ1) {
        super(name1, location1, maxMobs1, spawnRate1, mobsPerSpawn1, sizeX1, sizeZ1);

        name = name1;
        location = location1;
        maxMobs = maxMobs1;
        spawnRate = spawnRate1;
        mobsPerSpawn = mobsPerSpawn1;
        sizeX = sizeX1;
        sizeZ = sizeZ1;
    }


    public static void spawnBandit(Player player) {
        Zombie bandit = Bandit.spawn(player.getLocation(), "empty");

    }

    public static void createBanditSpawner(String name1, Location location1, int maxMobs1, int spawnRate1, int mobsPerSpawn1, int sizeX1, int sizeZ1) {

        BanditSpawner banditSpawner = new BanditSpawner(name1, location1, maxMobs1, spawnRate1, mobsPerSpawn1, sizeX1, sizeZ1);
        SpawnerUtil.banditSpawners.add(banditSpawner);
        banditSpawner.createSpawnerConfig();
    }



    public void spawnBandit() {
        Random random = new Random();
        Location location1 = new Location(location.getWorld(), location.getX() + random.nextInt(0, sizeX + 1), location.getY(), location.getZ() + random.nextInt(0, sizeZ + 1));
        while (!onGround(location1)) {
            location1.subtract(0, 1, 0);
        }
        Bandit.spawn(location1, name);
    }

    public boolean onGround(Location location) {
        Location location1 = new Location(location.getWorld(), location.getX(), location.getY() - 1, location.getZ());
        if (location1.getBlock().getType() != Material.AIR) {
            if (location1.add(0, 1, 0).getBlock().getType() == Material.AIR) {
                return true;
            }
        }
        return false;
    }





    /*
    public void createBanditSpawner() {
        if (bandits.size() == maxMobs) {
            return;
        }
        Random random = new Random();

        Bandit test = location.getWorld().spawn(location.add(
                random.nextInt(0, sizeX + 1), 0, random.nextInt(0, sizeZ + 1)), );
        bandits.add(test);

    }

     */





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

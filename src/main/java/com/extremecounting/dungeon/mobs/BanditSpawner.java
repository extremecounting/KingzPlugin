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
    public BanditSpawner(String name, Location location, int maxMobs, int spawnRate,
                   int mobsPerSpawn, int sizeX, int sizeZ, int variant) {
        super(name, location, maxMobs, spawnRate, mobsPerSpawn, sizeX, sizeZ, variant);

        this.name = name;
        this.location = location;
        this.maxMobs = maxMobs;
        this.spawnRate = spawnRate;
        this.mobsPerSpawn = mobsPerSpawn;
        this.sizeX = sizeX;
        this.sizeZ = sizeZ;
        this.variant = variant;
    }


    public static void spawnBandit(Player player) {
        Bandit bandit = new Bandit();
        bandit.spawn(player.getLocation(), "empty", 1);

    }

    public static void createBanditSpawner(String name1, Location location1, int maxMobs1, int spawnRate1, int mobsPerSpawn1, int sizeX1, int sizeZ1, int variant) {

        BanditSpawner banditSpawner = new BanditSpawner(name1, location1, maxMobs1, spawnRate1, mobsPerSpawn1, sizeX1, sizeZ1, variant);
        SpawnerUtil.banditSpawners.add(banditSpawner);
        banditSpawner.createSpawnerConfig("banditspawner");
    }





    public void spawnBandit() {
        Random random = new Random();
        Location location1 = new Location(location.getWorld(), location.getX() + random.nextInt(0, sizeX + 1), location.getY(), location.getZ() + random.nextInt(0, sizeZ + 1));
        while (!onGround(location1)) {
            location1.subtract(0, 1, 0);
        }
        Bandit bandit = new Bandit();
        bandit.spawn(location1, name, variant);
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

package com.extremecounting.dungeon.mobs;

import org.bukkit.Location;
import org.bukkit.Material;

import java.util.Random;

public class HogSpawner extends Spawner{


    public HogSpawner(String name, Location location, int maxMobs, int spawnRate, int mobsPerSpawn, int sizeX, int sizeZ, int variant) {
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

    public static void createHogSpawner(String name1, Location location1, int maxMobs1, int spawnRate1, int mobsPerSpawn1, int sizeX1, int sizeZ1, int variant) {

        HogSpawner hogSpawner = new HogSpawner(name1, location1, maxMobs1, spawnRate1, mobsPerSpawn1, sizeX1, sizeZ1, variant);
        SpawnerUtil.hogSpawners.add(hogSpawner);
        hogSpawner.createSpawnerConfig("hogspawner");
    }



    public void spawnHog() {
        Random random = new Random();
        Location location1 = new Location(location.getWorld(), location.getX() + random.nextInt(0, sizeX + 1), location.getY(), location.getZ() + random.nextInt(0, sizeZ + 1));
        while (!onGround(location1)) {
            location1.subtract(0, 1, 0);
        }
        Hog hog = new Hog();
        hog.spawn(location1, name, variant);
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

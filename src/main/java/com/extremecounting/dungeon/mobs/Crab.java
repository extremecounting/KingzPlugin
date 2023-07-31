package com.extremecounting.dungeon.mobs;

import org.bukkit.Location;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Silverfish;

public class Crab {

    public static Endermite crab;

    public static void spawnCrab(Location location) {
        Endermite endermite = location.getWorld().spawn(location, Endermite.class);
        endermite.setHealth(5.0);
        endermite.damage(1.0);
        endermite.setCustomName("Crab");
        crab = endermite;
    }
}

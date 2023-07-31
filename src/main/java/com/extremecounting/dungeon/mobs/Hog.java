package com.extremecounting.dungeon.mobs;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.Location;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Zombie;

public class Hog {

    public static Pig hog;

    public static void spawnHog(Location location) {
        Pig pig = location.getWorld().spawn(location, Pig.class);
        pig.setHealth(5.0);
        pig.damage(1.0);
        pig.setAdult();
        pig.setCustomName("Wild Hog");
        hog = pig;
    }

}

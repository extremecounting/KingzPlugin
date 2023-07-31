package com.extremecounting.dungeon.mobs;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.Location;
import org.bukkit.entity.Zombie;


public class Bandit {

    public static Zombie bandit;

    public static void spawnBandit(Location location) {
        Zombie zombie = location.getWorld().spawn(location, Zombie.class);
        zombie.setHealth(5.0);
        zombie.damage(1.0);
        zombie.setCanBreakDoors(false);
        zombie.setAdult();
        zombie.setCustomName("Bandit");
        PlayerDisguise playerDisguise = new PlayerDisguise("extremecounting");
        DisguiseAPI.disguiseEntity(zombie, playerDisguise);
        bandit = zombie;
    }


}

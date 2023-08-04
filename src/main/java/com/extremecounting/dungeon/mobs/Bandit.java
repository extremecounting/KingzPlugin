package com.extremecounting.dungeon.mobs;

import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.Location;
import org.bukkit.entity.Zombie;
import org.bukkit.loot.LootTable;

public class Bandit {

    public static Zombie spawn(Location location, String tag) {
        Zombie zombie = location.getWorld().spawn(location, Zombie.class);
        return createBandit(zombie, tag);
    }

    private static Zombie createBandit(Zombie zombie, String tag) {
        zombie.setHealth(5.0);
        zombie.damage(1.0);
        zombie.setCanBreakDoors(false);
        zombie.setAdult();
        zombie.setCustomName("Bandit");
        PlayerDisguise playerDisguise = new PlayerDisguise("extremecounting");
        DisguiseAPI.disguiseEntity(zombie, playerDisguise);
        zombie.addScoreboardTag("bandit");
        zombie.addScoreboardTag(tag);
        return zombie;
    }

}








package com.extremecounting.dungeon.npcs;

import org.bukkit.Location;
import org.bukkit.entity.Villager;

public class Banker {

    public static void spawnFarmer(Location location) {
        Villager villager = location.getWorld().spawn(location, Villager.class);
        NPCUtil.setupNPC(villager, "Banker");
        villager.addScoreboardTag("Banker");
    }
}

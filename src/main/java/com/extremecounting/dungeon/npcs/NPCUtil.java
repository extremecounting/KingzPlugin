package com.extremecounting.dungeon.npcs;

import org.bukkit.entity.Villager;

public class NPCUtil {


    public static void setupNPC(Villager villager, String name) {
        villager.setAI(false);
        villager.setAdult();
        villager.setCustomNameVisible(true);
        villager.setInvulnerable(true);
        villager.setCustomName(name);
    }

}

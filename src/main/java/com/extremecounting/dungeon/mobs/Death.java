package com.extremecounting.dungeon.mobs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Death implements Listener {

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Zombie) {
            for (BanditSpawner banditSpawner : SpawnerUtil.banditSpawners) {
                if (event.getEntity().getScoreboardTags().contains(banditSpawner.name)) {
                    banditSpawner.mobsIntDecr();
                }
            }
        }


    }
}

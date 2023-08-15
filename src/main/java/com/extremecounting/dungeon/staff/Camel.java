package com.extremecounting.dungeon.staff;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Camel {


    public static void spawnJester(Location location) {
        org.bukkit.entity.Camel camel = location.getWorld().spawn(location, org.bukkit.entity.Camel.class);
        camel.setCustomName("Jester");
        camel.setHealth(999999);
        camel.setAdult();
        camel.setCustomNameVisible(true);
        camel.setInvulnerable(true);
        camel.setTamed(true);
    }


    public static void cleanEntities() {
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        List<Entity> entities = new ArrayList<>();
        for (Player player : players) {
            entities.addAll(player.getWorld().getEntities());
        }
        for (Entity entity : entities) {
            if (entity.getType() == EntityType.CAMEL && entity.getCustomName().equalsIgnoreCase("Jester")) {
                return;
            }
            if (entity.getType() == EntityType.VILLAGER) {
                return;
            }
            entity.remove();
        }
    }


}

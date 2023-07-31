package com.extremecounting.dungeon.mobs;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import java.util.List;

public class MobsUtility {

    public static Entity getNearestEntity(LivingEntity entity, Location location) {
        List<Entity> entities = entity.getNearbyEntities(10, 10, 10);
        Entity nearestEntity = entities.get(0);
        for (Entity entity1 : entities) {
            if (location.distance(entity1.getLocation()) < location.distance(nearestEntity.getLocation())) {
                nearestEntity = entity1;
            }
        }
        return nearestEntity;
    }

}
package com.extremecounting.dungeon.spells;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuantumShift extends BaseSpell {

    public static Plugin pluginInstance;

    public QuantumShift(Player player, int intensity) {
        super(player, intensity);
    }

    public QuantumShift(Player player) {
        super(player);
    }


    public void effect() {
        List<LivingEntity> entityList = SpellUtil.getEntities(player, 8);
        SpellUtil.createParticleRing(player, Particle.ASH, 8);
        Random random = new Random();
        List<Location> entityLocations = new ArrayList<>();
        Bukkit.getScheduler().runTaskLater(pluginInstance, new Runnable() {
            @Override
            public void run() {
                for (LivingEntity entity : entityList) {
                    entityLocations.add(entity.getLocation());
                    Location location = new Location(entity.getWorld(), entity.getLocation().getX() + (double) (random.nextInt(-10, 10)) /5,
                            entity.getLocation().getY() + (double) (random.nextInt(0, 10)) /5,
                            entity.getLocation().getZ() + (double) (random.nextInt(-10, 10)) /5);
                    entity.teleport(location);
                }
                Bukkit.getScheduler().runTaskLater(pluginInstance, new Runnable() {
                    @Override
                    public void run() {
                        for (LivingEntity entity : entityList) {
                            entity.teleport(entityLocations.get(entityList.indexOf(entity)));
                            if (entity.getHealth() > intensity * 8) {
                                entity.setHealth(0);
                                continue;
                            }
                            entity.setHealth(entity.getHealth() - intensity * 8);
                            entity.damage(0);
                            SpellUtil.freeze(entity, 40);
                        }
                    }
                }, 10L);
            }
        }, 40L);

    }
}

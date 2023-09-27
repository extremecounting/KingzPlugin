package com.extremecounting.dungeon.spells;

import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class Vampire extends BaseSpell {
    public static Plugin pluginInstance;

    public Vampire(Player player, int intensity) {
        super(player, intensity);
    }

    public Vampire(Player player) {
        super(player);
    }


    public void effect() {
        SpellUtil.createParticleRing(player, Particle.REDSTONE, 5);
        List<LivingEntity> entityList = SpellUtil.getEntities(player, 5);
        Random random = new Random();
        new BukkitRunnable() {
            int counter = 5;
            @Override
            public void run() {
                if (counter > 0) {
                    counter--;
                    for (LivingEntity entity : entityList) {
                        entity.setHealth(entity.getHealth()-intensity*2);
                        entity.damage(0);
                        if (random.nextInt(10) < 3) {
                            player.setHealth(player.getHealth() + intensity);
                        }
                    }
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(pluginInstance, 0, 10);
    }

}

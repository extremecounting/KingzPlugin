package com.extremecounting.dungeon.spells;

import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class Freeze {

    Player player;
    int intensity;


    public Freeze(Player player, int intensity) {
        this.player = player;
        this.intensity = intensity;
    }

    public Freeze(Player player) {
        this.player = player;
        this.intensity = 1;
    }

    public void effect() {
        SpellUtil.createParticleRing(player, Particle.DRIP_WATER, 5);
        List<LivingEntity> entityList = SpellUtil.getEntities(player, 5);
        for (LivingEntity entity : entityList) {
            SpellUtil.freeze(entity, 100);
            entity.setHealth(entity.getHealth() - intensity);
            entity.damage(0);
        }
    }
}

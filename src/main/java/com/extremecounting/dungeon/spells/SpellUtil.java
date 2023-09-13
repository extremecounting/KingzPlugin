package com.extremecounting.dungeon.spells;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class SpellUtil {

    public static Plugin pluginInstance;
    public static void createParticleRing(Player player, Particle particle, int range) {
        List<Entity> entityList = player.getNearbyEntities(range, range, range);
        World world = player.getWorld();
        for (Entity entity : entityList) {
            Location location = entity.getLocation();
            for (double i = 0; i < 2 * Math.PI; i += Math.PI / 8) {
                double x = Math.cos(i) * 2;
                double z = Math.sin(i) * 2;
                world.spawnParticle(particle, location.getX() + x, location.getY(), location.getZ() + z, 1);
            }
        }
    }

    public static void damageOverTime(LivingEntity entity, double damage, int delay, int time) {
        new BukkitRunnable() {
            int counter = time / delay;
            @Override
            public void run() {
                if (counter > 0) {
                    counter--;
                    entity.damage(damage);
                } else {
                    cancel();
                }

            }
        }.runTaskTimer(pluginInstance, 0, delay);
    }

    public static void potionEffect(LivingEntity entity, PotionEffectType effectType, int amplifier, int duration, boolean override) {
        int potionlvl = -1;
        if (entity.getPotionEffect(effectType) != null) {
            potionlvl = entity.getPotionEffect(effectType).getAmplifier();
        }
        if (override) {
            entity.addPotionEffect(new PotionEffect(effectType, duration, amplifier, true, false));
            return;
        }
        if (potionlvl > amplifier) {
            return;
        }
        entity.addPotionEffect(new PotionEffect(effectType, duration, amplifier, true, false));
    }

    public static void freeze(LivingEntity entity, int duration) {
        entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration, 99, true, false));
    }

}

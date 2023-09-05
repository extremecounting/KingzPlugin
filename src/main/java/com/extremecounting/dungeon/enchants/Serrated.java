package com.extremecounting.dungeon.enchants;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class Serrated implements Listener {
    public static Plugin pluginInstance;

    public void onDamage(EntityDamageByEntityEvent event) {
        if (EnchantUtil.setup(event) == null) {
            return;
        }
        Player player = EnchantUtil.setup(event);
        ItemStack item = player.getInventory().getItemInMainHand();
        if (!item.getItemMeta().hasLore()) {
            return;
        }
        List<String> lore = item.getItemMeta().getLore();
        String serrated = " ";
        for (String line : lore) {
            if (line.startsWith("§7Serrated ")) {
                serrated = line;
            }
        }
        if (serrated.equals(" ")) {
            return;
        }
        int num = new Random().nextInt(0, 100);
        if (num < 85) {
            return;
        }
        switch (serrated) {
            case "§7Serrated I":
                new BukkitRunnable() {
                    int counter = 6;
                    @Override
                    public void run() {
                        if (counter > 0) {
                            counter--;
                            ((LivingEntity) event.getEntity()).setHealth(((LivingEntity) event.getEntity()).getHealth() * 0.99);
                        } else {
                            cancel();
                        }
                    }
                }.runTaskTimer(pluginInstance, 0, 20);
            case "§7Serrated II":
                new BukkitRunnable() {
                    int counter = 6;
                    @Override
                    public void run() {
                        if (counter > 0) {
                            counter--;
                            ((LivingEntity) event.getEntity()).setHealth(((LivingEntity) event.getEntity()).getHealth() * 0.98);
                        } else {
                            cancel();
                        }
                    }
                }.runTaskTimer(pluginInstance, 0, 20);
            case "§7Serrated III":
                new BukkitRunnable() {
                    int counter = 6;
                    @Override
                    public void run() {
                        if (counter > 0) {
                            counter--;
                            ((LivingEntity) event.getEntity()).setHealth(((LivingEntity) event.getEntity()).getHealth() * 0.97);
                        } else {
                            cancel();
                        }
                    }
                }.runTaskTimer(pluginInstance, 0, 20);
            case "§7Serrated IV":
                new BukkitRunnable() {
                    int counter = 6;
                    @Override
                    public void run() {
                        if (counter > 0) {
                            counter--;
                            ((LivingEntity) event.getEntity()).setHealth(((LivingEntity) event.getEntity()).getHealth() * 0.96);
                        } else {
                            cancel();
                        }
                    }
                }.runTaskTimer(pluginInstance, 0, 20);
            case "§7Serrated V":
                new BukkitRunnable() {
                    int counter = 6;
                    @Override
                    public void run() {
                        if (counter > 0) {
                            counter--;
                            ((LivingEntity) event.getEntity()).setHealth(((LivingEntity) event.getEntity()).getHealth() * 0.95);
                        } else {
                            cancel();
                        }

                    }
                }.runTaskTimer(pluginInstance, 0, 20);
            case "§7Serrated VI":
                new BukkitRunnable() {
                    int counter = 6;
                    @Override
                    public void run() {
                        if (counter > 0) {
                            counter--;
                            ((LivingEntity) event.getEntity()).setHealth(((LivingEntity) event.getEntity()).getHealth() * 0.94);
                        } else {
                            cancel();
                        }
                    }
                }.runTaskTimer(pluginInstance, 0, 20);
            case "§7Serrated VII":
                new BukkitRunnable() {
                    int counter = 6;
                    @Override
                    public void run() {
                        if (counter > 0) {
                            counter--;
                            ((LivingEntity) event.getEntity()).setHealth(((LivingEntity) event.getEntity()).getHealth() * 0.93);
                        } else {
                            cancel();
                        }
                    }
                }.runTaskTimer(pluginInstance, 0, 20);
            case "§7Serrated VIII":
                new BukkitRunnable() {
                    int counter = 6;
                    @Override
                    public void run() {
                        if (counter > 0) {
                            counter--;
                            ((LivingEntity) event.getEntity()).setHealth(((LivingEntity) event.getEntity()).getHealth() * 0.92);
                        } else {
                            cancel();
                        }
                    }
                }.runTaskTimer(pluginInstance, 0, 20);
            case "§7Serrated IX":
                new BukkitRunnable() {
                    int counter = 6;
                    @Override
                    public void run() {
                        if (counter > 0) {
                            counter--;
                            ((LivingEntity) event.getEntity()).setHealth(((LivingEntity) event.getEntity()).getHealth() * 0.91);
                        } else {
                            cancel();
                        }
                    }
                }.runTaskTimer(pluginInstance, 0, 20);
            case "§7Serrated X":
                new BukkitRunnable() {
                    int counter = 6;
                    @Override
                    public void run() {
                        if (counter > 0) {
                            counter--;
                            ((LivingEntity) event.getEntity()).setHealth(((LivingEntity) event.getEntity()).getHealth() * 0.90);
                        } else {
                            cancel();
                        }
                    }
                }.runTaskTimer(pluginInstance, 0, 20);
                break;
            default:
                player.sendMessage("§cUnknown Serrated lvl, contact staff!");
        }



    }

}

package com.extremecounting.dungeon.enchants;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class Rapture implements Listener {

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
        String rapture = " ";
        for (String line : lore) {
            if (line.startsWith("§7Rapture ")) {
                rapture = line;
            }
        }
        if (!rapture.equals(" ")) {
            switch (rapture) {
                case "§7Rapture I" -> {
                    event.setDamage(event.getDamage() * 1.1);
                }
                case "§7Rapture II" -> {
                    event.setDamage(event.getDamage() * 1.2);
                }
                case "§7Rapture III" -> {
                    event.setDamage(event.getDamage() * 1.3);
                }
                case "§7Rapture IV" -> {
                    event.setDamage(event.getDamage() * 1.4);
                }
                case "§7Rapture V" -> {
                    event.setDamage(event.getDamage() * 1.5);
                }
                case "§7Rapture VI" -> {
                    event.setDamage(event.getDamage() * 1.6);
                }
                case "§7Rapture VII" -> {
                    event.setDamage(event.getDamage() * 1.7);
                }
                case "§7Rapture VIII" -> {
                    event.setDamage(event.getDamage() * 1.8);
                }
                case "§7Rapture IX" -> {
                    event.setDamage(event.getDamage() * 1.9);
                }
                case "§7Rapture X" -> {
                    event.setDamage(event.getDamage() * 2.0);
                }
                default -> {
                    player.sendMessage("§cUnknown Rapture lvl, contact staff!");
                }
            }
        }
    }
}

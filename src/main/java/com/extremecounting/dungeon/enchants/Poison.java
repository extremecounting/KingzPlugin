package com.extremecounting.dungeon.enchants;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;
import java.util.Random;

public class Poison implements Listener {

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
        String poison = " ";
        for (String line : lore) {
            if (line.startsWith("§7Poison ")) {
                poison = line;
            }
        }
        if (poison.equals(" ")) {
            return;
        }
        LivingEntity damagee = (LivingEntity) event.getEntity();
        int witherLvl = -1;
        if (damagee.getPotionEffect(PotionEffectType.WITHER) != null) {
            witherLvl = damagee.getPotionEffect(PotionEffectType.WITHER).getAmplifier();
        }
        Random random = new Random();
        int num = random.nextInt(0, 100);
        switch (poison) {
            case "§7Poison I":
              if (witherLvl < 1 && num < 25) {
                  damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 0, false, false));
                  return;
              }
            case "§7Poison II":
                if (witherLvl < 2 && num < 26) {
                    damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 1, false, false));
                    return;
                }
            case "§7Poison III":
                if (witherLvl < 3 && num < 26) {
                    damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 2, false, false));
                    return;
                }
            case "§7Poison IV":
                if (witherLvl < 4 && num < 26) {
                    damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 3, false, false));
                    return;
                }
            case "§7Poison V":
                if (witherLvl < 5 && num < 26) {
                    damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 4, false, false));
                    return;
                }
            case "§7Poison VI":
                if (witherLvl < 6 && num < 26) {
                    damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 5, false, false));
                    return;
                }
            case "§7Poison VII":
                if (witherLvl < 7 && num < 26) {
                    damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 6, false, false));
                    return;
                }
            case "§7Poison VIII":
                if (witherLvl < 8 && num < 26) {
                    damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 7, false, false));
                    return;
                }
            case "§7Poison IX":
                if (witherLvl < 9 && num < 26) {
                    damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 8, false, false));
                    return;
                }
            case "§7Poison X":
                if (witherLvl < 10 && num < 26) {
                    damagee.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 6, 9, false, false));
                    return;
                }
                break;
            default:
                if (num < 26) {
                    player.sendMessage("§cUnknown Poison lvl, contact staff!");
                }
        }
    }
}

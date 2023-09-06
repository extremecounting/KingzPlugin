package com.extremecounting.dungeon.enchants;

import com.extremecounting.dungeon.coins.Coinbag;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

public class Scavenger implements Listener {

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
        String scavenger = " ";
        for (String line : lore) {
            if (line.startsWith("§7Scavenger ")) {
                scavenger = line;
            }
        }
        if (scavenger.equals(" ")) {
            return;
        }
        Coinbag coinbag = new Coinbag(player);
        if (coinbag.coinBag == null) {
            return;
        }
        float coins = Math.round(event.getDamage()/6);
        switch (scavenger) {
            case "§7Scavenger I":
                calculateCoins(coinbag, coins);
            case "§7Scavenger II":
                calculateCoins(coinbag, Math.round(coins * 1.35));
            case "§7Scavenger III":
                calculateCoins(coinbag, Math.round(coins * 1.70));
            case "§7Scavenger IV":
                calculateCoins(coinbag, Math.round(coins * 2.05));
            case "§7Scavenger V":
                calculateCoins(coinbag, Math.round(coins * 2.40));
            case "§7Scavenger VI":
                calculateCoins(coinbag, Math.round(coins * 2.75));
            case "§7Scavenger VII":
                calculateCoins(coinbag, Math.round(coins * 3.10));
            case "§fScavenger VIII":
                calculateCoins(coinbag, Math.round(coins * 3.45));
            case "§7Scavenger IX":
                calculateCoins(coinbag, Math.round(coins * 3.80));
            case "§7Scavenger X":
                calculateCoins(coinbag, Math.round(coins * 4.15));
                break;
            default:
                player.sendMessage("§cUnknown Scavenger lvl, contact staff!");
        }
    }

    public static void calculateCoins(Coinbag coinbag, float amount) {
        //gold = 8000; silver = 400; copper = 20; tin = 1;
        int num = new Random().nextInt(0, 20);
        if (num < 10) {
            amount = Math.round(amount * 1.50);
        } else if (num < 17) {
            amount = Math.round(amount * 2.0);
        } else {
            amount = Math.round(amount * 2.5);
        }
        while (amount >= 8000) {
            amount -= 8000;
            coinbag.addGoldCoins(1);
        }
        while (amount >= 400) {
            amount -= 400;
            coinbag.addSilverCoins(1);
        }
        while (amount >= 20) {
            amount -= 20;
            coinbag.addCopperCoins(1);
        }
        while (amount >= 1) {
            amount -= 1;
            coinbag.addTinCoins(1);
        }
    }

}

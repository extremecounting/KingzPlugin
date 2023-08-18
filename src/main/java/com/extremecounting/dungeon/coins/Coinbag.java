package com.extremecounting.dungeon.coins;

import com.extremecounting.dungeon.itemManager.CoinBagManager;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Coinbag {

    public Player bagOwner;

    public ItemStack coinBag;

    public byte tier;

    public int tinCoins;
    public int copperCoins;
    public int silverCoins;
    public int goldCoins;

    public Coinbag() {
        tinCoins = 0;
        copperCoins = 0;
        silverCoins = 0;
        goldCoins = 0;
        tier = 1;
    }


    public Coinbag(Player player) {
        //player.sendMessage("starting creating coinbag...");
        if (findCoinBag(player) == null) {
            //player.sendMessage("couldn't find it");
            return;
        }
        //player.sendMessage("coinbag wasn't null");
        ItemStack coinBag = findCoinBag(player);
        //player.sendMessage("item saved");
        this.coinBag = coinBag;
        this.bagOwner = player;
        //player.sendMessage("variables saved");
        coinBagSetup(coinBag);
        //player.sendMessage("bag setup " + getTinCoins());
    }

    private void coinBagSetup(ItemStack coinBag) {
        List<String> lore = coinBag.getItemMeta().getLore();
        String line = lore.get(0);
        tier = Byte.parseByte(line.substring(line.indexOf('»') + 1, line.indexOf('«')));
        line = lore.get(1);
        tinCoins = Integer.parseInt(line.substring(line.indexOf('»') + 1, line.indexOf('«')));
        line = lore.get(2);
        copperCoins = Integer.parseInt(line.substring(line.indexOf('»') + 1, line.indexOf('«')));
        line = lore.get(3);
        silverCoins = Integer.parseInt(line.substring(line.indexOf('»') + 1, line.indexOf('«')));
        line = lore.get(4);
        goldCoins = Integer.parseInt(line.substring(line.indexOf('»') + 1, line.indexOf('«')));
    }

    public ItemStack findCoinBag(Player player) {
        for (ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack == null) {
                continue;
            }
            if (itemStack.isSimilar(CoinBagManager.coinBag)) {
                Bukkit.broadcastMessage("this coinbag was found");
                return itemStack;
            }
        }
        return null;
    }

    private int findCoinBagLocation() {
        ItemStack[] inv = bagOwner.getInventory().getContents();
        for (int i = 0; i < inv.length + 1; i++) {
            if (inv[i] == null) {
                continue;
            }
            if (inv[i].isSimilar(CoinBagManager.coinBag)) {
                return i;

            }
        }
        return 0;
    }

    public void reload() {
        bagOwner.sendMessage(String.valueOf(getTinCoins()));
        Bukkit.broadcastMessage(String.valueOf(getTinCoins()));
        List<String> lore = new ArrayList<>();

        lore.add(ChatColor.of("#858585") + "Tier §l§f»" + getTier() + "§l§f«");
        lore.add(ChatColor.of("#e6e6e6") + "Tin Coins §l§f»" + getTinCoins() + "§l§f«");
        lore.add(ChatColor.of("#b85233") + "Copper Coins §l§f»" + getCopperCoins() + "§l§f«");
        lore.add(ChatColor.of("#c0c0c0") + "Silver Coins §l§f»" + getSilverCoins() + "§l§f«");
        lore.add(ChatColor.of("#fcc200") + "Gold Coins §l§f»" + getGoldCoins() + "§l§f«");

        ItemMeta meta = coinBag.getItemMeta();
        meta.setLore(lore);
        coinBag.setItemMeta(meta);

        int location = findCoinBagLocation();

        bagOwner.getInventory().setItem(location, coinBag);

    }

    public ItemStack getCoinBag() {
        return coinBag;
    }

    public byte getTier() {
        return tier;
    }

    public int getTinCoins() {
        return tinCoins;
    }

    public int getCopperCoins() {
        return copperCoins;
    }

    public int getSilverCoins() {
        return silverCoins;
    }

    public int getGoldCoins() {
        return goldCoins;
    }

    public void setTinCoins(int tinCoins) {
        this.tinCoins = tinCoins;
    }

    public void setCopperCoins(int copperCoins) {
        this.copperCoins = copperCoins;
    }

    public void setSilverCoins(int silverCoins) {
        this.silverCoins = silverCoins;
    }

    public void setGoldCoins(int goldCoins) {
        this.goldCoins = goldCoins;
    }

    public void addTinCoins(int tinCoins) {
        this.tinCoins = this.tinCoins + tinCoins;
    }

    public void addCopperCoins(int copperCoins) {
        this.copperCoins += copperCoins;
    }

    public void addSilverCoins(int silverCoins) {
        this.silverCoins += silverCoins;
    }

    public void addGoldCoins(int goldCoins) {
        this.goldCoins += goldCoins;
    }

}

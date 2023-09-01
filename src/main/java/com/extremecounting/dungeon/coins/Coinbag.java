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

    public ItemStack coinBag = null;

    public byte tier;

    public int tinCoins;
    public int copperCoins;
    public int silverCoins;
    public int goldCoins;

    public int maxCoins;

    public Coinbag() {
        tinCoins = 0;
        copperCoins = 0;
        silverCoins = 0;
        goldCoins = 0;
        tier = 1;
        maxCoins = 10 * (10^tier);
    }

    public Coinbag(Player player) {
        if (findCoinBag(player) == null) {
            this.coinBag = null;
            return;
        }
        ItemStack coinBag = findCoinBag(player);
        this.coinBag = coinBag;
        this.bagOwner = player;
        coinBagSetup(coinBag);
        maxCoins = 10 * (10^tier);
    }

    private void coinBagSetup(ItemStack coinBag) {
        List<String> lore = coinBag.getItemMeta().getLore();
        assert lore != null;
        String line = lore.get(0);
        Bukkit.broadcastMessage(line.substring(line.indexOf('»') + 1, line.indexOf('«')));
        tier = Byte.parseByte(ChatColor.stripColor(line.substring(line.indexOf('»') + 1, line.indexOf('«'))));
        line = lore.get(1);
        tinCoins = Integer.parseInt(ChatColor.stripColor(line.substring(line.indexOf('»') + 1, line.indexOf('«'))));
        line = lore.get(2);
        copperCoins = Integer.parseInt(ChatColor.stripColor(line.substring(line.indexOf('»') + 1, line.indexOf('«'))));
        line = lore.get(3);
        silverCoins = Integer.parseInt(ChatColor.stripColor(line.substring(line.indexOf('»') + 1, line.indexOf('«'))));
        line = lore.get(4);
        goldCoins = Integer.parseInt(ChatColor.stripColor(line.substring(line.indexOf('»') + 1, line.indexOf('«'))));
    }

    public ItemStack findCoinBag(Player player) {
        for (ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack == null) {
                continue;
            }
            if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(CoinBagManager.coinBag.getItemMeta().getDisplayName())) {
                Bukkit.broadcastMessage("this coinbag was found");
                return itemStack;
            }
        }
        return null;
    }

    private int findCoinBagLocation() {
        ItemStack[] inv = bagOwner.getInventory().getContents();
        for (int i = 0; i < inv.length; i++) {
            if (inv[i] == null) {
                continue;
            }
            if (inv[i].getItemMeta().getDisplayName().equalsIgnoreCase(CoinBagManager.coinBag.getItemMeta().getDisplayName())) {
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
        if (this.tinCoins + copperCoins + silverCoins + goldCoins + tinCoins >= maxCoins) {
            this.tinCoins = maxCoins - (copperCoins + silverCoins + goldCoins);
            reload();
            return;
        }
        this.tinCoins = this.tinCoins + tinCoins;
        reload();
    }

    public void addCopperCoins(int copperCoins) {
        if (tinCoins + copperCoins + silverCoins + goldCoins + copperCoins >= maxCoins) {
            this.copperCoins = maxCoins - (tinCoins + silverCoins + goldCoins);
            reload();
            return;
        }
        this.copperCoins += copperCoins;
        reload();
    }

    public void addSilverCoins(int silverCoins) {
        if (tinCoins + copperCoins + this.silverCoins + goldCoins >= maxCoins) {
            this.silverCoins = maxCoins - (tinCoins + copperCoins + goldCoins);
            reload();
            return;
        }
        this.silverCoins += silverCoins;
        reload();
    }

    public void addGoldCoins(int goldCoins) {
        if (tinCoins + copperCoins + silverCoins + this.goldCoins >= maxCoins) {
            this.goldCoins = maxCoins - (tinCoins + copperCoins + silverCoins);
            reload();
            return;
        }
        this.goldCoins += goldCoins;
        reload();
    }
}

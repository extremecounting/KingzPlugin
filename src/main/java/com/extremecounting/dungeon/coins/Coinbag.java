package com.extremecounting.dungeon.coins;

import com.extremecounting.dungeon.itemManager.CoinBagManager;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

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

    //line.substring(line.indexOf('»') + 1, line.indexOf('«')


    public Coinbag(Player player) {
        ItemStack coinBag = findCoinBag(player);
        this.coinBag = coinBag;
        this.bagOwner = player;
        coinBagSetup(coinBag);
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
        Inventory inv = player.getInventory();
        for (ItemStack itemStack : inv) {
            if (itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(
                    CoinBagManager.coinBag.getItemMeta().getDisplayName())) {
                return itemStack;
            }
        }
        return null;
    }

    public void reload() {
        ItemStack coinBag = findCoinBag(bagOwner);
        coinBagSetup(coinBag);
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
        this.tinCoins += tinCoins;
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

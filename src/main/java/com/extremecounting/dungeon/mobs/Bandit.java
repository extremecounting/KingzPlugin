package com.extremecounting.dungeon.mobs;

import com.extremecounting.dungeon.coins.Coinbag;
import com.extremecounting.dungeon.itemManager.MaterialManager;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bandit implements RPGMob<Zombie> {

    public Zombie spawn(Location location, String tag, int variant) {
        Zombie zombie = location.getWorld().spawn(location, Zombie.class);
        return createMob(zombie, tag, variant);
    }

    public Zombie createMob(Zombie zombie, String tag, int variant) {
        zombie.setCanBreakDoors(false);
        zombie.setAdult();
        zombie.setCustomName("Bandit");
        zombie.addScoreboardTag(tag);
        zombie.getEquipment().setBoots(new ItemStack(Material.LEATHER_BOOTS));
        zombie.getEquipment().setBootsDropChance(0f);
        if (variant == 1) {
            zombie.setHealth(5.0);
            zombie.damage(1.0);
            PlayerDisguise playerDisguise = new PlayerDisguise("extremecounting");
            DisguiseAPI.disguiseEntity(zombie, playerDisguise);
            zombie.addScoreboardTag("bandit1");
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.STONE_SWORD));
            zombie.getEquipment().setItemInMainHandDropChance(0f);
        } else if (variant == 2) {
            zombie.setHealth(8.0);
            zombie.damage(1.5);
            PlayerDisguise playerDisguise = new PlayerDisguise("extremecounting");
            DisguiseAPI.disguiseEntity(zombie, playerDisguise);
            zombie.addScoreboardTag("bandit2");
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD));
            zombie.getEquipment().setItemInMainHandDropChance(0f);
            zombie.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
            zombie.getEquipment().setHelmetDropChance(0f);
        } else if (variant == 3) {
            zombie.setHealth(10.0);
            zombie.damage(2.0);
            PlayerDisguise playerDisguise = new PlayerDisguise("extremecounting");
            DisguiseAPI.disguiseEntity(zombie, playerDisguise);
            zombie.addScoreboardTag("bandit2");
            zombie.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_AXE));
            zombie.getEquipment().setItemInMainHandDropChance(0f);
            zombie.getEquipment().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
            zombie.getEquipment().setHelmetDropChance(0f);
            zombie.getEquipment().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            zombie.getEquipment().setChestplateDropChance(0f);
        }

        return zombie;
    }

    public List<ItemStack> dropTable(Player player, float percent) {
        List<ItemStack> items = new ArrayList<>();
        Random random = new Random();
        int chance = random.nextInt(0, 100);
        ItemStack itemStack = MaterialManager.clothFiber;
        percent += 1;
        if (chance * percent <= 30) {
            itemStack.setAmount(1);
        } else if (chance * percent <= 55) {
            itemStack.setAmount(2);
        } else if (chance * percent <= 90) {
            itemStack.setAmount(3);
        } else {
            itemStack.setAmount(4);
        }
        items.add(itemStack);

        chance = random.nextInt(0, 100);
        Coinbag coinbag = new Coinbag(player);
        if (chance * percent <= 10) {
            coinbag.addTinCoins(1);
        } else if (chance * percent <= 25) {
            coinbag.addTinCoins(2);
        } else if (chance * percent <= 40) {
            coinbag.addTinCoins(3);
        } else if (chance * percent <= 60) {
            coinbag.addTinCoins(4);
        } else if (chance * percent <= 80) {
            coinbag.addTinCoins(5);
        } else if (chance * percent <= 95) {
            coinbag.addTinCoins(6);
        } else {
            coinbag.addTinCoins(8);
        }
        return items;
    }

}








package com.extremecounting.dungeon.mobs;

import com.extremecounting.dungeon.itemManager.MaterialManager;
import me.libraryaddict.disguise.DisguiseAPI;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import org.bukkit.Location;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hog implements RPGMob<Pig> {

    public static Pig hog;

    @Override
    public Pig spawn(Location location, String tag, int variant) {
        Pig pig = location.getWorld().spawn(location, Pig.class);
        return createMob(pig, tag, variant);
    }

    @Override
    public Pig createMob(Pig mob, String tag, int variant) {
        mob.setHealth(5.0);
        mob.setAdult();
        mob.setCustomName("Wild Hog");
        mob.addScoreboardTag(tag);
        hog = mob;

        return mob;
    }

    public static List<ItemStack> dropTable(Player player, float percent) {
        List<ItemStack> items = new ArrayList<>();
        Random random = new Random();
        int chance = random.nextInt(0, 100);
        ItemStack itemStack = MaterialManager.rawPork;
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

        if (chance * percent <= 30) {
            itemStack.setAmount(1);
        } else if (chance * percent <= 55) {
            itemStack.setAmount(2);
        } else if (chance * percent <= 90) {
            itemStack.setAmount(3);
        } else {
            itemStack.setAmount(4);
        }

        return items;
    }
}

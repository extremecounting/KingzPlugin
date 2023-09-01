package com.extremecounting.dungeon.mobs;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface RPGMob<T extends LivingEntity> {
    

    T spawn(Location location, String tag, int variant);

    T createMob(T mob, String tag, int variant);

    static List<ItemStack> dropTable(Player player, float percent) {
        return null;
    }
}

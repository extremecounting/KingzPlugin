package com.extremecounting.dungeon.itemManager;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class QuestItemManager {

    public static ItemStack walkingStick;


    public static void init() {
        createWalkingStick();
    }

    private static void createWalkingStick() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§fOld Walking Stick");
        List<String> lore = new ArrayList<>();
        lore.add("§fBring to Tobias for a reward!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        walkingStick = item;
    }
}

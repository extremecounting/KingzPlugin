package com.extremecounting.dungeon.enchants;

import java.util.HashMap;
import java.util.List;

public class EnchantsList {

    public static HashMap<String, String> meleeEnchants = new HashMap<>();
    public static HashMap<String, String> pickEnchants = new HashMap<>();
    public static HashMap<String, String> armorEnchants = new HashMap<>();

    public static void init() {
        createEnchant(meleeEnchants, "§7Rapture ", "rapture");
        createEnchant(meleeEnchants, "§7Poison ", "poison");
        createEnchant(meleeEnchants, "§7Scavenger ", "scavenger");
        createEnchant(meleeEnchants, "§7Serrated ", "serrated");
        //createEnchant(meleeEnchants, "§7Reinforced ", "reinforced"); stupid enchant
        createEnchant(meleeEnchants, "§7Bloodlust ", "bloodlust");
        createEnchant(meleeEnchants, "§7First Strike ", "firststrike");
        createEnchant(meleeEnchants, "§7Rampage ", "rampage");

        //createEnchant(pickEnchants, "§7Reinforced ", "reinforced"); stupid enchant
        createEnchant(pickEnchants, "§7Molten Touch ", "moltentouch");

        //createEnchant(armorEnchants, "§7Reinforced ", "reinforced"); stupid enchant
    }

    private static void createEnchant(HashMap<String, String> map, String enchant, String name) {
        String input = enchant;
        map.put(name, input);
    }
}

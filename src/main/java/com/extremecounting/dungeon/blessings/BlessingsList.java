package com.extremecounting.dungeon.blessings;

import java.util.HashMap;

public class BlessingsList {

    public static HashMap<String, String> blessings = new HashMap<>();
    public static HashMap<String, String> meleeBlessings = new HashMap<>();
    public static HashMap<String, String> pickBlessings = new HashMap<>();
    public static HashMap<String, String> armorBlessings = new HashMap<>();


    public static void init() {
        createBlessing(blessings, "§bBandit's Blessing", "bandit");
        createBlessing(blessings, "§bPirate's Blessing", "pirate");


    }

    private static void createBlessing(HashMap<String, String> map, String blessing, String name) {
        String input = blessing;
        map.put(name, input);
    }
}

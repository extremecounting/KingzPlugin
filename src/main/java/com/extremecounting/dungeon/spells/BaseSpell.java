package com.extremecounting.dungeon.spells;

import org.bukkit.entity.Player;

public class BaseSpell {

    Player player;
    int intensity;

    public BaseSpell(Player player, int intensity) {
        this.player = player;
        this.intensity = intensity;
    }

    public BaseSpell(Player player) {
        this.player = player;
        this.intensity = 1;
    }
}

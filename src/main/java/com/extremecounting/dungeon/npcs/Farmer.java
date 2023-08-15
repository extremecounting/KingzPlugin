package com.extremecounting.dungeon.npcs;


import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class Farmer implements Listener {


    public static void spawnFarmer(Location location) {
        Villager villager = location.getWorld().spawn(location, Villager.class);
        NPCUtil.setupNPC(villager, "Farmer Joe");
        villager.addScoreboardTag("Farmer")
    }

    @EventHandler
    public void onClickFarmer(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getRightClicked().getType() == EntityType.VILLAGER) {
            if (event.getRightClicked().getScoreboardTags().contains("Farmer")) {

            }
        }
    }

}

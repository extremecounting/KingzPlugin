package com.extremecounting.dungeon.staff;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class KillMobs implements Listener {


    @EventHandler
    public void onDeath(EntityDamageEvent event) {
        if (event.getEntity().getType() == EntityType.CAMEL && event.getEntity().getCustomName().equalsIgnoreCase("Jester")) {
            event.setCancelled(true);
        }
    }




}

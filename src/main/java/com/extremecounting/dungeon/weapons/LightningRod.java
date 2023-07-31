package com.extremecounting.dungeon.weapons;

import com.extremecounting.dungeon.itemManager.WeaponManager;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class LightningRod implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getDamager();
        Player player;
        if (entity instanceof Player) {
            player = (Player) entity;
        } else {
            return;
        }
        if (player.getInventory().getItemInMainHand().getItemMeta().equals(WeaponManager.lightningRod.getItemMeta())) {
            event.getEntity().getWorld().strikeLightning(event.getEntity().getLocation());
        }
    }
}

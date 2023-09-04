package com.extremecounting.dungeon.enchants;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;

public class EnchantUtil implements Listener {

    public void onAnvil(InventoryInteractEvent event) {
        if (!(event.getInventory() instanceof AnvilInventory)) {
            return;
        }
        AnvilInventory anvilInventory = (AnvilInventory) event.getInventory();
    }

    public static Player setup(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) {
            return null;
        }
        Player player = (Player) event.getDamager();
        try {
            player.getInventory().getItemInMainHand();
        } catch (Exception ex) {
            return null;
        }
        return player;
    }

}

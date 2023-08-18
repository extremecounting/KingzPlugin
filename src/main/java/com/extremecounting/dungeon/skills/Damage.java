package com.extremecounting.dungeon.skills;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.player.PlayerConfig;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.io.File;
import java.io.IOException;

public class Damage implements Listener {

    @EventHandler
    public static void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player) && !(event.getEntity() instanceof Player)) {
            return;
        }
        double damage = event.getDamage();
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();

            File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);

            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            config.set("basic.damage", config.getDouble(("basic.damage")) + damage);
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();

            File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);

            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            config.set("basic.damaged", Double.valueOf((String) config.get("basic.damaged")) + damage);
            try {
                config.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @EventHandler
    public static void onCombust(EntityCombustEvent event) {
        event.setCancelled(true);
    }
}

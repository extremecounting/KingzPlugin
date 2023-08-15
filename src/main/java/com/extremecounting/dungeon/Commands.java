package com.extremecounting.dungeon;

import com.extremecounting.dungeon.itemManager.MaterialManager;
import com.extremecounting.dungeon.itemManager.WeaponManager;
import com.extremecounting.dungeon.mobs.BanditSpawner;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("day")) {
            player.getWorld().setTime(1000L);
        }
        else if (cmd.getName().equalsIgnoreCase("lightningrod")) {
            player.getInventory().addItem(WeaponManager.lightningRod);
        }
        else if (cmd.getName().equalsIgnoreCase("bandit")) {

        }
        else if (cmd.getName().equalsIgnoreCase("spear")) {
            player.getInventory().addItem(WeaponManager.pSpear);
        } else if (cmd.getName().equalsIgnoreCase("givestuff")) {
            player.getInventory().addItem(MaterialManager.flint);
            player.getInventory().addItem(MaterialManager.vine);
            player.getInventory().addItem(MaterialManager.driftWood);
        } else if (cmd.getName().equalsIgnoreCase("test1")) {
            player.getLocation().getBlock().setType(Material.CHEST);
            Chest chest = (Chest) player.getLocation().getBlock().getState();
            chest.getInventory().addItem(new ItemStack(Material.STONE));
        }


        return true;
    }
}

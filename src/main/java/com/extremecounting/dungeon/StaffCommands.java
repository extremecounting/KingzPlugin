package com.extremecounting.dungeon;

import com.extremecounting.dungeon.mobs.BanditSpawner;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        if (!sender.isOp()) {
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("suicide")) {
            player.setHealth(0);
            Bukkit.broadcastMessage("§2" + player.getName() + " has taken their own life!");
        }
        if (cmd.getName().equalsIgnoreCase("stop")) {
            Bukkit.getServer().shutdown();
        }


        return true;
    }
}

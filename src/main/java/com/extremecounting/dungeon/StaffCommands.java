package com.extremecounting.dungeon;

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
        if (cmd.getName().equalsIgnoreCase("createSpawner")) {
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("bandit")) {
                    if (args.length > 5) {
                        BanditSpawners.createSpawner(player, Double.parseDouble(args[2]),
                                Double.parseDouble(args[3]), Double.parseDouble(args[4]), args[1]);

                    }
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("stop")) {
            Bukkit.getServer().shutdown();
        }


        return true;
    }
}

package com.extremecounting.dungeon.mobs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.jetbrains.annotations.NotNull;

public class SpawnerCommands implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        if (!sender.isOp()) {
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("spawnertest")) {
            SpawnerUtil.createSpawnerConfigFolder("banditspawner");
            SpawnerUtil.createSpawnerConfigFile("banditspawner", "banditspawner1");
            SpawnerUtil.saveToConfigSpawner("banditspawner", "banditspawner1",
                    "age1", new BanditSpawner("test1", player.getLocation(), 8, 2, 1, 1));
        }
        if (cmd.getName().equalsIgnoreCase("test123")) {
            player.sendMessage("heyy bro");
        }
        return false;
    }
}

package com.extremecounting.dungeon.mobs;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

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
            BanditSpawner.createBanditSpawner("banditspawner1", player.getLocation(),
                    3, 1, 1, 2, 2, 1);
            player.sendMessage("§2Test spawner created!");
        }
        if (cmd.getName().equalsIgnoreCase("spawner")) {
            if (args[0].equalsIgnoreCase("disable")) {
                SpawnerUtil.spawnerOn = false;
                player.sendMessage("§cSpawners Disabled!");
            } else if (args[0].equalsIgnoreCase("enable")) {
                SpawnerUtil.spawnerOn = true;
                player.sendMessage("§2Spawners Enabled!");
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (args.length < 2) {
                    SpawnerUtil.reloadSpawners("banditspawner", "bandit");
                    player.sendMessage("§2Reloading all spawners...");
                    return true;
                }

                if (args[1].equalsIgnoreCase("bandit")) {
                    SpawnerUtil.reloadSpawners("banditspawner", "bandit");
                    player.sendMessage("§2Reloading bandit spawners...");
                }
            }
            if (args.length > 1) {
                if (args[0].equalsIgnoreCase("bandit")) {
                    FileConfiguration config = SpawnerUtil.getSpawnerConfigFile("banditspawner", args[1]);
                    player.sendMessage("§6Name: §2" + config.get("name"));
                    Location location = (Location) config.get("location");
                    player.sendMessage("§6Cords: §2" + Math.round(location.getX()) +
                            ", " + Math.round(location.getY()) + ", " + Math.round(location.getZ()));
                    player.sendMessage("§6Max mobs: §2" + config.get("maxmobs"));
                    player.sendMessage("§6Spawn rate: §2" + config.get("spawnrate"));
                    player.sendMessage("§6Mobs per spawn: §2" + config.get("mobsperspawn"));
                    player.sendMessage("§6Size : §2" + config.get("sizeX") + "x" + config.get("sizeZ"));
                }
            }
        }
        if (cmd.getName().equalsIgnoreCase("createspawner")) {
            if (args.length > 1) {
                if (args[0].equalsIgnoreCase("bandit")) {
                    switch (args.length) {
                        case 2:
                            BanditSpawner.createBanditSpawner(args[1], player.getLocation(),
                                    1, 1, 1, 1, 1, 1);
                            player.sendMessage("§2You have created a bandit spawner named " + args[1]);
                            return true;
                        case 3:
                            BanditSpawner.createBanditSpawner(args[1], player.getLocation(),
                                    1, 1, 1, 1, 1, Integer.parseInt(args[2]));
                            player.sendMessage("§2You have created a bandit spawner named " + args[1]);
                            return true;
                        case 4:
                            BanditSpawner.createBanditSpawner(args[1], player.getLocation(),
                                    Integer.parseInt(args[3]), 1,
                                    1, 1, 1, Integer.parseInt(args[2]));
                            player.sendMessage("§2You have created a bandit spawner named " + args[1]);
                            return true;
                        case 5:
                            BanditSpawner.createBanditSpawner(args[1], player.getLocation(),
                                    Integer.parseInt(args[3]), Integer.parseInt(args[4]),
                                    1, 1, 1, Integer.parseInt(args[2]));
                            player.sendMessage("§2You have created a bandit spawner named " + args[1]);
                            return true;
                        case 6:
                            BanditSpawner.createBanditSpawner(args[1], player.getLocation(),
                                    Integer.parseInt(args[3]), Integer.parseInt(args[4]),
                                    Integer.parseInt(args[5]), 1, 1, Integer.parseInt(args[2]));
                            player.sendMessage("§2You have created a bandit spawner named " + args[1]);
                            return true;
                        case 7:
                            BanditSpawner.createBanditSpawner(args[1], player.getLocation(),
                                    Integer.parseInt(args[3]), Integer.parseInt(args[4]),
                                    Integer.parseInt(args[5]), Integer.parseInt(args[6]),
                                    1, Integer.parseInt(args[2]));
                            player.sendMessage("§2You have created a bandit spawner named " + args[1]);
                            return true;
                        case 8:
                            BanditSpawner.createBanditSpawner(args[1], player.getLocation(),
                                    Integer.parseInt(args[3]), Integer.parseInt(args[4]),
                                    Integer.parseInt(args[5]), Integer.parseInt(args[6]),
                                    Integer.parseInt(args[7]), Integer.parseInt(args[2]));
                            player.sendMessage("§2You have created a bandit spawner named " + args[1]);
                            return true;
                    }
                }
            }
        }
        return true;
    }
}

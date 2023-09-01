package com.extremecounting.dungeon.island;

import com.extremecounting.dungeon.Dungeon;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IslandCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("island")) {
            if (args.length < 1) {
                return false;
            }
            if (args[0].equalsIgnoreCase("help")) {
                player.sendMessage("/island help §7- displays this message");
                player.sendMessage("/island create §7- creates a new island, only works once");
                player.sendMessage("/island tp [username] §7- teleports you to a player's island if it's public");
                player.sendMessage("/island public §7-makes your island public");
                player.sendMessage("/island private §7makes your island private");
            } else if (args[0].equalsIgnoreCase("create")) {
                try {
                    IslandCreation.islandCreation(player);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (args[0].equalsIgnoreCase("tp") || args[0].equalsIgnoreCase("teleport")) {
                if (args.length > 1) {
                    Player player1 = Bukkit.getPlayer(args[1]);
                    teleportPlayer(player, player1);
                }
                else {
                    player.sendMessage("§cPlease enter a player name!");
                }
            } else if (args[0].equalsIgnoreCase("public")) {
                islandPublic(player);
            } else if (args[0].equalsIgnoreCase("private")) {
                islandPrivate(player);
            }
        }

        return true;
    }


    private static void teleportPlayer(Player teleportee, Player islandDestination) {
        FileConfiguration destinationConfig = IslandUtility.getIslandConfig(Dungeon.islandFolder, islandDestination);
        FileConfiguration teleporteeConfig = IslandUtility.getIslandConfig(Dungeon.usersFolder, teleportee);
        if (((boolean) teleporteeConfig.get("jailed"))) {
            return;
        }
        List<Integer> cords = (List<Integer>) destinationConfig.get("island.location");
        Location location = new Location(teleportee.getWorld(), cords.get(0), cords.get(1), cords.get(2));
        teleportee.teleport(location);
        teleporteeConfig.set("island.playerLocation", islandDestination.getName());
        try {
            teleporteeConfig.save(IslandUtility.getIslandFile(Dungeon.usersFolder, teleportee.getPlayer()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void islandPublic(Player player) {
        File islandFile = IslandUtility.getIslandFile(Dungeon.islandFolder, player);
        FileConfiguration islandConfig = IslandUtility.getIslandConfig(Dungeon.islandFolder, player);
        if ((boolean)islandConfig.get("island.public")) {
            player.sendMessage("§cIsland already public!");
            return;
        }
        islandConfig.set("island.public", true);
        try {
            islandConfig.save(islandFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void islandPrivate(Player player) {
        File islandFile = IslandUtility.getIslandFile(Dungeon.islandFolder, player);
        FileConfiguration islandConfig = IslandUtility.getIslandConfig(Dungeon.islandFolder, player);
        if (!(boolean)islandConfig.get("island.public")) {
            player.sendMessage("§cIsland already private!");
            return;
        }
        islandConfig.set("island.public", false);
        try {
            islandConfig.save(islandFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

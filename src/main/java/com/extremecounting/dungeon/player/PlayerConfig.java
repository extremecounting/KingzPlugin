package com.extremecounting.dungeon.player;

import com.extremecounting.dungeon.Dungeon;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayerConfig {


    public static void playerConfigCreate(File playerFolder, UUID uuid) throws IOException {

        File[] playerFiles = playerFolder.listFiles();
        File playerFile;
        if (playerFiles == null) {
            return;
        }
        List<UUID> playerFileNames = new ArrayList<>();
        for (File file : playerFiles) {
            playerFileNames.add(UUID.fromString(file.getName()));
        }
        if (!playerFileNames.contains(uuid)) {
            playerFile = new File(playerFolder, uuid + ".yml");
            playerFile.createNewFile();
            FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
            playerData.set("basic.kills", 0);
            playerData.set("basic.joins", 0);
            playerData.set("basic.rank", 0);

            playerData.set("island.created", false);
            playerData.set("island.playerLocation", "0");

            playerData.set("jailed", false);

            playerData.save(playerFile);
        }
    }

    public static void islandCreationPlayerConfig(File playerFolder, Player player) {
        File playerFile = getPlayerFile(playerFolder, player);
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
        playerData.set("island.create", true);
        playerData.set("island.playerLocation", player.getName());
    }

    public static File getPlayerFile(File playerFolder, Player player) {
        File[] playerFiles = playerFolder.listFiles();
        if (playerFiles == null) {
            return null;
        }
        List<UUID> playerFileNames = new ArrayList<>();
        for (File file : playerFiles) {
            playerFileNames.add(UUID.fromString(file.getName()));
        }
        if (!playerFileNames.contains(player.getUniqueId())) {
            return null;
        }
        return new File(playerFolder, player.getUniqueId() + ".yml");
    }

    public static YamlConfiguration getPlayerYAML(Player player) {
        File playerFile = new File(Dungeon.usersFolder, player.getUniqueId() + ".yml");
        return YamlConfiguration.loadConfiguration(playerFile);
    }

}

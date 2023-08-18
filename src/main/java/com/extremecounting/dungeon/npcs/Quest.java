package com.extremecounting.dungeon.npcs;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.player.PlayerConfig;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.index.qual.PolyUpperBound;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Quest {

    //Name of quest
    public String name;
    //Each quest message
    public List<String> quest;
    //response
    public String response;
    //reward
    public Set<ItemStack> reward = new HashSet<>();
    //message when a player returns without the needed item/s
    public String awaitMsg;
    //item/s needed
    public Set<ItemStack> requiredItems = new HashSet<>();

    public Quest(String name, List<String> quest, String response) {
        this.name = name;
        this.quest = quest;
        this.response = response;
    }

    public Quest(String name, List<String> quest, String response, Set<ItemStack> reward) {
        this.name = name;
        this.quest = quest;
        this.response = response;
        this.reward = reward;
    }


    public Quest(String name, List<String> quest, String response, Set<ItemStack> reward, String awaitMsg, Set<ItemStack> requiredItems) {
        this.name = name;
        this.quest = quest;
        this.response = response;
        this.reward = reward;
        this.awaitMsg = awaitMsg;
        this.requiredItems = requiredItems;
    }

    public String getName() {
        return name;
    }
    public List<String> getQuest() {
        return quest;
    }

    public String getResponse() {
        return response;
    }

    public Set<ItemStack> getReward() {
        return reward;
    }

    public String getAwaitMsg() {
        return awaitMsg;
    }

    public Set<ItemStack> getRequiredItems() {
        return requiredItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuest(List<String> quest) {
        this.quest = quest;
    }

    public void addQuest(String quest) {
        this.quest.add(quest);
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setReward(Set<ItemStack> reward) {
        this.reward = reward;
    }

    public void addReward(ItemStack item) {
        this.reward.add(item);
    }

    public void setAwaitMsg(String awaitMsg) {
        this.awaitMsg = awaitMsg;
    }

    public void setRequiredItems(Set<ItemStack> requiredItems) {
        this.requiredItems = requiredItems;
    }

    public void addRequiredItem(ItemStack item) {
        this.requiredItems.add(item);
    }

    public void itemTransaction(Player player) {
        if (hasRequiredItems(player)) {
            for (ItemStack item : requiredItems) {
                player.getInventory().removeItem(item);
            }
            for (ItemStack item : reward) {
                player.getInventory().addItem(item);
            }
            player.sendMessage(response);
        }
    }

    public boolean hasRequiredItems(Player player) {
        boolean skip = true;
        for (ItemStack item : requiredItems) {
            skip = false;
            if (!player.getInventory().containsAtLeast(item, 1)) {
                return false;
            }
        }
        return !skip;
    }

    public void startQuest(Player player) {
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration configFile = YamlConfiguration.loadConfiguration(file);
        configFile.set(name, true);
        try {
            configFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : quest) {
            player.sendMessage(line);
        }
    }

    public boolean hasStartedQuest(Player player) {
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration configFile = YamlConfiguration.loadConfiguration(file);
        if (configFile.get(name) == null) {
            return false;
        }
        return true;
    }

    public void endQuest(Player player) {
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration configFile = YamlConfiguration.loadConfiguration(file);
        configFile.set(name, null);
        try {
            configFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

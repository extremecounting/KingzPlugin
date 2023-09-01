package com.extremecounting.dungeon.npcs;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.mobs.RPGMob;
import com.extremecounting.dungeon.player.PlayerConfig;
import com.extremecounting.dungeon.player.ScoreboardUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
    //config for special item picked up from mob
    public List<String> questItem = new ArrayList<>();
    //thing in scoreboard
    public String abbrievation;
    //config for mobs that need to be killed
    public String mob;
    public int mobAmount;

    public Quest(String name, List<String> quest, String response, String abbrievation) {
        this.name = name;
        this.quest = quest;
        this.response = response;
        this.abbrievation = abbrievation;
    }

    public Quest(String name, List<String> quest, String response, Set<ItemStack> reward, String abbrievation) {
        this.name = name;
        this.quest = quest;
        this.response = response;
        this.reward = reward;
        this.abbrievation = abbrievation;
    }


    public Quest(String name, List<String> quest, String response, Set<ItemStack> reward, String awaitMsg, Set<ItemStack> requiredItems, String abbrievation) {
        this.name = name;
        this.quest = quest;
        this.response = response;
        this.reward = reward;
        this.awaitMsg = awaitMsg;
        this.requiredItems = requiredItems;
        this.abbrievation = abbrievation;
    }

    public Quest(String name, List<String> quest, String response, Set<ItemStack> reward, String awaitMsg, String mob, int mobAmount, String abbrievation) {
        this.name = name;
        this.quest = quest;
        this.response = response;
        this.reward = reward;
        this.awaitMsg = awaitMsg;
        this.mob = mob;
        this.mobAmount = mobAmount;
        this.abbrievation = abbrievation;
    }

    public Quest() {

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

    public String getMob() {
        return mob;
    }

    public int getMobAmount() {
        return  mobAmount;
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

    public void setMob(String mob) {
        this.mob = mob;
    }

    public void setMobAmount(int mobAmount) {
        this.mobAmount = mobAmount;
    }

    public void addRequiredItem(ItemStack item) {
        this.requiredItems.add(item);
    }

    public void addQuestItem(String questItem) {
        this.questItem.add(questItem);
    }

    public void transaction(Player player) {
        if (requiredItems != null) {
            for (ItemStack item : requiredItems) {
                player.getInventory().removeItem(item);
            }
        }
        for (ItemStack item : reward) {
            player.getInventory().addItem(item);
        }
        player.sendMessage(response);
    }

    public boolean hasRequirements(Player player) {
        boolean output = hasRequiredItems(player);
        if (mob != null) {
            if (getPlayerConfig(player).getInt("questmob." + mob) > 0) {
                int amount = getPlayerConfig(player).getInt("questmob." + mob);
                player.sendMessage(Integer.toString(amount));
                return false;
            }
            return true;
        }
        return output;
    }

    private boolean hasRequiredItems(Player player) {
        if (requiredItems == null) {
            return true;
        }
        boolean skip = true;
        for (ItemStack item : requiredItems) {
            skip = false;
            if (!player.getInventory().containsAtLeast(item, item.getAmount())) {
                return false;
            }
        }
        return !skip;
    }


    public void startQuest(Player player) {
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration configFile = getPlayerConfig(player);
        configFile.set(name, true);
        for (String line : quest) {
            player.sendMessage(line);
        }
        if (questItem != null) {
            for (String item : questItem) {
                configFile.set(name + "." + item, true);
            }
        }
        if (mob != null) {
            configFile.set("questmob." + mob, mobAmount);
        }

        try {
            configFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ScoreboardUtil.questScoreboard(player, abbrievation, mobAmount);
    }

    public boolean hasStartedQuest(Player player) {
        YamlConfiguration configFile = getPlayerConfig(player);
        if (configFile.get(name) == null) {
            return false;
        }
        return true;
    }

    public void endQuest(Player player) {
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration configFile = getPlayerConfig(player);
        configFile.set(name, null);
        try {
            configFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ScoreboardUtil.removeQuestScoreboard(player, abbrievation);
    }

    private YamlConfiguration getPlayerConfig(Player player) {
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        return YamlConfiguration.loadConfiguration(file);
    }

}

package com.extremecounting.dungeon.npcs;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.player.PlayerConfig;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class QuestLine {

    //NPC introduction
    public List<String> introduction;
    //Name of entire quest line (usually name of NPC)
    public String name;
    //List of all quests
    public List<Quest> quests;

    //Creates questline without the quests

    public QuestLine(String name, List<String> introduction) {
        this.name = name;
        this.introduction = introduction;
    }

    //Creates questline with the quests
    public QuestLine(String name, List<String> introduction, List<Quest> quests) {
        this.name = name;
        this.introduction = introduction;
        this.quests = quests;
    }

    public String getName() {
        return name;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public List<String> getIntroduction() {
        return introduction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public void setIntroduction(List<String> introduction) {
        this.introduction = introduction;
    }

    public void addIntroduction(String introPart) {
        this.introduction.add(introPart);
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public Quest getQuest(int i) {
        return quests.get(i);
    }

    public Quest getPlayerQuest(Player player) {
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration configFile = YamlConfiguration.loadConfiguration(file);
        if (configFile.get(name) == null) {
            return getQuest(0);
        }
        return getQuest(configFile.getInt(name));
    }

    public void incrPlayerQuest(Player player) {
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration configFile = YamlConfiguration.loadConfiguration(file);
        configFile.set(name, configFile.getInt(name) + 1);
        try {
            configFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setupPlayerQuest(Player player) {
        File file = PlayerConfig.getPlayerFile(Dungeon.usersFolder, player);
        YamlConfiguration configFile = YamlConfiguration.loadConfiguration(file);
        configFile.set(name, 0);
        try {
            configFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}

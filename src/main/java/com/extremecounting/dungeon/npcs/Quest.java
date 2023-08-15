package com.extremecounting.dungeon.npcs;

import org.bukkit.inventory.ItemStack;

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
    public Set<ItemStack> reward;


    public Quest(String name, List<String> quest, String response, Set<ItemStack> reward) {
        this.name = name;
        this.quest = quest;
        this.response = response;
        this.reward = reward;
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


}

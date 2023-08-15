package com.extremecounting.dungeon.npcs;

import java.util.List;

public class QuestLine {

    //Name of entire quest line (usually name of NPC)
    public String name;
    //List of all quests
    public List<Quest> quests;
    //Creates questline without the quests

    public QuestLine(String name) {
        this.name = name;
    }

    //Creates questline with the quests
    public QuestLine(String name, List<Quest> quests) {
        this.name = name;
        this.quests = quests;
    }

    public String getName() {
        return name;
    }

    public List<Quest> getQuests() {
        return quests;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }

    public void addQuest(Quest quest) {
        this.quests.add(quest);
    }

    public Quest getQuest(int i) {
        return quests.get(i);
    }





}

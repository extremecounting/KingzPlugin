package com.extremecounting.dungeon.npcs;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mayor implements Listener {

    public static void spawnMayor(Location location) {
        Villager villager = location.getWorld().spawn(location, Villager.class);
        NPCUtil.setupNPC(villager, "Mayor");
        villager.addScoreboardTag("MayorNPC");
    }


    @EventHandler
    public void onClickMayor(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!(event.getRightClicked().getType() == EntityType.VILLAGER)) {
            return;
        }
        if (!event.getRightClicked().getScoreboardTags().contains("MayorNPC")) {
            return;
        }

        List<String> questLineIntro = new ArrayList<>();
        questLineIntro.add("§6Greetings, my dear citizen!");
        questLineIntro.add("§6Our town is facing many challenges, and we need your assistance.");
        QuestLine questLine = new QuestLine("Mayor's Questline", questLineIntro);

        // Quest 1: Gather Porkchops
        List<String> quest1Intro = new ArrayList<>();
        quest1Intro.add("§6Welcome! We're in dire need of provisions.");
        quest1Intro.add("§6Can you help us by gathering §e60 Raw Porkchops§6?");
        Set<ItemStack> quest1Reward = new HashSet<>();
        quest1Reward.add(new ItemStack(Material.STONE, 5)); // Reward: 5 Stone
        Set<ItemStack> quest1RequiredItems = new HashSet<>();
        quest1RequiredItems.add(new ItemStack(Material.PORKCHOP, 60));
        questLine.addQuest(new Quest("gather_porkchops", quest1Intro,
                "§6Thank you for providing us with the porkchops. Here's your reward.", quest1Reward,
                "§6We still need more porkchops. Can you help us gather §e60 Raw Porkchops?", quest1RequiredItems, "Get 60 Porkchops"));
        questLine.getQuest(0).setMobAmount(0);
        // Quest 2: Defeat Bandits
        List<String> quest2Intro = new ArrayList<>();
        quest2Intro.add("§6Our town is threatened by a bandit group.");
        quest2Intro.add("§6Can you eliminate §e35 Bandits§6 to ensure our safety?");
        Set<ItemStack> quest2Reward = new HashSet<>();
        quest2Reward.add(new ItemStack(Material.COPPER_INGOT, 2)); // Reward: 2 Copper Ingots
        Set<ItemStack> quest2RequiredItems = new HashSet<>();
        quest2RequiredItems.add(new ItemStack(Material.COAL_ORE, 3)); // Assuming you have a sword defined in WeaponManager class
        questLine.addQuest(new Quest("defeat_bandits", quest2Intro,
                "§6You've done an excellent job. Here's your reward.", quest2Reward,
                "§6Please eliminate §e35 Bandits§6 to secure our town.", quest2RequiredItems, "Kill bandits:"));
        questLine.getQuest(1).setMob("bandit");
        questLine.getQuest(1).setMobAmount(35);

        // Quest 3: Find John
        List<String> quest3Intro = new ArrayList<>();
        quest3Intro.add("§6There's a fellow named John who possesses vital information.");
        quest3Intro.add("§6Your task is to locate him and retrieve the information.");
        Set<ItemStack> quest3Reward = new HashSet<>();
        // No immediate reward for this quest
        Set<ItemStack> quest3RequiredItems = new HashSet<>();
        questLine.addQuest(new Quest("find_john", quest3Intro,
                "§6You've found John and obtained the information. Well done!", quest3Reward,
                "§6Search for a person named John and gather information.", quest3RequiredItems, "Find John"));

        // Check quest progression and completion
        Quest quest = questLine.getPlayerQuest(player);
        if (!questLine.hasStartedQuestline(player)) {
            questLine.startQuestline(player);
        }

        if (!quest.hasStartedQuest(player)) {
            quest.startQuest(player);
            return;
        }

        if (!quest.hasRequirements(player)) {
            player.sendMessage(quest.getAwaitMsg());
            return;
        }
        quest.transaction(player);
        quest.endQuest(player);
        questLine.incrPlayerQuest(player);
    }
}

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

public class TobiasF implements Listener {

    public static void spawnFarmer(Location location) {
        Villager villager = location.getWorld().spawn(location, Villager.class);
        NPCUtil.setupNPC(villager, "Tobias");
        villager.addScoreboardTag("TobiasF");
    }

    @EventHandler
    public void onClickFarmer(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (!(event.getRightClicked().getType() == EntityType.VILLAGER)) {
            return;
        }
        if (!event.getRightClicked().getScoreboardTags().contains("TobiasF")) {
            return;
        }
        /*
        if (player.isSneaking()) {
            FarmerGUI farmerGUI = new FarmerGUI();
            player.openInventory(farmerGUI.inv);
            return;
        }

         */
        List<String> questLineIntro = new ArrayList<>();
        questLineIntro.add("§2Hello there player, I need your help!");
        questLineIntro.add("§2I am too old to work on the farms like I used to.");
        QuestLine questLine = new QuestLine("farmer", questLineIntro);
        List<String> request = new ArrayList<>();
        request.add("§2I need leather to repair my boots. They are worn from use.");
        request.add("§2Bring me §6§n50 Leather§2 so I can repair them");
        Set<ItemStack> items = new HashSet<>();
        items.add(new ItemStack(Material.DIRT, 5));
        Set<ItemStack> requiredItems = new HashSet<>();
        requiredItems.add(new ItemStack(Material.LEATHER, 50));
        questLine.addQuest(new Quest("getleather", request,
                "§2Thank you so much, here is 5 dirt!", items, "§2I need §6§n50 Leather", requiredItems));

        request = new ArrayList<>();
        items = new HashSet<>();
        requiredItems = new HashSet<>();
        request.add("§2My food stockpile was raided by bandits, and I lost all my food.");
        request.add("§2Bring me §6§n150 Raw Pork§2 so my family can survive the winter.");
        items.add(new ItemStack(Material.COAL_ORE, 2));
        requiredItems.add(new ItemStack(Material.PORKCHOP, 150));
        questLine.addQuest(new Quest("getpork", request,
                "§2Now we can survive the winter! Here is this coal.", items,
                "Please get me §6§n150 Raw Pork.", requiredItems));

        request = new ArrayList<>();
        items = new HashSet<>();
        request.add("§2The bandits stole my watch!");
        request.add("§2Can you steal the §6§nTin Watch§2 back for me?");
        items.add(new ItemStack(Material.STICK, 1));
        requiredItems.add(new ItemStack(Material.STONE, 1));
        questLine.addQuest(new Quest("getwatch", request, "§2Thank you for the watch, here is a stick!", items,
                "§2I need my §6§nTin Watch!", requiredItems));

        Quest quest = questLine.getPlayerQuest(player);
        if (questLine.getQuests().indexOf(quest) == 0) {
            questLine.startQuestline(player);
        }

        if (!quest.hasStartedQuest(player)) {
            quest.startQuest(player);
            return;
        }
        if (!quest.hasRequiredItems(player)) {
            player.sendMessage(quest.awaitMsg);
            return;
        }
        quest.itemTransaction(player);
        quest.endQuest(player);
        questLine.incrPlayerQuest(player);
    }

}

package com.extremecounting.dungeon;

import com.extremecounting.dungeon.crafting.upgrades.SharpenerRecipes;
import com.extremecounting.dungeon.crafting.weapons.SpearRecipes;
import com.extremecounting.dungeon.enchants.*;
import com.extremecounting.dungeon.events.BlockBreakDing;
import com.extremecounting.dungeon.events.FarmlandDestroy;
import com.extremecounting.dungeon.events.InteractEvent;
import com.extremecounting.dungeon.events.PlayerJoin;
import com.extremecounting.dungeon.island.IslandCommands;
import com.extremecounting.dungeon.island.IslandUtility;
import com.extremecounting.dungeon.itemManager.*;
import com.extremecounting.dungeon.mobs.*;
import com.extremecounting.dungeon.npcs.Banker;
import com.extremecounting.dungeon.npcs.Mayor;
import com.extremecounting.dungeon.npcs.TobiasF;
import com.extremecounting.dungeon.player.DropItem;
import com.extremecounting.dungeon.rpg.Kills;
import com.extremecounting.dungeon.skills.Damage;
import com.extremecounting.dungeon.spells.QuantumShift;
import com.extremecounting.dungeon.spells.Vampire;
import com.extremecounting.dungeon.staff.Camel;
import com.extremecounting.dungeon.staff.KillMobs;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Dungeon extends JavaPlugin {

    public static File usersFolder;
    public static File islandFolder;
    public static File spawnerFolder;
    public static NamespacedKey mainNameSpacedKey;

    public NamespacedKey createKey(String name) {
        return new NamespacedKey(this, name);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
        }
        this.saveDefaultConfig();

        usersFolder = new File(this.getDataFolder(), "players");
        usersFolder.mkdirs();
        islandFolder = new File(this.getDataFolder(), "island");
        islandFolder.mkdirs();
        spawnerFolder = new File(this.getDataFolder(), "spawners");
        spawnerFolder.mkdirs();

        try {
            IslandUtility.createConfigMain();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Commands.plugin = this;
        SpawnerUtil.pluginInstance = this;
        Serrated.pluginInstance = this;
        SpawnerUtil.pluginInstance = this;
        Vampire.pluginInstance = this;
        QuantumShift.pluginInstance = this;

        SpawnerUtil.getBanditSpawners("banditspawner");
        SpawnerUtil.spawnerOn = true;

        Bukkit.getPluginManager().registerEvents(new BlockBreakDing(), this);
        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new Kills(), this);
        Bukkit.getPluginManager().registerEvents(new Death(), this);
        Bukkit.getPluginManager().registerEvents(new KillMobs(), this);
        Bukkit.getPluginManager().registerEvents(new Damage(), this);
        Bukkit.getPluginManager().registerEvents(new DropItem(), this);
        Bukkit.getPluginManager().registerEvents(new FarmlandDestroy(), this);
        Bukkit.getPluginManager().registerEvents(new Banker(), this);
        Bukkit.getPluginManager().registerEvents(new Rapture(), this);
        Bukkit.getPluginManager().registerEvents(new Poison(), this);
        Bukkit.getPluginManager().registerEvents(new Scavenger(), this);
        Bukkit.getPluginManager().registerEvents(new TobiasF(), this);
        Bukkit.getPluginManager().registerEvents(new Mayor(), this);
        Bukkit.getPluginManager().registerEvents(new EnchantUtil(), this);

        mainNameSpacedKey = new NamespacedKey(this, "Dungeon");

        Commands commands = new Commands();
        getCommand("day").setExecutor(commands);
        getCommand("lightningrod").setExecutor(commands);
        getCommand("bandit").setExecutor(commands);
        getCommand("spear").setExecutor(commands);
        getCommand("givestuff").setExecutor(commands);
        getCommand("test1").setExecutor(commands);

        getCommand("tpa").setExecutor(commands);
        getCommand("tpaccept").setExecutor(commands);
        getCommand("tpdeny").setExecutor(commands);

        IslandCommands islandCommands = new IslandCommands();
        getCommand("island").setExecutor(islandCommands);

        StaffCommands staffCommands = new StaffCommands();
        getCommand("suicide").setExecutor(staffCommands);
        getCommand("spawncamel123").setExecutor(staffCommands);
        getCommand("cleane").setExecutor(staffCommands);
        getCommand("createtin").setExecutor(staffCommands);
        getCommand("spawnerstart").setExecutor(staffCommands);
        getCommand("spawnfarmer").setExecutor(staffCommands);
        getCommand("spawnmayor").setExecutor(staffCommands);
        getCommand("givecoinbag").setExecutor(staffCommands);
        getCommand("giverapture").setExecutor(staffCommands);
        getCommand("givepoison").setExecutor(staffCommands);
        getCommand("givescavenger").setExecutor(staffCommands);

        SpawnerCommands spawnerCommands = new SpawnerCommands();
        getCommand("spawnertest").setExecutor(spawnerCommands);
        getCommand("spawner").setExecutor(spawnerCommands);
        getCommand("createspawner").setExecutor(spawnerCommands);

        WeaponManager.init();
        MaterialManager.init();
        ToolManager.init();
        UpgradeManager.init();
        OreItemManager.init();
        CoinBagManager.init();
        QuestItemManager.init();
        BookManager.init();

        SharpenerRecipes.init();
        SpearRecipes.init();

        Bukkit.addRecipe(SharpenerRecipes.pSharpener);
        Bukkit.addRecipe(SpearRecipes.pSpear);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Camel.cleanEntities();

    }
}

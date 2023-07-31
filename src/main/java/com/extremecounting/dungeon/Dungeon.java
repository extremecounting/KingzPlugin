package com.extremecounting.dungeon;

import com.extremecounting.dungeon.crafting.upgrades.SharpenerRecipes;
import com.extremecounting.dungeon.crafting.weapons.SpearRecipes;
import com.extremecounting.dungeon.events.BlockBreakDing;
import com.extremecounting.dungeon.events.InteractEvent;
import com.extremecounting.dungeon.events.PlayerJoin;
import com.extremecounting.dungeon.island.IslandCommands;
import com.extremecounting.dungeon.island.IslandUtility;
import com.extremecounting.dungeon.itemManager.MaterialManager;
import com.extremecounting.dungeon.itemManager.ToolManager;
import com.extremecounting.dungeon.itemManager.UpgradeManager;
import com.extremecounting.dungeon.itemManager.WeaponManager;
import com.extremecounting.dungeon.mobs.BanditSpawner;
import com.extremecounting.dungeon.mobs.SpawnerCommands;
import com.extremecounting.dungeon.mobs.SpawnerUtil;
import com.extremecounting.dungeon.rpg.Kills;
import com.extremecounting.dungeon.weapons.LightningRod;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class Dungeon extends JavaPlugin {


    public static File usersFolder;
    public static File islandFolder;
    public static File spawnerFolder;

    public static NamespacedKey mainNameSpacedKey;

    public static List<BanditSpawner> spawners;

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

        SpawnerUtil.pluginInstance = this;

        Bukkit.getPluginManager().registerEvents(new BlockBreakDing(), this);
        Bukkit.getPluginManager().registerEvents(new LightningRod(), this);
        Bukkit.getPluginManager().registerEvents(new InteractEvent(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new Kills(), this);

        mainNameSpacedKey = new NamespacedKey(this, "Dungeon");

        Commands commands = new Commands();
        getCommand("day").setExecutor(commands);
        getCommand("lightningrod").setExecutor(commands);
        getCommand("bandit").setExecutor(commands);
        getCommand("spear").setExecutor(commands);
        getCommand("givestuff").setExecutor(commands);
        getCommand("test1").setExecutor(commands);

        IslandCommands islandCommands = new IslandCommands();
        getCommand("island").setExecutor(islandCommands);

        StaffCommands staffCommands = new StaffCommands();
        getCommand("createSpawner").setExecutor(staffCommands);

        SpawnerCommands spawnerCommands = new SpawnerCommands();
        getCommand("spawnertest").setExecutor(spawnerCommands);

        WeaponManager.init();
        MaterialManager.init();
        ToolManager.init();
        UpgradeManager.init();

        SharpenerRecipes.init();
        SpearRecipes.init();

        Bukkit.addRecipe(SharpenerRecipes.pSharpener);
        Bukkit.addRecipe(SpearRecipes.pSpear);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

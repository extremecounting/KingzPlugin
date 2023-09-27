package com.extremecounting.dungeon.mining;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.itemManager.OreItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class OreBlocks implements Listener {


    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack tool = player.getInventory().getItemInMainHand();
        if (MineableUtility.tinLocations.contains(block.getLocation())) {
            event.setCancelled(true);
            block.setType(Material.BEDROCK);
            bedrockTurn(block);
            tinBreak(player);

        } else if (MineableUtility.copperLocations.contains(block.getLocation())) {
            event.setCancelled(true);
            block.setType(Material.BEDROCK);
            bedrockTurn(block);

        } else if (MineableUtility.ironLocations.contains(block.getLocation())) {
            event.setCancelled(true);
            block.setType(Material.BEDROCK);
            bedrockTurn(block);

        }
    }

    private void tinBreak(Player player) {
        player.getInventory().addItem(OreItemManager.tinOre);
    }



    private void bedrockTurn(Block block) {
        Material blockType = block.getType();
        block.setType(Material.BEDROCK);
        Bukkit.getScheduler().runTaskLater(JavaPlugin.getPlugin(Dungeon.class), () -> {
            block.setType(blockType);
        }, 100);
    }

    public static Block createTin(Location location) {
        MineableUtility.tinLocations.add(location);
        Block block = location.getBlock();
        block.setType(Material.COAL_ORE);
        return block;
    }

    public static Block createCopper(Location location) {
        MineableUtility.copperLocations.add(location);
        Block block = location.getBlock();
        block.setType(Material.COPPER_ORE);
        return block;
    }

    public static Block createIron(Location location) {
        MineableUtility.ironLocations.add(location);
        Block block = location.getBlock();
        block.setType(Material.IRON_ORE);
        return block;
    }
}

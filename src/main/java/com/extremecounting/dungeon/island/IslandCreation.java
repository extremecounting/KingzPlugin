package com.extremecounting.dungeon.island;

import com.extremecounting.dungeon.Dungeon;
import com.extremecounting.dungeon.player.PlayerConfig;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.extremecounting.dungeon.island.IslandUtility.createIslandConfig;
import static com.extremecounting.dungeon.island.IslandUtility.islands;

public class IslandCreation {


    public static void islandCreation(Player player) throws IOException {

        if (IslandUtility.playerHasIsland(player)) {
            player.sendMessage("§cYou already have an island!");
            return;
        }

        loopA: for (int i = 0; i<10000; i++) {
            for (int j = 0; j<12; j++) {
                if (!IslandUtility.islandLocationTaken(j, i)) {
                    player.sendMessage(j + " " + i);
                    createIslandConfig(j, i, player);
                    PlayerConfig.islandCreationPlayerConfig(Dungeon.usersFolder, player);
                    makeIsland(j, i, player);
                    islands[j][i] = true;
                    break loopA;
                }
            }

        }
    }

    private static void makeIsland(int x, int z, Player player) {
        Location islandLocation = new Location(player.getWorld(), x *50, 200, z*50);
        Block block = islandLocation.getBlock();
        block.setType(Material.BEDROCK);
        List<Block> stoneList = new ArrayList<>();
        List<Block> dirtList = new ArrayList<>();
        for (int i = -4;i<5; i++) {
            for (int j = -4; j<5; j++) {
                dirtList.add(islandLocation.add(i, 1, j).getBlock());
                islandLocation.subtract(i, 1, j);
                if (i != 0 || j!= 0) {
                    stoneList.add(islandLocation.add(i, 0, j).getBlock());
                    islandLocation.subtract(i, 0, j);
                }
            }
        }

        for (Block block1 : stoneList) {
            block1.setType(Material.STONE);
        }
        for (Block block1 : dirtList) {
            block1.setType(Material.GRASS_BLOCK);
        }
        islandLocation.add(0, 2, 2);
        islandLocation.getBlock().setType(Material.CHEST);

        Chest chest = (Chest) islandLocation.getBlock().getState();

        chest.getInventory().addItem(new ItemStack(Material.OAK_LOG, 16), new ItemStack(Material.COBBLESTONE, 64));

        islandLocation.subtract(0, 2, 2);

        player.teleport(islandLocation.add(0, 2, 0));
    }

}

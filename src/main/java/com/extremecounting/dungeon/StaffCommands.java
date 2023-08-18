package com.extremecounting.dungeon;

import com.extremecounting.dungeon.itemManager.CoinBagManager;
import com.extremecounting.dungeon.mining.OreBlocks;
import com.extremecounting.dungeon.mobs.SpawnerUtil;
import com.extremecounting.dungeon.npcs.TobiasF;
import com.extremecounting.dungeon.staff.Camel;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;
        if (!sender.isOp()) {
            return true;
        }
        if (cmd.getName().equalsIgnoreCase("suicide")) {
            player.setHealth(0);
            Bukkit.broadcastMessage("§2" + player.getName() + " has taken their own life!");
        }
        if (cmd.getName().equalsIgnoreCase("stop")) {
            Bukkit.getServer().shutdown();
        }
        if (cmd.getName().equalsIgnoreCase("spawncamel123")) {
            if (player.getName().equalsIgnoreCase("extremecounting")) {
                Camel.spawnJester(player.getLocation());
            }
        }
        if (cmd.getName().equalsIgnoreCase("cleane")) {
            if (player.getName().equalsIgnoreCase("extremecounting") || player.getName().equalsIgnoreCase("cultivized")) {
                Camel.cleanEntities();
            }
        }
        if (cmd.getName().equalsIgnoreCase("createtin")) {
            if (args.length > 2) {
                Location location = new Location(player.getWorld(), Double.valueOf(args[0]), Double.valueOf(args[1]), Double.valueOf(args[2]));
                OreBlocks.createTin(location);
            }
        }
        if (cmd.getName().equalsIgnoreCase("spawnerstart")) {
            SpawnerUtil.startSpawning();
        }
        if (cmd.getName().equalsIgnoreCase("spawnfarmer")) {
            TobiasF.spawnFarmer(player.getLocation());
        }
        if (cmd.getName().equalsIgnoreCase("givecoinbag")) {
            player.getInventory().addItem(CoinBagManager.coinBag);
        }
        return true;
    }
}

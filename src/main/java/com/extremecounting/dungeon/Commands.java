package com.extremecounting.dungeon;

import com.extremecounting.dungeon.itemManager.MaterialManager;
import com.extremecounting.dungeon.itemManager.WeaponManager;
import com.extremecounting.dungeon.mobs.BanditSpawner;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("day")) {
            player.getWorld().setTime(1000L);
        }
        else if (cmd.getName().equalsIgnoreCase("lightningrod")) {
            player.getInventory().addItem(WeaponManager.lightningRod);
        }
        else if (cmd.getName().equalsIgnoreCase("bandit")) {

        }
        else if (cmd.getName().equalsIgnoreCase("spear")) {
            player.getInventory().addItem(WeaponManager.pSpear);
        } else if (cmd.getName().equalsIgnoreCase("givestuff")) {
            player.getInventory().addItem(MaterialManager.flint);
            player.getInventory().addItem(MaterialManager.vine);
            player.getInventory().addItem(MaterialManager.driftWood);
        } else if (cmd.getName().equalsIgnoreCase("test1")) {
            player.getLocation().getBlock().setType(Material.CHEST);
            Chest chest = (Chest) player.getLocation().getBlock().getState();
            chest.getInventory().addItem(new ItemStack(Material.STONE));
        } else if (cmd.getName().equalsIgnoreCase("tpa")) {
            if (args.length != 1) {
                player.sendMessage(ChatColor.RED + "Usage: /tpa <player>");
                return true;
            }
            Player targetPlayer = player.getServer().getPlayer(args[0]);
            if (targetPlayer == null || !targetPlayer.isOnline()) {
                player.sendMessage(ChatColor.RED + "Player not found or offline.");
                return true;
            }
            player.sendMessage(ChatColor.GOLD + "Request sent to: " + targetPlayer.getName());
            targetPlayer.sendMessage(ChatColor.YELLOW + player.getName() +" wants to teleport to you! Click " + ChatColor.GREEN + "ACCEPT" + ChatColor.YELLOW + " to accept or Click " + ChatColor.RED + "DENY" + ChatColor.YELLOW + " to deny. You have 30 seconds to decide.");

            ComponentBuilder acceptButton = new ComponentBuilder("ACCEPT")
                    .color(net.md_5.bungee.api.ChatColor.GREEN)
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept " + player.getName()));
            ComponentBuilder denyButton = new ComponentBuilder("DENY")
                    .color(net.md_5.bungee.api.ChatColor.RED)
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpdeny " + player.getName()));
            targetPlayer.spigot().sendMessage(acceptButton.create());
            targetPlayer.spigot().sendMessage(denyButton.create());

            teleportRequests.put(targetPlayer, player);

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (teleportRequests.containsKey(targetPlayer)) {
                        teleportRequests.remove(targetPlayer);
                        player.sendMessage(ChatColor.YELLOW + "Teleport request to " + targetPlayer.getName() + ChatColor.RED + " expired.");
                        targetPlayer.sendMessage(ChatColor.YELLOW + "Teleport request from " + player.getName() + ChatColor.RED + " expired.");
                    }
                }
            }.runTaskLater(plugin, 600L);
        } else if (cmd.getName().equalsIgnoreCase("tpaccept")) {
            Player accepter = player;
            Player targetPlayer = teleportRequests.get(accepter);
            if (targetPlayer != null) {
                accepter.sendMessage(ChatColor.GREEN + "You accepted the teleport request from " + ChatColor.YELLOW + targetPlayer.getName() + ChatColor.GREEN + "! Teleporting in 5 seconds...");
                targetPlayer.sendMessage(ChatColor.YELLOW + accepter.getName() + ChatColor.GREEN + " has ACCEPTED your TP request! Teleporting them in 5 seconds...");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        accepter.teleport(targetPlayer.getLocation());
                        accepter.sendMessage(ChatColor.GREEN + "You have been teleported to " + ChatColor.YELLOW + targetPlayer.getName() + ChatColor.GREEN + "!");
                    }
                }.runTaskLater(plugin, 100L);
                teleportRequests.remove(accepter);
            }
        } else if (cmd.getName().equalsIgnoreCase("tpdeny")) {
            Player denier = player;
            Player targetPlayer = teleportRequests.get(denier);
            if (targetPlayer != null) {
                denier.sendMessage(ChatColor.RED + "You DENIED the TP request from" + ChatColor.YELLOW + targetPlayer.getName() + ChatColor.RED + ".");
                targetPlayer.sendMessage(ChatColor.YELLOW + denier.getName() + ChatColor.RED + " DENIED your TP request.");
                teleportRequests.remove(denier);
            }
        }

        return true;
    }
}

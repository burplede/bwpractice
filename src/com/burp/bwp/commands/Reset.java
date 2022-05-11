package com.burp.bwp.commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.HashSet;
import java.util.Set;

public class Reset implements CommandExecutor, Listener {
    Set<Location> locations = new HashSet<>();

    @EventHandler
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            // adding block locations to the hashset
            locations.add(e.getBlock().getLocation());
        }
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            World w = Bukkit.getWorld("world");
            for (Location l : locations) {
                w.getBlockAt(l).setType(Material.AIR);
            }
        }
        return true;
    }
}

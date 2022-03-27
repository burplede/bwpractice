package com.burp.bwp.listeners;

import cubing.bukkit.ItemUtils;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;


public class BlockPlaceEvent implements Listener {
    Set<Location> locations = new HashSet<>();

    @EventHandler
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            //check if the block is wool
            if (e.getBlock().getType() == Material.WOOL) {
                // adding block locations to the hashset
                locations.add(e.getBlock().getLocation());z
            }
        }
    }
    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() != GameMode.CREATIVE) {
            if (p.getLocation().getY() < 90 ) {
                World w = p.getWorld();
                for(Location l : locations) {
                    w.getBlockAt(l).setType(Material.AIR);
                }
            }
        }
    }
}

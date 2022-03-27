package com.burp.bwp.listeners;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakEvent implements Listener {

    @EventHandler
    public void onBreak(org.bukkit.event.block.BlockBreakEvent e) {
        Player p = e.getPlayer();
        Block block = e.getBlock();
        if (p.getGameMode() != GameMode.CREATIVE) {
            if (block.getType() == Material.WOOL) {
                e.setCancelled(false);
            } else {e.setCancelled(true);}
        }
    }
}

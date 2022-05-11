package com.burp.bwp.listeners;

import com.burp.bwp.Bwp;
import net.minecraft.server.v1_8_R3.BlockPosition;
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
            if (block.getType() != Material.WOOL) {
                e.setCancelled(true);
            }
            else {
                e.getBlock().setType(Material.AIR);
                Bwp.Diff.remove(new BlockPosition(block.getX(), block.getY(), block.getZ()));
            }
        }
    }
}

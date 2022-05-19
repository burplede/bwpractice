package com.burp.bwp.listeners;

import com.burp.bwp.Bwp;
import cubing.bukkit.ItemUtils;
import net.minecraft.server.v1_8_R3.BlockPosition;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class BlockPlaceEvent implements Listener {
    Set<Location> locations = new HashSet<>();

    public static final Map<BlockPosition, Integer[]> Diff = new HashMap<>();
    public static int id = 0;

    @EventHandler
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        Player p = e.getPlayer();
      if (p.getGameMode() != GameMode.CREATIVE) {
            Block block = e.getBlock();
            if (block.getType() == Material.RED_ROSE) {e.setCancelled(true);}
            else {
                Bwp.Diff.put(new BlockPosition(block.getX(), block.getY(), block.getZ()), 0);
                Bwp.id++;
                if (p.getItemInHand().getAmount() < 64) {
                    Material m = p.getInventory().getItemInHand().getType();
                    ItemStack material = ItemUtils.item(m, null, 1, -1, false, false, null, null, null, null);
                    p.getInventory().addItem(material);
                }
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

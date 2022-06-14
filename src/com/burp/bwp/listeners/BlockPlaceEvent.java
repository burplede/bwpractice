package com.burp.bwp.listeners;

import com.burp.bwp.Main;
import cubing.bukkit.ItemUtils;
import net.minecraft.server.v1_8_R3.BlockPosition;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.*;


public class BlockPlaceEvent implements Listener {
    Set<Location> locations = new HashSet<>();

    public static final Map<BlockPosition, Integer[]> Diff = new HashMap<>();
    public static int id = 0;

    @EventHandler
    public void onPlace(org.bukkit.event.block.BlockPlaceEvent e) {
        Player p = e.getPlayer();
        UUID uuid = p.getUniqueId();

        if (p.getGameMode() != GameMode.CREATIVE) {
            Block block = e.getBlock();

            if (block.getType() != Material.WOOL) {e.setCancelled(true);}
            else {
                Main.Diff.put(new BlockPosition(block.getX(), block.getY(), block.getZ()), 0);
                Main.id++;
                if (p.getItemInHand().getAmount() < 64) {
                    Material m = p.getInventory().getItemInHand().getType();
                    ItemStack material = ItemUtils.item(m, null, 1, 11, false, false, null, null, null, null);
                    p.getInventory().addItem(material);



                }
            }
        }
    }
}

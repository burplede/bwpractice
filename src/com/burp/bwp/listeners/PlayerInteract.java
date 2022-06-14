package com.burp.bwp.listeners;

import com.burp.bwp.utils.CosmeticsGUI;
import com.burp.bwp.utils.HitSelector;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getAction() != Action.RIGHT_CLICK_AIR && e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (e.getItem() == null) return;
        if (e.getItem().getItemMeta() == null) return;
        if (e.getItem().getItemMeta().getDisplayName() == null) return;

        if (e.getItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Clutch Menu")) {
            Inventory gui = Bukkit.createInventory(p, 27, ChatColor.GOLD + "What type of Clutch?");
            gui.setItem(0, HitSelector.KnockbackOption(
                    "1 Hit Straight",
                    Material.SANDSTONE
            ));
            gui.setItem(1, HitSelector.KnockbackOption(
                    "2 Hit Straight",
                    Material.SANDSTONE
            ));
            gui.setItem(2, HitSelector.KnockbackOption(
                    "3 Hit Straight",
                    Material.SANDSTONE
            ));
            gui.setItem(3, HitSelector.KnockbackOption(
                    "4 Hit Straight",
                    Material.SANDSTONE
            ));
            gui.setItem(4, HitSelector.KnockbackOption(
                    "5 Hit Straight",
                    Material.SANDSTONE
            ));
            gui.setItem(5, HitSelector.KnockbackOption(
                    "6 Hit Straight",
                    Material.SANDSTONE
            ));
            gui.setItem(6, HitSelector.KnockbackOption(
                    "7 Hit Straight",
                    Material.SANDSTONE
            ));
            gui.setItem(7, HitSelector.KnockbackOption(
                    "8 Hit Straight",
                    Material.SANDSTONE
            ));
            gui.setItem(8, HitSelector.KnockbackOption(
                    "Bamsi",
                    Material.STICK
            ));
            gui.setItem(9, HitSelector.KnockbackOption(
                    "1 Hit Diagonal",
                    Material.SANDSTONE_STAIRS
            ));
            gui.setItem(10, HitSelector.KnockbackOption(
                    "2 Hit Diagonal",
                    Material.SANDSTONE_STAIRS
            ));
            gui.setItem(11, HitSelector.KnockbackOption(
                    "3 Hit Diagonal",
                    Material.SANDSTONE_STAIRS
            ));
            gui.setItem(12, HitSelector.KnockbackOption(
                    "4 Hit Diagonal",
                    Material.SANDSTONE_STAIRS
            ));
            gui.setItem(13, HitSelector.KnockbackOption(
                    "5 Hit Diagonal",
                    Material.SANDSTONE_STAIRS
            ));
            gui.setItem(14, HitSelector.KnockbackOption(
                    "6 Hit Diagonal",
                    Material.SANDSTONE_STAIRS
            ));
            gui.setItem(15, HitSelector.KnockbackOption(
                    "7 Hit Diagonal",
                    Material.SANDSTONE_STAIRS
            ));
            gui.setItem(16, HitSelector.KnockbackOption(
                    "8 Hit Diagonal",
                    Material.SANDSTONE_STAIRS
            ));
            gui.setItem(17, HitSelector.KnockbackOption(
                    "Bedwars Practice",
                    Material.BED
            ));
            gui.setItem(18, HitSelector.KnockbackOption(
                    "1 Hit Semi-Diagonal",
                    Material.RED_SANDSTONE_STAIRS
            ));
            gui.setItem(19, HitSelector.KnockbackOption(
                    "2 Hit Semi-Diagonal",
                    Material.RED_SANDSTONE_STAIRS
            ));
            gui.setItem(20, HitSelector.KnockbackOption(
                    "3 Hit Semi-Diagonal",
                    Material.RED_SANDSTONE_STAIRS
            ));
            gui.setItem(21, HitSelector.KnockbackOption(
                    "4 Hit Semi-Diagonal",
                    Material.RED_SANDSTONE_STAIRS
            ));
            gui.setItem(22, HitSelector.KnockbackOption(
                    "5 Hit Semi-Diagonal",
                    Material.RED_SANDSTONE_STAIRS
            ));
            gui.setItem(23, HitSelector.KnockbackOption(
                    "6 Hit Semi-Diagonal",
                    Material.RED_SANDSTONE_STAIRS
            ));
            gui.setItem(24, HitSelector.KnockbackOption(
                    "7 Hit Semi-Diagonal",
                    Material.RED_SANDSTONE_STAIRS
            ));
            gui.setItem(25, HitSelector.KnockbackOption(
                    "8 Hit Semi-Diagonal",
                    Material.RED_SANDSTONE_STAIRS
            ));
            gui.setItem(26, HitSelector.KnockbackOption(
                    "TeamHoly",
                    Material.SANDSTONE_STAIRS
            ));
            p.getInventory().setHeldItemSlot(1);
            p.openInventory(gui);
            e.setCancelled(true);
        }

        if(e.getItem().getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Cosmetics")) {
            CosmeticsGUI.openGUI(p);
        }
    }
}

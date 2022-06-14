package com.burp.bwp.listeners;

import com.burp.bwp.Main;
import com.burp.bwp.utils.FakeHit;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

public class InventoryClickEvent implements Listener {
    BukkitScheduler scheduler = Bukkit.getScheduler();

    @EventHandler
    public void onClick(org.bukkit.event.inventory.InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (e.getClickedInventory().getName() == null) return;

        Plugin plugin = Main.getPlugin(Main.class);
        Player p = (Player) e.getWhoClicked();

        String itemName = e.getCurrentItem().getItemMeta().getDisplayName();
        String prefix = ChatColor.GOLD + "[" + itemName + ChatColor.GOLD + "] ";

        p.sendMessage(prefix + 3);
        scheduler.runTaskLater(plugin, () -> p.sendMessage(prefix + 2), 20);
        scheduler.runTaskLater(plugin, () -> p.sendMessage(prefix + 1), 40);

        if (e.getInventory().getTitle().equals(ChatColor.GOLD + "What type of Clutch?"))  {
            e.setCancelled(true);
            
            switch (itemName.substring(2)) {
                case "1 Hit Straight":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.42, 0.462, "straight"), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 70);
                    p.closeInventory();
                    break;
                case "2 Hit Straight":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.45, 0.43, "straight"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.3, 0.426, "straight"), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 80);
                    p.closeInventory();
                    break;
                case "3 Hit Straight":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.45, 0.44, "straight"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.3, 0.412, "straight"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.3, 0.41, "straight"), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 90);
                    p.closeInventory();
                    break;
                case "4 Hit Straight":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.45, 0.44, "straight"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.333, 0.4, "straight"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.32, 0.395, "straight"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.3, 0.385, "straight"), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 100);
                    p.closeInventory();
                    break;
                case "5 Hit Straight":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.45, 0.44, "straight"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.36, 0.4, "straight"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.35, 0.395, "straight"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.34, 0.385, "straight"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.3, 0.376, "straight"), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 110);
                    p.closeInventory();
                    break;
                case "6 Hit Straight":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.45, 0.44, "straight"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.36, 0.4, "straight"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.35, 0.395, "straight"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.34, 0.385, "straight"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.33, 0.381, "straight"), 100);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.31, 0.375, "straight"), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(6), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 120);
                    p.closeInventory();
                    break;
                case "7 Hit Straight":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.45, 0.44, "straight"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.36, 0.4, "straight"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.35, 0.395, "straight"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.34, 0.385, "straight"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.33, 0.381, "straight"), 100);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.32, 0.375, "straight"), 110);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.31, 0.375, "straight"), 120);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(6), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(7), 120);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 130);
                    p.closeInventory();
                    break;
                case "8 Hit Straight":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.45, 0.44, "straight"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.36, 0.4, "straight"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.35, 0.39, "straight"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.34, 0.38, "straight"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.33, 0.375, "straight"), 100);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.32, 0.374, "straight"), 110);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.31, 0.374, "straight"), 120);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.3, 0.372, "straight"), 130);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(6), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(7), 120);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(8), 130);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 140);
                    p.closeInventory();
                    break;
                case "Bamsi":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.435, 0.47,"straight"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.271, 0.47, "straight"), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 80);
                    p.closeInventory();
                    break;
                case "1 Hit Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.68, 0.462, "diagonal"), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 70);
                    p.closeInventory();
                    break;
                case "2 Hit Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.68, 0.44, "diagonal"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.55, 0.43, "diagonal"), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 80);
                    p.closeInventory();
                    break;
                case "3 Hit Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.68, 0.44, "diagonal"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.412, "diagonal"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.54, 0.41, "diagonal"), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 90);
                    p.closeInventory();
                    break;
                case "4 Hit Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.68, 0.44, "diagonal"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.34, "diagonal"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.56, 0.395, "diagonal"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.54, 0.385, "diagonal"), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 100);
                    p.closeInventory();
                    break;
                case "5 Hit Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.68, 0.44, "diagonal"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.4, "diagonal"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.57, 0.395, "diagonal"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.56, 0.385, "diagonal"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.54, 0.376, "diagonal"), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 110);
                    p.closeInventory();
                    break;
                case "6 Hit Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.68, 0.44, "diagonal"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.34, "diagonal"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.395, "diagonal"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.57, 0.385, "diagonal"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.56, 0.381, "diagonal"), 100);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.54, 0.375, "diagonal"), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(6), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 120);
                    p.closeInventory();
                    break;
                case "7 Hit Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.68, 0.44, "diagonal"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.34, "diagonal"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.395, "diagonal"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.385, "diagonal"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.381, "diagonal"), 100);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.55, 0.376, "diagonal"), 110);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.54, 0.375, "diagonal"), 120);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(6), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(7), 120);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 130);
                    p.closeInventory();
                    break;
                case "8 Hit Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.68, 0.44, "diagonal"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.4, "diagonal"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.395, "diagonal"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.385, "diagonal"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.381, "diagonal"), 100);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.58, 0.376, "diagonal"), 110);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.56, 0.376, "diagonal"), 120);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.55, 0.375, "diagonal"), 130);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(6), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(7), 120);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(8), 130);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 140);
                    p.closeInventory();
                    break;
                case "Bedwars Practice":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.91, 0.443, "straight"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.84, 0.426, "straight"), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 80);
                    p.closeInventory();
                    break;
                case "1 Hit Semi-Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.8, 0.462, "semi"), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 70);
                    p.closeInventory();
                    break;
                case "2 Hit Semi-Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.8, 0.44, "semi"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.43, "semi"), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 80);
                    p.closeInventory();
                    break;
                case "3 Hit Semi-Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.8, 0.44, "semi"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.412, "semi"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.41, "semi"), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 90);
                    p.closeInventory();
                    break;
                case "4 Hit Semi-Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.8, 0.44, "semi"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.4, "semi"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.395, "semi"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.385, "semi"), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 100);
                    p.closeInventory();
                    break;
                case "5 Hit Semi-Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.8, 0.44, "semi"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.4, "semi"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.395, "semi"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.385, "semi"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.376, "semi"), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 110);
                    p.closeInventory();
                    break;
                case "6 Hit Semi-Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.8, 0.44, "semi"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.375, "semi"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.375, "semi"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.375, "semi"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.375, "semi"), 100);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.375, "semi"), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(6), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 120);
                    p.closeInventory();
                    break;
                case "7 Hit Semi-Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.8, 0.44, "semi"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.4, "semi"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.395, "semi"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.385, "semi"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.381, "semi"), 100);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.375, "semi"), 110);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.375, "semi"), 120);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(6), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(7), 120);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 130);
                    p.closeInventory();
                    break;
                case "8 Hit Semi-Diagonal":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.8, 0.44, "semi"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.4, "semi"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.395, "semi"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.385, "semi"), 90);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.381, "semi"), 100);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.376, "semi"), 110);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.376, "semi"), 120);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 0.7, 0.375, "semi"), 130);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(3), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(4), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(5), 100);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(6), 110);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(7), 120);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(8), 130);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 140);
                    p.closeInventory();
                    break;
                case "TeamHoly":
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 2.7, 0.429,"straight"), 60);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.615, 0.429, "straight"), 70);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.61, 0.4295, "straight"), 80);
                    scheduler.runTaskLater(plugin, () -> FakeHit.FakeDirectionalHit(p, 1.555, 0.43, "straight"), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(1), 60);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 70);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 80);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(2), 90);
                    scheduler.runTaskLater(plugin, () -> p.setLevel(0), 100);
                    p.closeInventory();
                    break;
            }
        }


        if (e.getClickedInventory() == null)
            return;
        if (e.getCurrentItem() == null)
            return;

        if (e.getClickedInventory().getTitle().equals(ChatColor.GOLD + "Cosmetics")) {
            if (e.getCurrentItem().getType() != Material.AIR) {
                for(int i = 0; i < p.getInventory().getContents().length; i++) {
                    ItemStack item = p.getInventory().getItem(i);
                    if (item == null || item.getType() == null) continue;

                    if (item.getType().isBlock() && item.getType() != Material.CHEST) {
                        p.getInventory().setItem(i, e.getCurrentItem().clone());
                        p.getInventory().getItem(i).setAmount(64);
                    }
                }

                p.closeInventory();

                e.setCancelled(true);
            }
        }

    }
}

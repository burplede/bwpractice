package com.burp.bwp.listeners;

import cubing.bukkit.ItemUtils;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashSet;
import java.util.Set;

public class PlayerYAxisListener implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if (p.getGameMode() == GameMode.CREATIVE) {
        }
        else if (p.getLocation().getY() < 85) {

            p.teleport(new Location(p.getWorld(), 0.500D, 101.00D, 0.500D, Float.parseFloat("-0.0"), Float.parseFloat("-0.0")));
            p.getInventory().clear();
            PlayerInventory inv = p.getPlayer().getInventory();
            ItemStack stack1 = ItemUtils.item(Material.IRON_HELMET, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[]{1}, null);
            ItemStack stack2 = ItemUtils.item(Material.IRON_CHESTPLATE, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[]{1}, null);
            ItemStack stack3 = ItemUtils.item(Material.IRON_LEGGINGS, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[]{1}, null);
            ItemStack stack4 = ItemUtils.item(Material.IRON_BOOTS, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[]{1}, null);
            ItemStack kb1 = ItemUtils.item(Material.STICK, "§6Knockback Stick", 1, -1, true, true, null, new Enchantment[] {Enchantment.KNOCKBACK}, new int[]{1}, null);
            ItemStack axe = ItemUtils.item(Material.WOOD_AXE, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.DIG_SPEED}, new int[]{1}, null);
            ItemStack pick = ItemUtils.item(Material.WOOD_PICKAXE, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.DIG_SPEED}, new int[]{1}, null);
            ItemStack shears = ItemUtils.item(Material.SHEARS, null, 1, -1, false, true, null, null, null, null);
            ItemStack wool = ItemUtils.item(Material.WOOL, null, 128, -1, false, false, null, null, null, null);
            ItemStack sword = ItemUtils.item(Material.WOOD_SWORD, null, 1, -1, false, true, null, null, null, null);
            ItemStack dye = ItemUtils.item(Material.RED_ROSE, null, 1, -1, false, true, null, null, null, null);
            ItemStack menu = new ItemStack(Material.NETHER_STAR);
            ItemMeta menua = menu.getItemMeta();
            menua.setDisplayName("Clutch Modes");

            inv.setHelmet(stack1);
            inv.setChestplate(stack2);
            inv.setLeggings(stack3);
            inv.setBoots(stack4);
            p.getInventory().addItem(sword);
            p.getInventory().addItem(wool);
            p.getInventory().addItem(axe);
            p.getInventory().addItem(pick);
            p.getInventory().addItem(shears);
            p.getInventory().addItem(kb1);
            p.getInventory().addItem(menu);
            p.getInventory().addItem(dye);
        }
    }

}

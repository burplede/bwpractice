package com.burp.bwp.commands;

import cubing.bukkit.ItemUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class ResetInv implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            Player p = (Player)sender;
            p.getInventory().clear();
            PlayerInventory inv = p.getPlayer().getInventory();
            ItemStack stack1 = ItemUtils.item(Material.IRON_HELMET, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[]{1}, null);
            ItemStack stack2 = ItemUtils.item(Material.IRON_CHESTPLATE, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[]{1}, null);
            ItemStack stack3 = ItemUtils.item(Material.IRON_LEGGINGS, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[]{1}, null);
            ItemStack stack4 = ItemUtils.item(Material.IRON_BOOTS, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.PROTECTION_ENVIRONMENTAL}, new int[]{1}, null);
            ItemStack kb1 = ItemUtils.item(Material.STICK, "§6Knockback Stick", 1, -1, true, true, null, new Enchantment[] {Enchantment.KNOCKBACK}, new int[]{1}, null);
            ItemStack kb2 = ItemUtils.item(Material.STICK, "§6Knockback 2 Stick", 1, -1, true, true, null, new Enchantment[] {Enchantment.KNOCKBACK}, new int[]{2}, null);
            ItemStack axe = ItemUtils.item(Material.WOOD_AXE, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.DIG_SPEED}, new int[]{1}, null);
            ItemStack pick = ItemUtils.item(Material.WOOD_PICKAXE, null, 1, -1, true, true, null, new Enchantment[] {Enchantment.DIG_SPEED}, new int[]{1}, null);
            ItemStack shears = ItemUtils.item(Material.SHEARS, null, 1, -1, false, true, null, null, null, null);
            ItemStack wool = ItemUtils.item(Material.WOOL, null, 128, -1, false, false, null, null, null, null);
            ItemStack sword = ItemUtils.item(Material.WOOD_SWORD, null, 1, -1, false, true, null, null, null, null);

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
            p.getInventory().addItem(kb2);
        }
        return true;
    }
}

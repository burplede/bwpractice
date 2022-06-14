package com.burp.bwp.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class HitSelector {
    public static ItemStack KnockbackOption(String name, Material displayItem) {
        ItemStack item = new ItemStack(displayItem);

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + name);
        item.setItemMeta(meta);

        return item;
    }
}

package com.burp.bwp.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuCommand implements CommandExecutor {
    static org.bukkit.inventory.Inventory gui1;
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        gui1 = Bukkit.createInventory(null, 9, "§6What type of Clutch?");
        for (int i = 0; i < 9; i++) {
            gui1.setItem(i, new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15));
        }
        ItemStack s = new ItemStack(Material.SANDSTONE, 1);
        ItemMeta m = s.getItemMeta();
        m.setDisplayName("§r§62 hits bwp");
        s.setItemMeta(m);
        ItemStack s2 = new ItemStack(Material.SANDSTONE, 1);
        ItemMeta m2 = s2.getItemMeta();
        m2.setDisplayName("§r§62 hits jitter clitck");
        s2.setItemMeta(m2);
        ItemStack s3 = new ItemStack(Material.STICK, 1);
        ItemMeta m3 = s2.getItemMeta();
        m3.setDisplayName("§r§61 hit MLGRush");
        s3.setItemMeta(m3);
        ItemStack s4 = new ItemStack(Material.STICK, 1);
        ItemMeta m4 = s4.getItemMeta();
        m4.setDisplayName("§r§62 hits MLGRush");
        s4.setItemMeta(m3);
        gui1.setItem(0, s);
        gui1.setItem(1, s2);
        gui1.setItem(2, s3);
        gui1.setItem(3, s4);

        if(sender instanceof Player){
            Player player = (Player)sender;
            player.sendMessage("§aOpened Clutch Menu!");
            player.openInventory(gui1);
        }
        return true;
    }
}

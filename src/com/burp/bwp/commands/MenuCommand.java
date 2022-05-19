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
    @Override
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
        m2.setDisplayName("§r§62 hits diagonal");
        s2.setItemMeta(m2);
        ItemStack s3 = new ItemStack(Material.SANDSTONE, 1);
        ItemMeta m3 = s3.getItemMeta();
        m3.setDisplayName("§r§63 hits diagonal");
        s3.setItemMeta(m3);
        ItemStack s4 = new ItemStack(Material.SANDSTONE, 1);
        ItemMeta m4 = s4.getItemMeta();
        m4.setDisplayName("§r§62 hits Semi Diagonal");
        s4.setItemMeta(m4);
        ItemStack s5 = new ItemStack(Material.STICK, 1);
        ItemMeta m5 = s5.getItemMeta();
        m5.setDisplayName("§r§62 hit MLGRush Low Vertical KB");
        s5.setItemMeta(m5);
        ItemStack s6 = new ItemStack(Material.STICK, 1);
        ItemMeta m6 = s6.getItemMeta();
        m6.setDisplayName("§r§63 hit MLGRush Low Vertical KB");
        s6.setItemMeta(m6);
        ItemStack s7 = new ItemStack(Material.STICK, 1);
        ItemMeta m7 = s7.getItemMeta();
        m7.setDisplayName("§r§61 hit MLGRush");
        s7.setItemMeta(m7);
        ItemStack s8 = new ItemStack(Material.STICK, 1);
        ItemMeta m8 = s8.getItemMeta();
        m8.setDisplayName("§r§62 hits MLGRush");
        s8.setItemMeta(m8);

        gui1.setItem(0, s);
        gui1.setItem(1, s2);
        gui1.setItem(2, s3);
        gui1.setItem(3, s4);
        gui1.setItem(4, s5);
        gui1.setItem(5, s6);
        gui1.setItem(6, s7);
        gui1.setItem(7, s8);

        if(sender instanceof Player){
            Player player = (Player)sender;
            player.sendMessage("§aOpened Clutch Menu!");
            player.openInventory(gui1);
        }
        return true;
    }
}

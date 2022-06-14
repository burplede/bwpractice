package com.burp.bwp;

import com.burp.bwp.commands.Reset;
import com.burp.bwp.commands.ResetInv;
import com.burp.bwp.listeners.*;
import net.minecraft.server.v1_8_R3.Block;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import org.bukkit.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.*;

public class Main extends JavaPlugin {
    BukkitScheduler scheduler = Bukkit.getScheduler();

    public int BlockPlaced;

    @Override
    public void onEnable() {
        Bukkit.setDefaultGameMode(GameMode.SURVIVAL);
        Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);

        //Register Listeners
        Bukkit.getPluginManager().registerEvents(new BlockBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceEvent(), this);
        Bukkit.getPluginManager().registerEvents(new dropEventListener(), this);
        Bukkit.getPluginManager().registerEvents(new FallDamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new foodChange(), this);
        Bukkit.getPluginManager().registerEvents(new GoodWeatherListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickEvent(), this);
        Bukkit.getPluginManager().registerEvents(new onDeath(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerInteract(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerYAxisListener(), this);

        //Commands
        this.getCommand("resetinv").setExecutor(new ResetInv());
        this.getCommand("reset").setExecutor(new Reset());


        // Block remove thing
        World world = Bukkit.getWorld("world");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            Set<BlockPosition> ba = new HashSet<>();
            for (Map.Entry<BlockPosition, Integer> x : Diff.entrySet()) {
                int age = x.getValue();
                if (age == 120) {
                    BlockPosition b = x.getKey();
                    world.getBlockAt(b.getX(), b.getY(), b.getZ()).setType(Material.REDSTONE_BLOCK);
                } else if (age == 140) {
                    BlockPosition b = x.getKey();
                    world.getBlockAt(b.getX(), b.getY(), b.getZ()).setType(Material.AIR);

                    ba.add(b);
                }
            }
            for (BlockPosition b : ba) {
                Diff.remove(b);
            }
            for (BlockPosition x : Diff.keySet()) {
                Diff.put(x, Diff.get(x) + 1);
            }
        }, 0, 1);

        //Advertising message
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(ChatColor.GOLD + "Don't forget to join our discord!");
                Bukkit.broadcastMessage(ChatColor.GOLD + "https://dsc.gg/uburp");

            }
        }, 2400, 2400);
    }

    public static HashMap<BlockPosition, Integer> Diff = new HashMap<>();
    public static int id = 0;

}
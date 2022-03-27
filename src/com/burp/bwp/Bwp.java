package com.burp.bwp;

import com.burp.bwp.commands.ResetInv;
import com.burp.bwp.listeners.*;
import net.minecraft.server.v1_8_R3.BlockCobbleWall;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Bwp extends JavaPlugin {
    public void onEnable() {
        // Startup Message
        Bukkit.getConsoleSender().sendMessage("Bwp Plugin has been enabled!");

        //Register Listeners
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerYAxisListener(),this);
        Bukkit.getPluginManager().registerEvents(new foodChange(),this);
        Bukkit.getPluginManager().registerEvents(new GoodWeatherListener(), this);
        Bukkit.getPluginManager().registerEvents(new onDeath(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceEvent(), this);
        Bukkit.getPluginManager().registerEvents(new FallDamageListener(), this);

        //Commands
        this.getCommand("resetinv").setExecutor(new ResetInv());
    }
}

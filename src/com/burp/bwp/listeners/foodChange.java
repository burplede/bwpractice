package com.burp.bwp.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class foodChange implements Listener {
    @EventHandler
    public void foodChangeEvent(FoodLevelChangeEvent e) {e.setCancelled(true);}
}

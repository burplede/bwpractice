package com.burp.bwp;

import com.burp.bwp.commands.MenuCommand;
import com.burp.bwp.commands.Reset;
import com.burp.bwp.commands.ResetInv;
import com.burp.bwp.listeners.*;
import net.minecraft.server.v1_8_R3.BlockCobbleWall;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.PacketPlayOutBlockBreakAnimation;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bwp extends JavaPlugin implements Listener {
    static Inventory gui1;

    public void onEnable() {
        // Startup Message
        Bukkit.getConsoleSender().sendMessage("Bwp Plugin has been enabled!");

        //Register Listeners
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerYAxisListener(), this);
        Bukkit.getPluginManager().registerEvents(new foodChange(), this);
        Bukkit.getPluginManager().registerEvents(new GoodWeatherListener(), this);
        Bukkit.getPluginManager().registerEvents(new onDeath(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakEvent(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceEvent(), this);
        Bukkit.getPluginManager().registerEvents(new FallDamageListener(), this);
        Bukkit.getPluginManager().registerEvents(new dropEventListener(), this);
        Bukkit.getPluginManager().registerEvents(this, this);

        //Commands
        this.getCommand("resetinv").setExecutor(new ResetInv());
        this.getCommand("menu").setExecutor(new MenuCommand());
        this.getCommand("reset").setExecutor(new Reset());


        // Block remove thing
        World world = Bukkit.getWorld("world");
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
            Set<BlockPosition> ba = new HashSet<>();
            for (Map.Entry<BlockPosition, Integer> x : Diff.entrySet()) {
                int age = x.getValue();
                if (age == 100) {
                    BlockPosition b = x.getKey();
                    world.getBlockAt(b.getX(), b.getY(), b.getZ()).setType(Material.REDSTONE_BLOCK);
                } else if (age == 120) {
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
    }

    public static HashMap<BlockPosition, Integer> Diff = new HashMap<>();
    public static int id = 0;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true);

        Player p = (Player) e.getWhoClicked();



        switch (e.getRawSlot()) {
            case 0:
                straightClutch(p);
                p.closeInventory();
                break;
            case 1:
                diagonalClutch(p);
                p.closeInventory();
                break;
            case 2:
                threeDiagonalClutch(p);
                p.closeInventory();
                break;
            case 3:
                semiDiagonal(p);
                p.closeInventory();
                break;
            case 4:
                stickLowVertKB(p);

                p.closeInventory();
                break;
            case 5:
                threeStickLowVertKB(p);
                p.closeInventory();
                break;
            case 6:
                stickClutchOneHit(p);
                p.closeInventory();
                break;
            case 7:
                stickClutchTwoHits(p);
                p.closeInventory();
                break;

        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getItemInHand().getType() == Material.NETHER_STAR) {
            p.openInventory(gui1);
        }
    }

    public void straightClutch(Player p) {



        p.sendMessage("§aStriaght Clutch");
        p.sendMessage("§63");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§62");
            }
        }, 20);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§61");
            }
        }, 40);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§6Clutch!");
                p.setVelocity(new Vector(0, 0.385, 0.87));
                p.damage(0);
            }
        }, 60);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.setVelocity(new Vector(0, 0.385, 0.85));
                p.damage(0);
            }
        }, 70);
    }
    public void stickClutchOneHit(Player p) {
        p.sendMessage("§a1 Stick Clutch");
        p.sendMessage("§63");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§62");
            }
        }, 20);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§61");
            }
        }, 40);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§6Clutch!");
                p.setVelocity(new Vector(0, 0.379, 1.31));
                p.damage(0);
            }
        }, 60);
    }
    public void stickClutchTwoHits(Player p) {
        p.sendMessage("§a2 Stick Clutch");
        p.sendMessage("§63");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§62");
            }
        }, 20);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§61");
            }
        }, 40);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§6Clutch!");
                p.setVelocity(new Vector(0, 0.422, 1.45));
                p.damage(0);
            }
        }, 60);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.setVelocity(new Vector(0, 0.426, 1.3));
                p.damage(0);
            }
        }, 70);
    }
    public void stickLowVertKB(Player p) {
        p.sendMessage("§a2 Stick Low Vert KB");
        p.sendMessage("§63");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§62");
            }
        }, 20);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§61");
            }
        }, 40);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§6Clutch!");
                p.setVelocity(new Vector(0, 0.38, 1.31));
                p.damage(0);
            }
        }, 60);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.setVelocity(new Vector(0, 0.379, 1.31));
                p.damage(0);
            }
        }, 70);
    }
    public void diagonalClutch(Player p) {
        p.sendMessage("§aDiagonal Clutch");
        p.sendMessage("§63");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§62");
            }
        }, 20);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§61");
            }
        }, 40);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§6Clutch!");
                p.setVelocity(new Vector(0.68, 0.377, 0.68));
                p.damage(0);
            }
        }, 60);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.setVelocity(new Vector(0.54, 0.377, 0.54));
                p.damage(0);
            }
        }, 70);
    }
    public void threeDiagonalClutch(Player p) {
        p.sendMessage("§aDiagonal Clutch");
        p.sendMessage("§63");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§62");
            }
        }, 20);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§61");
            }
        }, 40);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§6Clutch!");
                p.setVelocity(new Vector(0.68, 0.377, 0.68));
                p.damage(0);
            }
        }, 60);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.setVelocity(new Vector(0.68, 0.377, 0.68));
                p.damage(0);
            }
        }, 70);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.setVelocity(new Vector(0.54, 0.377, 0.54));
                p.damage(0);
            }
        }, 80);
    }
    public void semiDiagonal(Player p) {
        p.sendMessage("§aSemi-Diagonal Clutch");
        p.sendMessage("§63");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§62");
            }
        }, 20);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§61");
            }
        }, 40);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§6Clutch!");
                p.setVelocity(new Vector(-0.4, 0.382, 0.8));
                p.damage(0);
            }
        }, 60);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.setVelocity(new Vector(-0.39, 0.382, 0.78));
                p.damage(0);
            }
        }, 70);
    }
    public void threeStickLowVertKB(Player p) {
        p.sendMessage("§a3 Stick Low Vert KB");
        p.sendMessage("§63");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§62");
            }
        }, 20);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§61");
            }
        }, 40);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.sendMessage("§6Clutch!");
                p.setVelocity(new Vector(0, 0.379, 1.37));
                p.damage(0);
            }
        }, 60);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.setVelocity(new Vector(0, 0.375, 1.33));
                p.damage(0);
            }
        }, 70);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
            @Override
            public void run() {
                p.setVelocity(new Vector(0, 0.375, 1.32));
                p.damage(0);
            }
        }, 80);
    }
}
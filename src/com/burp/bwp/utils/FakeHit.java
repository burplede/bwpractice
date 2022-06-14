package com.burp.bwp.utils;

import org.bukkit.entity.Player;

public class FakeHit {
        public static void FakeDirectionalHit(Player player, double horizontal, double vertical, String direction) {
            switch (direction) {
                case "straight":
                    player.damage(0.0);
                    player.setVelocity(directionalVector.getVector(player, horizontal, vertical));
                    break;
                case "diagonal":
                    player.damage(0.0);
                    player.setVelocity(directionalVector.getDiagonalVector(player, horizontal, vertical));
                    break;
                case "semi":
                    player.damage(0.0);
                    player.setVelocity(directionalVector.getSemiVector(player, horizontal, vertical));
                    break;
            }
        }
    }
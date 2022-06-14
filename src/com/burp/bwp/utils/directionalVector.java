package com.burp.bwp.utils;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class directionalVector {
        public static Vector getVector(Player p, Double x, Double y) {
            double rotation = p.getLocation().getYaw();
            if (rotation < 0.0D) rotation += 360.0D;
            Vector v = new Vector(0, y, 0);
            if ((0.0D <= rotation) && (rotation < 45.0D)) {
                v.setZ(x * -1);
            } else if ((45.0D <= rotation) && (rotation < 135.0D)) {
                v.setX(x);
            } else if ((135.0D <= rotation) && (rotation < 225.0D)) {
                v.setZ(x);
            } else if ((225.0D <= rotation) && (rotation < 315.0D)) {
                v.setX(x * -1);
            } else {
                v.setZ(x * -1);
            }
            return v;
        }

        public static Vector getDiagonalVector(Player p, Double x, Double y) {
            double rotation = p.getLocation().getYaw();
            if (rotation < 0.0D) rotation += 360.0D;
            Vector v = new Vector(0, y, 0);
            if (rotation >= 0.0D && rotation < 90.0D) {
                v.setX(x);
                v.setZ(x * -1);
            } else if ((90.0D <= rotation) && (rotation < 180.0D)) {
                v.setX(x);
                v.setZ(x);
            } else if ((180.0D <= rotation) && (rotation < 270.0D)) {
                v.setX(x * -1);
                v.setZ(x);
            } else if ((270.0D <= rotation) && (rotation < 360.0D)) {
                v.setX(x * -1);
                v.setZ(x * -1);
            } else {
                v.setX(x);
                v.setZ(x * -1);
            }
            return v;
        }

        public static Vector getSemiVector(Player p, Double x, Double y) {
            double rotation = p.getLocation().getYaw();
            if (rotation < 0.0D) rotation += 360.0D;
            Vector v = new Vector(0, y, 0);
            if (rotation >= 0.0D && rotation < 45.0D) {
                v.setX(x * 0.5);
                v.setZ(x * -1);
            } else if ((45.0D <= rotation) && (rotation < 90.0D)) {
                v.setX(x);
                v.setZ(x * -0.5);
            } else if ((90.0D <= rotation) && (rotation < 135.0D)) {
                v.setX(x);
                v.setZ(x * 0.5);
            } else if ((135.0D <= rotation) && (rotation < 180.0D)) {
                v.setX(x * 0.5);
                v.setZ(x);
            } else if ((180.0D <= rotation) && (rotation < 225.0D)) {
                v.setX(x * -0.5);
                v.setZ(x);
            } else if ((225.0D <= rotation) && (rotation < 270.0D)) {
                v.setX(x * -1);
                v.setZ(x * 0.5);
            } else if ((270.0D <= rotation) && (rotation < 315.0D)) {
                v.setX(x * -1);
                v.setZ(x * -0.5);
            } else if ((315.0D <= rotation) && (rotation < 360.0D)) {
                v.setX(x * -0.5);
                v.setZ(x * -1);
            } else {
                v.setX(x * 0.5);
                v.setZ(x * -1);
            }
            return v;
        }
    }

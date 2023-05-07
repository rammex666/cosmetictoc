package org.rammex.cosmetictoc.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.rammex.cosmetictoc.Cosmetictoc;

public class Effects {

    public static int firewalk;
    public static int totem;

    public static int burn;

    public static int heart;

    public static int juke;

    public static int soulwalk;

    public static int soulcolier;

    public static int enchantt;

    public static int bubble;

    public static int combat;
    public static void firewalkeffect(Player player){
        firewalk = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cosmetictoc.getInstance(), new Runnable(){
            @Override
            public void run() {
                player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 5, 0.125, 0, 0.125, 0.1);
            }
        } ,0, 2);


    }

    public static void burnwalkeffect(Player player){
        burn = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cosmetictoc.getInstance(), new Runnable(){
            @Override
            public void run() {
                player.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, player.getLocation(), 5, 0.125, 0, 0.125, 0.1);
            }
        } ,0, 2);


    }

    public static void totemeffect(Player player){
        totem = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cosmetictoc.getInstance(), new Runnable(){

            double var = 0;
            Location loc, first, second;
            @Override
            public void run() {
                var += Math.PI / 16;

                loc = player.getLocation();
                first = loc.clone().add(Math.cos(var), Math.sin(var)+1, Math.sin(var));
                second = loc.clone().add(Math.cos(var+Math.PI), Math.sin(var)+1, Math.sin(var + Math.PI));

                player.getWorld().spawnParticle(Particle.TOTEM, first, 0);
                player.getWorld().spawnParticle(Particle.TOTEM, second, 0);
            }
        },0,1);
    }


    public static void hearteffect(Player player){
        heart = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cosmetictoc.getInstance(), new Runnable(){

            double var = 0;
            Location loc, first, second;
            @Override
            public void run() {
                var += Math.PI / 16;

                loc = player.getLocation();
                first = loc.clone().add(Math.cos(var), Math.sin(var)+1, Math.sin(var));
                second = loc.clone().add(Math.cos(var+Math.PI), Math.sin(var)+1, Math.sin(var + Math.PI));

                player.getWorld().spawnParticle(Particle.HEART, first, 0);
                player.getWorld().spawnParticle(Particle.HEART, second, 0);
            }
        },0,1);
    }

    public static void jukeeffect(Player player){
        juke = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cosmetictoc.getInstance(), new Runnable(){

            double var = 0;
            Location loc, first;
            @Override
            public void run() {
                var += Math.PI / 16;

                loc = player.getLocation();
                first = loc.clone().add(Math.cos(var), Math.sin(var)+1, Math.sin(var));

                player.getWorld().spawnParticle(Particle.NOTE, first, 0);
            }
        },0,1);
    }

    public static void soulwalkeffect(Player player){
        soulwalk = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cosmetictoc.getInstance(), new Runnable(){
            @Override
            public void run() {
                player.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, player.getLocation(), 5, 0.125, 0, 0.125, 0.1);
            }
        } ,0, 2);


    }


    public static void soul(Player player){
        soulcolier = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cosmetictoc.getInstance(), new Runnable(){

            double var = 0;
            Location loc, first, second;
            @Override
            public void run() {
                var += Math.PI / 16;

                loc = player.getLocation();
                first = loc.clone().add(Math.cos(var), Math.sin(var)+1, Math.sin(var));
                second = loc.clone().add(Math.cos(var+Math.PI), Math.sin(var)+1, Math.sin(var + Math.PI));

                player.getWorld().spawnParticle(Particle.SOUL, first, 0);
                player.getWorld().spawnParticle(Particle.SOUL, second, 0);
            }
        },0,1);
    }

    public static void enchant(Player player){
        enchantt = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cosmetictoc.getInstance(), new Runnable(){

            double var = 0;
            Location loc, first, second;
            @Override
            public void run() {
                var += Math.PI / 16;

                loc = player.getLocation();
                first = loc.clone().add(Math.cos(var), Math.sin(var)+1, Math.sin(var));
                second = loc.clone().add(Math.cos(var+Math.PI), Math.sin(var)+1, Math.sin(var + Math.PI));

                player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, first, 0);
                player.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, second, 0);
            }
        },0,1);
    }

    public static void bubbble(Player player){
        bubble = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cosmetictoc.getInstance(), new Runnable(){

            @Override
            public void run() {
                player.getWorld().spawnParticle(Particle.WATER_SPLASH, player.getLocation(), 5, 0.125, 0, 0.125, 0.1);
            }
        },0,1);
    }

    public static void combatant(Player player){
        combat = Bukkit.getScheduler().scheduleSyncRepeatingTask(Cosmetictoc.getInstance(), new Runnable(){

            @Override
            public void run() {
                player.getWorld().spawnParticle(Particle.CRIT, player.getLocation(), 5, 0.125, 0, 0.125, 0.1);
            }
        },0,1);
    }
}

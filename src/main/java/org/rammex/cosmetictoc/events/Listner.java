package org.rammex.cosmetictoc.events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.rammex.cosmetictoc.Cosmetictoc;

import static org.rammex.cosmetictoc.events.Effects.*;


public class Listner implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player  = event.getPlayer();
        player.getInventory().clear();


        ItemStack cosmecompa = new ItemStack(Material.COMPASS, 1);
        ItemMeta customM = cosmecompa.getItemMeta();
        customM.setDisplayName(ChatColor.AQUA+"Cosmetics");
        cosmecompa.setItemMeta(customM);
        player.getInventory().setItem(8, cosmecompa);
        player.updateInventory();
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it = event.getItem();

        if(it == null) return;


        if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA+"Cosmetics")){
            Inventory inv = Bukkit.createInventory(null, 27, "§aCosmétics");
            inv.setItem(11, getItem(Material.LEATHER_CHESTPLATE, "§6Tenues"));
            inv.setItem(13, getItem(Material.NETHER_STAR, "§fParticules"));
            inv.setItem(26, getItem(Material.BARRIER, "§4Retirer Cosmetics"));
            player.openInventory(inv);
        }
    }


    @EventHandler
    public void onClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        Player player =(Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if(player.isOp()){
            event.setCancelled(false);
        } else{
            event.setCancelled(true);
        }


        if(current == null) return;

        if(event.getView().getTitle().equalsIgnoreCase("§aCosmétics")) {

            event.setCancelled(true);

            if(current.getType() == Material.LEATHER_CHESTPLATE){
                player.closeInventory();
                Tenue(player);
            }

            if(current.getType() == Material.NETHER_STAR){
                player.closeInventory();
                particules(player);
            }
            if(current.getType() == Material.BARRIER) {
                player.closeInventory();
                player.getInventory().setHelmet(null);
                player.getInventory().setChestplate(null);
                player.getInventory().setBoots(null);
                player.getInventory().setLeggings(null);
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "effect clear "+  player.getName());
                Bukkit.getScheduler().cancelTask(firewalk);
                Bukkit.getScheduler().cancelTask(totem);
            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§fParticules")){
            event.setCancelled(true);
            if(current.getType() == Material.TOTEM_OF_UNDYING){
                totemeffect(player);
                player.closeInventory();
            }

            if(current.getType() == Material.FLINT_AND_STEEL){
                firewalkeffect(player);
                player.closeInventory();
            }

            if(current.getType() == Material.BARRIER) {
                player.closeInventory();
                player.getInventory().setHelmet(null);
                player.getInventory().setChestplate(null);
                player.getInventory().setBoots(null);
                player.getInventory().setLeggings(null);
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "effect clear "+  player.getName());
                Bukkit.getScheduler().cancelTask(firewalk);
                Bukkit.getScheduler().cancelTask(totem);
            }

        }


        if(event.getView().getTitle().equalsIgnoreCase("§6Tenues")){

            event.setCancelled(true);

            if(current.getType() == Material.TURTLE_HELMET){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.TURTLE_HELMET, "§2Casque Tortue"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§2Plastron Tortue", Color.GREEN));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§2Chaussures Tortue", Color.GREEN));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§2Pentalon Tortue", Color.GREEN));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.GLASS){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.GLASS, "§fCasque Astronaute"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§fPlastron Astronaute", Color.WHITE));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§fChaussures Astronaute", Color.WHITE));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§fPentalon Astronaute", Color.WHITE));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.TNT){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.TNT, "§cCasque Bombe-Man"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§cPlastron Bombe-Man", Color.RED));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§cChaussures Bombe-Man", Color.RED));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§cPentalon Bombe-Man", Color.RED));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.BARRIER){
                player.closeInventory();
                player.getInventory().setHelmet(null);
                player.getInventory().setChestplate(null);
                player.getInventory().setBoots(null);
                player.getInventory().setLeggings(null);
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "effect clear "+  player.getName());
                Bukkit.getScheduler().cancelTask(firewalk);
                Bukkit.getScheduler().cancelTask(totem);
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.ZOMBIE_HEAD){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.ZOMBIE_HEAD, "§cCasque Zombie"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§cPlastron Zombie", Color.fromBGR(241,  208, 116)));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§cChaussures Zombie", Color.GRAY));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§cPentalon Zombie", Color.fromBGR(186, 142, 58)));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.JUNGLE_LEAVES){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.JUNGLE_LEAVES, "§aCasque Tree-Man"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§aPlastron Tree-Man", Color.fromBGR(58, 242, 75)));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§aChaussures Tree-Man", Color.fromBGR(58, 242, 75)));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§aPentalon Tree-Man", Color.fromBGR(58, 242, 75)));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

        }

    }

    public ItemStack getItem(Material material, String customName) {
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if (customName != null) customM.setDisplayName(customName);
        it.setItemMeta(customM);
        return it;
    }

    public ItemStack getLeather(Material material, String customName, Color color){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
        meta.setDisplayName(customName);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
        leatherArmorMeta.setColor(color);
        item.setItemMeta(leatherArmorMeta);
        return item;
    }

    public void Tenue(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§6Tenues");

        inv.setItem(11, getItem(Material.TURTLE_HELMET, "§2Tortue"));
        inv.setItem(13, getItem(Material.GLASS, "§fAstronaute"));
        inv.setItem(15, getItem(Material.TNT, "§cBombe-Man"));
        inv.setItem(21, getItem(Material.ZOMBIE_HEAD, "§3Zombie"));
        inv.setItem(23, getItem(Material.JUNGLE_LEAVES, "§aTree-Man"));
        inv.setItem(26, getItem(Material.BARRIER, "§4Retirer Cosmetics"));
        player.openInventory(inv);
    }


    public void particules(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§fParticules");
        inv.setItem(11, getItem(Material.TOTEM_OF_UNDYING, "§6Totem"));
        inv.setItem(13, getItem(Material.FLINT_AND_STEEL, "§cMarche du Feu"));
        inv.setItem(26, getItem(Material.BARRIER, "§4Retirer Cosmetics"));
        player.openInventory(inv);
    }
}

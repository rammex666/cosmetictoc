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
            main(player);
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

        if(event.getView().getTitle().equalsIgnoreCase("§a§l✭ Cosmétics ✭")) {

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
                Bukkit.getScheduler().cancelTask(burn);
                Bukkit.getScheduler().cancelTask(heart);
                Bukkit.getScheduler().cancelTask(juke);
                Bukkit.getScheduler().cancelTask(soulwalk);
                Bukkit.getScheduler().cancelTask(soulcolier);
                Bukkit.getScheduler().cancelTask(enchantt);
                Bukkit.getScheduler().cancelTask(bubble);
                Bukkit.getScheduler().cancelTask(combat);
            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§f§l★ Particules Page 1 ★")){
            event.setCancelled(true);
            if(current.getType() == Material.TOTEM_OF_UNDYING){
                totemeffect(player);
                player.closeInventory();
            }

            if(current.getType() == Material.FLINT_AND_STEEL){
                firewalkeffect(player);
                player.closeInventory();
            }

            if(current.getType() == Material.BLAZE_POWDER){
                burnwalkeffect(player);
                player.closeInventory();
            }

            if(current.getType() == Material.APPLE){
                hearteffect(player);
                player.closeInventory();
            }

            if(current.getType() == Material.JUKEBOX){
                jukeeffect(player);
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
                Bukkit.getScheduler().cancelTask(burn);
                Bukkit.getScheduler().cancelTask(heart);
                Bukkit.getScheduler().cancelTask(juke);
                Bukkit.getScheduler().cancelTask(soulwalk);
                Bukkit.getScheduler().cancelTask(soulcolier);
                Bukkit.getScheduler().cancelTask(enchantt);
                Bukkit.getScheduler().cancelTask(bubble);
                Bukkit.getScheduler().cancelTask(combat);
            }

            if(current.getType() == Material.OAK_BUTTON){
                player.closeInventory();
                Particule2(player);

            }

            if(current.getType() == Material.RED_CONCRETE){
                player.closeInventory();
                main(player);

            }

        }


        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Tenues Page 1 ✯")){

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
                Bukkit.getScheduler().cancelTask(burn);
                Bukkit.getScheduler().cancelTask(heart);
                Bukkit.getScheduler().cancelTask(juke);
                Bukkit.getScheduler().cancelTask(soulwalk);
                Bukkit.getScheduler().cancelTask(soulcolier);
                Bukkit.getScheduler().cancelTask(enchantt);
                Bukkit.getScheduler().cancelTask(bubble);
                Bukkit.getScheduler().cancelTask(combat);
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

            if(current.getType() == Material.OAK_BUTTON){
                player.closeInventory();
                Tenue2(player);

            }

            if(current.getType() == Material.RED_CONCRETE){
                player.closeInventory();
                main(player);

            }

        }

        if(event.getView().getTitle().equalsIgnoreCase("§6§l✯ Tenues Page 2 ✯")){
            event.setCancelled(true);

            if(current.getType() == Material.HAY_BLOCK){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.HAY_BLOCK, "§2Casque Paille"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§2Plastron Paille", Color.YELLOW));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§2Chaussures Paille", Color.YELLOW));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§2Pentalon Paille", Color.YELLOW));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.HAY_BLOCK){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.HAY_BLOCK, "§2Casque Paille"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§2Plastron Paille", Color.YELLOW));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§2Chaussures Paille", Color.YELLOW));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§2Pentalon Paille", Color.YELLOW));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.JACK_O_LANTERN){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.JACK_O_LANTERN, "§2Casque Halloween"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§2Plastron Halloween", Color.ORANGE));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§2Chaussures Halloween", Color.BLACK));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§2Pentalon Halloween", Color.ORANGE));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.BOOKSHELF){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.BOOKSHELF, "§2Casque Magicien"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§2Plastron Magicien", Color.BLUE));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§2Chaussures Magicien", Color.BLUE));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§2Pentalon Magicien", Color.BLUE));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.WITHER_SKELETON_SKULL){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.WITHER_SKELETON_SKULL, "§2Casque Démon"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§2Plastron Démon", Color.RED));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§2Chaussures Démon", Color.BLACK));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§2Pentalon Démon", Color.RED));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.PINK_CONCRETE){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.PINK_CONCRETE, "§2Casque Multicolore"));
                player.getInventory().setChestplate(getLeather(Material.LEATHER_CHESTPLATE, "§2Plastron Multicolore", Color.YELLOW));
                player.getInventory().setBoots(getLeather(Material.LEATHER_BOOTS, "§2Chaussures Multicolore", Color.BLUE));
                player.getInventory().setLeggings(getLeather(Material.LEATHER_LEGGINGS, "§2Pentalon Multicolore", Color.GREEN));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

            if(current.getType() == Material.BIRCH_BUTTON){
                player.closeInventory();
                Tenue(player);

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
                Bukkit.getScheduler().cancelTask(burn);
                Bukkit.getScheduler().cancelTask(heart);
                Bukkit.getScheduler().cancelTask(juke);
                Bukkit.getScheduler().cancelTask(soulwalk);
                Bukkit.getScheduler().cancelTask(soulcolier);
                Bukkit.getScheduler().cancelTask(enchantt);
                Bukkit.getScheduler().cancelTask(bubble);
                Bukkit.getScheduler().cancelTask(combat);
            }
        }

        if(event.getView().getTitle().equalsIgnoreCase("§f§l★ Particules Page 2 ★")){
            event.setCancelled(true);

            if(current.getType() == Material.BIRCH_BUTTON){
                player.closeInventory();
                particules(player);

            }

            if(current.getType() == Material.SOUL_LANTERN){
                player.closeInventory();
                soulwalkeffect(player);
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
                Bukkit.getScheduler().cancelTask(burn);
                Bukkit.getScheduler().cancelTask(heart);
                Bukkit.getScheduler().cancelTask(juke);
                Bukkit.getScheduler().cancelTask(soulwalk);
                Bukkit.getScheduler().cancelTask(soulcolier);
                Bukkit.getScheduler().cancelTask(enchantt);
                Bukkit.getScheduler().cancelTask(bubble);
                Bukkit.getScheduler().cancelTask(combat);
            }
            if(current.getType() == Material.SOUL_CAMPFIRE){
                player.closeInventory();
                soul(player);
            }

            if(current.getType() == Material.ENCHANTED_BOOK){
                player.closeInventory();
                enchant(player);
            }

            if(current.getType() == Material.WATER_BUCKET){
                player.closeInventory();
                bubbble(player);
            }

            if(current.getType() == Material.STONE_SWORD){
                player.closeInventory();
                combatant(player);
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
        Inventory inv = Bukkit.createInventory(null, 36, "§6§l✯ Tenues Page 1 ✯");

        inv.setItem(11, getItem(Material.TURTLE_HELMET, "§2Tortue"));
        inv.setItem(13, getItem(Material.GLASS, "§fAstronaute"));
        inv.setItem(15, getItem(Material.TNT, "§cBombe-Man"));
        inv.setItem(21, getItem(Material.ZOMBIE_HEAD, "§3Zombie"));
        inv.setItem(23, getItem(Material.JUNGLE_LEAVES, "§aTree-Man"));
        inv.setItem(35, getItem(Material.BARRIER, "§4Retirer Cosmetics"));
        inv.setItem(34, getItem(Material.OAK_BUTTON, "§8Page suivante"));
        inv.setItem(27, getItem(Material.RED_CONCRETE, "§cRetour"));
        player.openInventory(inv);
    }

    public void Tenue2(Player player){
        Inventory inv = Bukkit.createInventory(null, 36, "§6§l✯ Tenues Page 2 ✯");

        inv.setItem(27, getItem(Material.BIRCH_BUTTON, "§8Page précedente"));
        inv.setItem(35, getItem(Material.BARRIER, "§4Retirer Cosmetics"));
        inv.setItem(11, getItem(Material.HAY_BLOCK, "§ePaille-Man"));
        inv.setItem(13, getItem(Material.JACK_O_LANTERN, "§6Haloween"));
        inv.setItem(15, getItem(Material.BOOKSHELF, "§9Magicien"));
        inv.setItem(21, getItem(Material.WITHER_SKELETON_SKULL, "§cDémon"));
        inv.setItem(23, getItem(Material.PINK_CONCRETE, "§dMulticolor"));
        player.openInventory(inv);
    }

    public void Particule2(Player player){
        Inventory inv = Bukkit.createInventory(null, 36, "§f§l★ Particules Page 2 ★");

        inv.setItem(27, getItem(Material.BIRCH_BUTTON, "§8Page précedente"));
        inv.setItem(35, getItem(Material.BARRIER, "§4Retirer Cosmetics"));
        inv.setItem(11, getItem(Material.SOUL_LANTERN, "§9Marche des enfers"));
        inv.setItem(13, getItem(Material.SOUL_CAMPFIRE, "§9Colier des enfers"));
        inv.setItem(15, getItem(Material.ENCHANTED_BOOK, "§3Magicien"));
        inv.setItem(21, getItem(Material.WATER_BUCKET, "§1Marche de l'eau"));
        inv.setItem(23, getItem(Material.STONE_SWORD, "§1Marche du combatant"));
        player.openInventory(inv);
    }

    public void particules(Player player){
        Inventory inv = Bukkit.createInventory(null, 36, "§f§l★ Particules Page 1 ★");
        inv.setItem(11, getItem(Material.TOTEM_OF_UNDYING, "§6Totem"));
        inv.setItem(13, getItem(Material.FLINT_AND_STEEL, "§cMarche du Feu"));
        inv.setItem(15, getItem(Material.BLAZE_POWDER, "§7Fumé"));
        inv.setItem(21, getItem(Material.APPLE, "§4Coeur"));
        inv.setItem(23, getItem(Material.JUKEBOX, "§eMusique"));
        inv.setItem(35, getItem(Material.BARRIER, "§4Retirer Cosmetics"));
        inv.setItem(27, getItem(Material.RED_CONCRETE, "§cRetour"));
        inv.setItem(34, getItem(Material.OAK_BUTTON, "§8Page suivante"));
        player.openInventory(inv);
    }

    public void main(Player player){
        Inventory inv = Bukkit.createInventory(null, 27, "§a§l✭ Cosmétics ✭");
        inv.setItem(11, getItem(Material.LEATHER_CHESTPLATE, "§6Tenues"));
        inv.setItem(13, getItem(Material.NETHER_STAR, "§fParticules"));
        inv.setItem(26, getItem(Material.BARRIER, "§4Retirer Cosmetics"));
        player.openInventory(inv);
    }
}

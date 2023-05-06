package org.rammex.cosmetictoc.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

            inv.setItem(11, getItem(Material.TURTLE_HELMET, "§2Tortue"));

            player.openInventory(inv);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Inventory inv = event.getInventory();
        Player player =(Player) event.getWhoClicked();
        ItemStack current = event.getCurrentItem();

        if(current == null) return;

        if(event.getView().getTitle().equalsIgnoreCase("§aCosmétics")){

            event.setCancelled(true);

            if(current.getType() == Material.TURTLE_HELMET){
                player.closeInventory();
                player.getInventory().setHelmet(getItem(Material.TURTLE_HELMET, "§2Casque Tortue"));
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamemode survivale");
            }

        }

    }

    public ItemStack getItem(Material material, String customName){
        ItemStack it = new ItemStack(material);
        ItemMeta customM = it.getItemMeta();
        if(customName != null) customM.setDisplayName(customName);
        it.setItemMeta(customM);
        return it;
    }
}

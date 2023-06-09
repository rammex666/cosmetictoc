package org.rammex.cosmetictoc;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.rammex.cosmetictoc.events.Listner;

import static org.bukkit.Bukkit.getPluginManager;

public final class Cosmetictoc extends JavaPlugin {

    PluginDescriptionFile pdf = this.getDescription(); //Gets plugin.yml

    public static Cosmetictoc instance;

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("-----------------------");
        getLogger().info("       Cosmetictoc   ");
        getLogger().info("          On");
        getLogger().info("      "+pdf.getVersion());
        getLogger().info("-----------------------");
        getPluginManager().registerEvents(new Listner(), this);


    }

    @Override
    public void onDisable() {
        getLogger().info("-----------------------");
        getLogger().info("       Cosmetictoc   ");
        getLogger().info("          Off");
        getLogger().info("      "+pdf.getVersion());
        getLogger().info("-----------------------");

    }

    public static Cosmetictoc getInstance(){
        return instance;
    }
}

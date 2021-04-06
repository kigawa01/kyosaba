package net.kigawa.plugin.kyosaba;

import net.kigawa.plugin.kyosaba.config.Kyosabaconfig;
import net.kigawa.plugin.kyosaba.main.chiar.listner;
import net.kigawa.plugin.kyosaba.main.portal.portallistner;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kyosaba extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pluginManager=getServer().getPluginManager();
        pluginManager.registerEvents(new listner(this),this);
        pluginManager.registerEvents(new portallistner(this),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

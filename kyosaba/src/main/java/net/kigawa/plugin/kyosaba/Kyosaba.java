package net.kigawa.plugin.kyosaba;

import net.kigawa.plugin.kyosaba.main.chiar.ChairListener;
import net.kigawa.plugin.kyosaba.main.portal.CommandPortalCreate;
import net.kigawa.plugin.kyosaba.main.portal.PortalListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Kyosaba extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        PluginManager pluginManager=getServer().getPluginManager();
        pluginManager.registerEvents(new ChairListener(this),this);
        pluginManager.registerEvents(new PortalListener(this),this);
        this.getCommand("portalCreate").setExecutor(new CommandPortalCreate());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public int getConfigVersion(){
        return 1;
    }
}

package net.kigawa.plugin.kyosaba.main.portal;

import net.kigawa.plugin.kyosaba.Kyosaba;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class portallistner implements Listener{
    private final Kyosaba plugin;
    public portallistner(Kyosaba plg){
        plugin=plg;
    }
    @EventHandler
    public void gate(PlayerMoveEvent event){

    }
}

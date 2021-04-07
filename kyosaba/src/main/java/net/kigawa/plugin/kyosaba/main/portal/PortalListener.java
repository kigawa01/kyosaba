package net.kigawa.plugin.kyosaba.main.portal;

import net.kigawa.plugin.kyosaba.Kyosaba;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PortalListener implements Listener{
    private final Kyosaba plugin;
    public PortalListener(Kyosaba kyosaba){
        plugin=kyosaba;
    }
    @EventHandler
    public void moveEvent(PlayerMoveEvent event){

    }
}

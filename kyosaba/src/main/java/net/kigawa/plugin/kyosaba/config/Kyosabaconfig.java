package net.kigawa.plugin.kyosaba.config;

import net.kigawa.plugin.kyosaba.Kyosaba;

public class Kyosabaconfig {
    private final Kyosaba plugin;
    public Kyosabaconfig(Kyosaba kyosaba){
        plugin=kyosaba;
        plugin.getConfig().addDefault("youAreAwesome", true);
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
    }
}

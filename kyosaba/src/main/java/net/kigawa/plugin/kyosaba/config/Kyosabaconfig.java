package net.kigawa.plugin.kyosaba.config;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.sql.Sqlconfig;
import net.kigawa.plugin.kyosaba.sql.Sqlconfigdata;

public class Kyosabaconfig {
    private final Kyosaba plugin;
    Sqlconfigdata sqlconfigdata;
    public Kyosabaconfig(Kyosaba kyosaba){
        plugin=kyosaba;
        plugin.getConfig().addDefault("youAreAwesome", true);
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        sqlconfigdata=new Sqlconfig(plugin).getSqlconfigdata();
    }
    public Sqlconfigdata getSqlconfigdata(){
        return sqlconfigdata;
    }
}

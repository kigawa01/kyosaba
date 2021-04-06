package net.kigawa.plugin.kyosaba.config;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.sql.SqlConfig;
import net.kigawa.plugin.kyosaba.sql.Sqlconfigdata;

public class KyosabaConfig {
    private final Kyosaba plugin;
    Sqlconfigdata sqlconfigdata;
    public KyosabaConfig(Kyosaba kyosaba){
        plugin=kyosaba;
        plugin.getConfig().addDefault("youAreAwesome", true);
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        sqlconfigdata=new SqlConfig(plugin).getSqlconfigdata();
    }
    public Sqlconfigdata getSqlconfigdata(){
        return sqlconfigdata;
    }
}

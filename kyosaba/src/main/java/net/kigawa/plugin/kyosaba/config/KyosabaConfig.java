package net.kigawa.plugin.kyosaba.config;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.sql.SqlConfig;
import net.kigawa.plugin.kyosaba.sql.SqlConfigData;

public class KyosabaConfig {
    private final Kyosaba plugin;
    SqlConfigData sqlconfigdata;
    public KyosabaConfig(Kyosaba kyosaba){
        plugin=kyosaba;
        plugin.getConfig().addDefault("version", plugin.getConfigVersion());
        plugin.getConfig().options().copyDefaults(true);
        plugin.saveConfig();
        sqlconfigdata=new SqlConfig(plugin).getSqlconfigdata();
    }
    public SqlConfigData getSqlconfigdata(){
        return sqlconfigdata;
    }
    public int getVersion(){
        return plugin.getConfig().getInt("version");

    }
}

package net.kigawa.plugin.kyosaba.config;

import net.kigawa.plugin.kyosaba.Kyosaba;

public class Config {
    Kyosaba plugin;
    KyosabaConfig kyosabaConfig;
    public Config(Kyosaba kyosaba){
        plugin=kyosaba;
        kyosabaConfig=new KyosabaConfig(plugin);
        if(plugin.getConfigVersion()!= kyosabaConfig.getVersion()){

        }
    }
}

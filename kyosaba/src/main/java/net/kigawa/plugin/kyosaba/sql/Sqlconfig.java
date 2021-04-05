package net.kigawa.plugin.kyosaba.sql;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.config.mkconfig;

import java.io.File;

public class Sqlconfig {
    public Sqlconfig(Kyosaba plugin){
        String name="sql";
        String path = "./plugins/kyosaba/" + name + "/config.yml";
        File file = new File(path);
        if(!file.exists()){
            Sqlconfigdata sqlconfigdata=new Sqlconfigdata();
            new mkconfig(plugin,sqlconfigdata);
        }
    }
}

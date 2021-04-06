package net.kigawa.plugin.kyosaba.config;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.yml.ConvertYml;

import java.io.File;
import java.io.FileWriter;

public class MkConfig {
    String stringConfig;
    Kyosaba plugin;
    public MkConfig(Kyosaba kyosaba, Data data){
        plugin=kyosaba;
            stringConfig=new ConvertYml().ToString(data);
    }
    public void writeconfig(File file,String path){
        try {
            if(file.mkdirs()){
                plugin.getLogger().info("create new config");
            }
            FileWriter fileWriter=new FileWriter(path);
            fileWriter.write(stringConfig);
            fileWriter.close();
        }catch (Exception e){
            plugin.getLogger().info(e.toString());
        }
    }
}

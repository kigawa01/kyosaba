package net.kigawa.plugin.kyosaba.config;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.yml.Convertyml;

import java.io.File;
import java.io.FileWriter;

public class Mkconfig {
    String stringconfig;
    Kyosaba plugin;
    public Mkconfig(Kyosaba kyosaba, Data data){
        plugin=kyosaba;
            stringconfig=new Convertyml().Tostring(data);
    }
    public void writeconfig(File file,String path){
        try {
            if(file.mkdirs()){
                plugin.getLogger().info("create new config");
            }
            FileWriter fileWriter=new FileWriter(path);
            fileWriter.write(stringconfig);
            fileWriter.close();
        }catch (Exception e){
            plugin.getLogger().info(e.toString());
        }
    }
}

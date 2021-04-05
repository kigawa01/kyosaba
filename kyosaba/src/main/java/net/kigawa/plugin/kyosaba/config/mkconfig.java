package net.kigawa.plugin.kyosaba.config;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.yml.Convertyml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class mkconfig {
    public mkconfig(Kyosaba plugin,Data data){
        String name=data.getName();;
        try {
            String path = "./plugins/kyosaba/" + name;
            String pathfile=path+ "/config.yml";
            File file = new File(path);
            file.mkdirs();
            File filepath=new File(pathfile);
            FileWriter config = new FileWriter(filepath);
            String stringconfig=new Convertyml().Tostring(data);
            config.write(stringconfig);
            config.close();
        }catch (IOException e){
            plugin.getLogger().info(e.toString());
        }
    }
}

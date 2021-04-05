package net.kigawa.plugin.kyosaba.sql;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.config.Data;
import net.kigawa.plugin.kyosaba.config.Mkconfig;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Sqlconfig {
    Sqlconfigdata sqlconfigdata;
    Kyosaba plugin;
    public Sqlconfig(Kyosaba kyosaba){
        plugin=kyosaba;
        String name="sql";
        String filepath = "./plugins/kyosaba/" + name;
        String path=filepath+ "/config.yml";
        File file = new File(filepath);
        if(!file.exists()){
            Sqlconfigdata sqlconfigdata1=new Sqlconfigdata();
            Mkconfig mkconfig=new Mkconfig(plugin,sqlconfigdata1);
            mkconfig.writeconfig(file,path);
        }
        File config=new File(path);
        String strconfig;
        try {
            FileReader fileReader=new FileReader(config);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            strconfig = null;
            String toconfig;
            String buffer;
            while ((buffer=bufferedReader.readLine())!=null) {
                toconfig=strconfig;
                strconfig=toconfig+"/n"+buffer;
            }
        }catch (Exception e){
            plugin.getLogger().info(e.toString());
            strconfig=null;
        }
        Yaml yaml=new Yaml();
        sqlconfigdata=yaml.load(strconfig);
    }
    public Sqlconfigdata getSqlconfigdata(){
        return sqlconfigdata;
    }
}

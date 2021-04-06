package net.kigawa.plugin.kyosaba.sql;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.config.MkConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SqlConfig {
    SqlConfigData sqlconfigdata;
    Kyosaba plugin;
    public SqlConfig(Kyosaba kyosaba){
        plugin=kyosaba;
        String name="sql";
        String filepath = "./plugins/kyosaba/" + name;
        String path=filepath+ "/config.yml";
        File file = new File(filepath);
        if(!file.exists()){
            SqlConfigData sqlConfigData1=new SqlConfigData();
            MkConfig mkconfig=new MkConfig(plugin,sqlConfigData1);
            mkconfig.writeconfig(file,path);
        }
        File config=new File(path);
        String strConfig;
        try {
            FileReader fileReader=new FileReader(config);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            strConfig = null;
            String toConfig;
            String buffer;
            while ((buffer=bufferedReader.readLine())!=null) {
                toConfig=strConfig;
                strConfig=toConfig+"/n"+buffer;
            }
        }catch (Exception e){
            plugin.getLogger().info(e.toString());
            strConfig=null;
        }
        Yaml yaml=new Yaml();
        sqlconfigdata=yaml.load(strConfig);
    }
    public SqlConfigData getSqlconfigdata(){
        return sqlconfigdata;
    }
}

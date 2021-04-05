package net.kigawa.plugin.kyosaba.yml;

import net.kigawa.plugin.kyosaba.config.Data;
import org.yaml.snakeyaml.Yaml;

public class Convertyml {
    public Convertyml(){

    }
    public String Tostring(Data data){
        Yaml yaml=new Yaml();
        return yaml.dumpAsMap(data);
    }
}

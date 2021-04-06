package net.kigawa.plugin.kyosaba.yml;

import net.kigawa.plugin.kyosaba.config.Data;
import org.yaml.snakeyaml.Yaml;

public class ConvertYml {
    public ConvertYml(){

    }
    public String ToString(Data data){
        Yaml yaml=new Yaml();
        return yaml.dumpAsMap(data);
    }
}

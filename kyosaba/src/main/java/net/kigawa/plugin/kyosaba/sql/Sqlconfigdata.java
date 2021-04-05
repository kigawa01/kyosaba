package net.kigawa.plugin.kyosaba.sql;

import com.mysql.management.util.Str;
import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.config.Data;

public class Sqlconfigdata implements Data {
    String name;
    String host;
    int port;
    String database;
    String user;
    String password;
    public Sqlconfigdata(){
        name="sql";
        host="localhost";
        port=3306;
        database="databasename";
        user="username";
        password="password";
    }
    @Override
    public void data() {
    }
    @Override
    public String getName() { return name;}
    @Override
    public void setName(String string){name=string;}
    public String getHost(){return host;}
    public void setHost(String string){host=string;}
    public int getPort(){return port;}
    public void setPort(int intport){port=intport;}
    public String getDatabase(){return database;}
    public void setDatabase(String string){database=string;}
    public String getUser(){return user;}
    public void setUser(String string){user=string;}
    public String getPassword(){return password;}
    public void setPassword(String string){password=string;}
}

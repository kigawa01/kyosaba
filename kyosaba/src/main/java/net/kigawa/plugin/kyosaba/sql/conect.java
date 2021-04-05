package net.kigawa.plugin.kyosaba.sql;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.config.Kyosabaconfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conect {
    Kyosaba plugin;
    Connection connection;
    public conect(Kyosabaconfig kyosabaconfig, Kyosaba kyosaba){
        Sqlconfigdata sqlconfigdata=kyosabaconfig.getSqlconfigdata();
        plugin=kyosaba;
        String host=sqlconfigdata.getHost();
        int port=sqlconfigdata.getPort();
        String database=sqlconfigdata.getDatabase();
        String user=sqlconfigdata.getUser();
        String password=sqlconfigdata.getPassword();
        String option= sqlconfigdata.getOption();
        String url="jdbc:mysql://"+host+":"+port+"/"+database+"?user="+user+"&password="+password+option;
        try {
            connection=DriverManager.getConnection(url);
        }catch (SQLException e){
            plugin.getLogger().info(e.toString());
            connection=null;
        }
    }
    public void connection(){
    }
}

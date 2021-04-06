package net.kigawa.plugin.kyosaba.sql;

import net.kigawa.plugin.kyosaba.Kyosaba;
import net.kigawa.plugin.kyosaba.config.KyosabaConfig;

import java.sql.*;

public class Connect {
    String url;
    Kyosaba plugin;
    public Connect(KyosabaConfig kyosabaconfig, Kyosaba kyosaba){
        Sqlconfigdata sqlconfigdata=kyosabaconfig.getSqlconfigdata();
        plugin=kyosaba;
        String host=sqlconfigdata.getHost();
        int port=sqlconfigdata.getPort();
        String database=sqlconfigdata.getDatabase();
        String user=sqlconfigdata.getUser();
        String password=sqlconfigdata.getPassword();
        String option= sqlconfigdata.getOption();
        url="jdbc:mysql://"+host+":"+port+"/"+database+"?user="+user+"&password="+password+option;
    }
    public void setData(DataSql datasql){
        try {
            Connection connection=DriverManager.getConnection(url);
            Statement statement=connection.createStatement();
            DatabaseMetaData databaseMetaData=connection.getMetaData();

            String table=datasql.getTable();
            String[] columns=datasql.getColumns();
            String[] type=datasql.getType();

            ResultSet resultSetTb=databaseMetaData.getTables(null,null,table,null);
            String createTableColumn="";
            if(!resultSetTb.next()){
                String toCreateTable;
                for(int i=0;i<columns.length;i++){
                    toCreateTable=createTableColumn+columns[i]+" "+type[i]+",";
                    createTableColumn=toCreateTable;
                }
                StringBuilder createTableColumnBuilder=new StringBuilder(createTableColumn);
                createTableColumnBuilder.setLength(createTableColumnBuilder.length()-1);
                createTableColumn=createTableColumnBuilder.toString();
                String createTable="CREATE TABLE "+table+" ("+createTableColumn+")";
                statement.executeUpdate(createTable);
            }
            resultSetTb.close();

            String[] values= datasql.getValue();
            String[] where= datasql.getWhere();
            String isData="SELECT "+where[1]+" FROM "+table+" WHERE "+where[1]+"="+where[2];
            ResultSet resultSetIsData=statement.executeQuery(isData);
            if(!resultSetIsData.next()){
                String column="";
                String toInsert;
                for(int i1=0;i1<columns.length;){
                    toInsert=column+columns[i1]+",";
                    column=toInsert;
                    i1++;
                }
                StringBuilder columnBuffer=new StringBuilder(column);
                columnBuffer.setLength(columnBuffer.length()-1);
                column=columnBuffer.toString();
                String value="";
                String toValue;
                for(int i2=0;i2< values.length;){
                    toValue=value+values[i2]+",";
                    value=toValue;
                    i2++;
                }
                StringBuilder valueBuffer=new StringBuilder(value);
                valueBuffer.setLength(valueBuffer.length()-1);
                value=valueBuffer.toString();
                String insert="INSERT INTO "+table+" ("+column+") VALUES ("+value+")";
                statement.executeUpdate(insert);
            }else {
                String update="";
                String toUpdate;
                for(int i3=0;i3< columns.length;i3++){
                    toUpdate=update+columns[i3]+"="+values[i3]+",";
                    update=toUpdate;
                }
                StringBuilder updateBuilder=new StringBuilder(update);
                updateBuilder.setLength(updateBuilder.length()-1);
                update=updateBuilder.toString();
                String updateStr="UPDATE "+table+" "+update+" WHERE "+where[1]+"="+where[2];
                statement.executeUpdate(updateStr);
            }
            resultSetIsData.close();

            statement.close();
            connection.close();
        }catch (SQLException e){
            plugin.getLogger().info(e.toString());
        }

    }
}

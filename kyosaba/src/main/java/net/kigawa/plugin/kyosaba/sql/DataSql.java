package net.kigawa.plugin.kyosaba.sql;

public interface DataSql {
    String[] getColumns();
    String getTable();
    String[] getType();
    String[] getWhere();
    String[] getValue();
    void setValue(String[] value);
}

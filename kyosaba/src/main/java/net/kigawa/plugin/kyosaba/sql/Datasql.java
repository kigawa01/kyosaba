package net.kigawa.plugin.kyosaba.sql;

public interface Datasql {
    String[] getColamns();
    String getTable();
    String[] getType();
    String[] getWhere();
    String[] getValue();
}

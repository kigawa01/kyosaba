package net.kigawa.plugin.kyosaba.main.portal;

import net.kigawa.plugin.kyosaba.sql.DataSql;

public class portalDataSql implements DataSql {
    @Override
    public String[] getColumns() {
        return new String[0];
    }

    @Override
    public String getTable() {
        return null;
    }

    @Override
    public String[] getType() {
        return new String[0];
    }

    @Override
    public String[] getWhere() {
        return new String[0];
    }

    @Override
    public String[] getValue() {
        return new String[0];
    }

    @Override
    public void setValue(String[] value) {

    }
}

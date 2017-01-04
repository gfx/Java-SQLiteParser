package com.github.gfx.sqlite_ddl;


import java.util.ArrayList;
import java.util.List;

public class SQLiteCreateTableStatement extends SQLiteStatement {

    public SQLiteName tableName;

    public final List<SQLiteColumn> columns = new ArrayList<>();

    public final List<SQLiteTableConstraint> constraints = new ArrayList<>();

    public SQLiteSelectStatement selectStatement;

    public SQLiteName getTableName() {
        return tableName;
    }

    public void setTableName(SQLiteName tableName) {
        this.tableName = tableName;
    }

    public SQLiteColumn getColumnAt(int i) {
        return columns.get(i);
    }

    public SQLiteTableConstraint getConstraintAt(int i) {
        return constraints.get(i);
    }
}

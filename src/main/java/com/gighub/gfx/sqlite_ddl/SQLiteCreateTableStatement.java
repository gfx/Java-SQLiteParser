package com.gighub.gfx.sqlite_ddl;


import java.util.ArrayList;
import java.util.List;

public class SQLiteCreateTableStatement extends SQLiteStatement {

    private SQLiteName tableName;

    private final List<SQLiteColumn> columns = new ArrayList<>();

    private final List<Constraint> constraints = new ArrayList<>();

    private SQLiteSelectStatement selectStatement;

    public SQLiteName getTableName() {
        return tableName;
    }

    public void setTableName(SQLiteName tableName) {
        this.tableName = tableName;
    }

    public List<SQLiteColumn> getColumns() {
        return columns;
    }

    public void addColumn(SQLiteColumn column) {
        this.columns.add(column);
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(Constraint constraint) {
        this.constraints.add(constraint);
    }

    public SQLiteSelectStatement getSelectStatement() {
        return selectStatement;
    }

    public void setSelectStatement(SQLiteSelectStatement selectStatement) {
        this.selectStatement = selectStatement;
    }

    public static class Constraint extends SQLiteNode {

        public SQLiteName name;
    }
}

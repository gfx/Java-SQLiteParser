package com.gighub.gfx.sqlite_ddl;


import java.util.ArrayList;
import java.util.List;

public class CreateTableStatement extends SQLiteComponent {

    private Name tableName;

    private final List<SQLiteColumn> columns = new ArrayList<>();

    private final List<Constraint> constraints = new ArrayList<>();

    private SelectStatement selectStatement;

    public Name getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = new Name(tableName);
    }

    public List<SQLiteColumn> getColumns() {
        return columns;
    }

    public void addColumns(SQLiteColumn column) {
        this.columns.add(column);
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(Constraint constraint) {
        this.constraints.add(constraint);
    }

    public SelectStatement getSelectStatement() {
        return selectStatement;
    }

    public void setSelectStatement(SelectStatement selectStatement) {
        this.selectStatement = selectStatement;
    }

    public static class Constraint extends SQLiteComponent {

        Name name;

        public Name getName() {
            return name;
        }
    }
}

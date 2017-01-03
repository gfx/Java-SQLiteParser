package com.github.gfx.sqlite_ddl;

import java.util.ArrayList;
import java.util.List;

public class SQLiteColumn extends SQLiteNode {

    private static final SQLiteName EMPTY_NAME = new SQLiteSimpleName("[null]");

    private SQLiteName name = EMPTY_NAME;

    private SQLiteType type;

    private final List<SQLiteColumnConstraint> constraints = new ArrayList<>();

    public SQLiteName getColumnName() {
        return name;
    }

    public void setName(SQLiteName name) {
        this.name = name;
    }

    public SQLiteType getType() {
        return type;
    }

    public void setType(SQLiteType type) {
        this.type = type;
    }

    public List<SQLiteColumnConstraint> getConstraints() {
        return constraints;
    }

    public void addConstraint(SQLiteColumnConstraint constraint) {
        this.constraints.add(constraint);
    }

    @Override
    public String toString() {
        StringBuilder columnSpecBuilder = new StringBuilder(name.toString());

        if (type != null) {
            columnSpecBuilder.append(' ');
            columnSpecBuilder.append(type);
        }

        for (SQLiteColumnConstraint constraint : constraints) {
            columnSpecBuilder.append(' ');
            columnSpecBuilder.append(constraint);
        }
        return columnSpecBuilder.toString();
    }

    public boolean isPrimaryKey() {
        for (SQLiteColumnConstraint constraint : constraints) {
            if (constraint.isPrimaryKey()) {
                return true;
            }
        }
        return false;
    }

    public SQLiteExpression getDefaultExpr() {
        for (SQLiteColumnConstraint constraint : constraints) {
            if (constraint.defaultExpr != null) {
                return constraint.defaultExpr;
            }
        }
        return null;
    }

    public SQLiteExpression getCheckExpr() {
        for (SQLiteColumnConstraint constraint : constraints) {
            if (constraint.checkExpr != null) {
                return constraint.checkExpr;
            }
        }
        return null;
    }
}

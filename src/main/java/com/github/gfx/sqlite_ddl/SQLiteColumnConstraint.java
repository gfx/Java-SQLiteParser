package com.github.gfx.sqlite_ddl;

public class SQLiteColumnConstraint extends SQLiteNode {

    public SQLiteName name;

    public SQLiteTokenList primaryKey;

    public SQLiteTokenList nullability;

    public SQLiteTokenList unique;

    public SQLiteExpression defaultExpr;

    public SQLiteExpression checkExpr;

    public SQLiteName collateName;

    public boolean isPrimaryKey() {
        return primaryKey != null;
    }

    public boolean isNullable() {
        if (isPrimaryKey()) {
            return false;
        } else if (nullability == null) {
            return true;
        }
        return !nullability.contains("not");
    }

    public boolean isUnique() {
        if (isPrimaryKey()) {
            return true;
        } else if (unique == null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        if (name != null) {
            s.append("constraint ");
            s.append(name);
            s.append(" ");
        }

        if (primaryKey != null) {
            s.append(primaryKey);
        } else if (defaultExpr != null) {
            s.append("default ");
            s.append(defaultExpr);
        } else if (checkExpr != null) {
            s.append("check");
            s.append("(");
            s.append(checkExpr);
            s.append(")");
        } else if (collateName != null) {
            s.append("collate ");
            s.append(collateName);
        }
        return s.toString();
    }
}

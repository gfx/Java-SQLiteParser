package com.gighub.gfx.sqlite_ddl;

public class SQLiteNameExpr extends SQLiteExpression {
    public final SQLiteName name;

    public SQLiteNameExpr(SQLiteName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteNameExpr that = (SQLiteNameExpr) o;

        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

package com.github.gfx.sqlite_ddl;

public class SQLiteBindParameterExpression extends SQLiteExpression {

    public String name;

    public SQLiteBindParameterExpression(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteBindParameterExpression that = (SQLiteBindParameterExpression) o;

        return name != null ? name.equalsIgnoreCase(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}

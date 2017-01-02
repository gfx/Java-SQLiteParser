package com.github.gfx.sqlite_ddl;

public class SQLiteLiteral extends SQLiteExpression {

    public String value;

    public SQLiteLiteral() {
    }

    public SQLiteLiteral(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteLiteral that = (SQLiteLiteral) o;

        return value != null ? value.equals(that.value) : that.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}

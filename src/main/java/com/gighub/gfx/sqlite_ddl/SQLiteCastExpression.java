package com.gighub.gfx.sqlite_ddl;

public class SQLiteCastExpression extends SQLiteExpression {
    public final SQLiteExpression expr;

    public final SQLiteType type;

    public SQLiteCastExpression(SQLiteExpression expr, SQLiteType type) {
        this.expr = expr;
        this.type = type;
    }

    @Override
    public String toString() {
        return "cast(" + expr + " as " + type + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteCastExpression that = (SQLiteCastExpression) o;

        if (!expr.equals(that.expr)) return false;
        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        int result = expr.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}

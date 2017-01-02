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
}

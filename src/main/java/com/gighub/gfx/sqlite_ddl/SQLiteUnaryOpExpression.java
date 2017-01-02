package com.gighub.gfx.sqlite_ddl;

public class SQLiteUnaryOpExpression extends SQLiteExpression {

    public SQLiteSymbol unaryOp;

    public SQLiteExpression expr;

    public SQLiteUnaryOpExpression() {
    }

    public SQLiteUnaryOpExpression(SQLiteSymbol unaryOp, SQLiteExpression expr) {
        this.unaryOp = unaryOp;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return String.valueOf(unaryOp) + String.valueOf(expr);
    }
}

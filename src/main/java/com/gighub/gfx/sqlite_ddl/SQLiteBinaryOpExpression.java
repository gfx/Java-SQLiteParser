package com.gighub.gfx.sqlite_ddl;

public class SQLiteBinaryOpExpression extends SQLiteExpression {

    public SQLiteExpression leftExpr;

    public SQLiteSymbol binOp;

    public SQLiteExpression rightExpr;

    public SQLiteBinaryOpExpression(SQLiteExpression leftExpr, SQLiteSymbol binOp, SQLiteExpression rightExpr) {
        this.leftExpr = leftExpr;
        this.binOp = binOp;
        this.rightExpr = rightExpr;
    }

    @Override
    public String toString() {
        return leftExpr + " " + binOp + " " + rightExpr;
    }
}

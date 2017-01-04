package com.github.gfx.sqlite_ddl;

public class SQLiteBinaryOpExpression extends SQLiteExpression {

    public SQLiteExpression leftExpr;

    public SQLiteToken binOp;

    public SQLiteExpression rightExpr;

    public SQLiteBinaryOpExpression(SQLiteExpression leftExpr, SQLiteToken binOp, SQLiteExpression rightExpr) {
        this.leftExpr = leftExpr;
        this.binOp = binOp;
        this.rightExpr = rightExpr;
    }

    @Override
    public String toString() {
        return leftExpr + " " + binOp + " " + rightExpr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteBinaryOpExpression that = (SQLiteBinaryOpExpression) o;

        if (!leftExpr.equals(that.leftExpr)) return false;
        if (!binOp.equals(that.binOp)) return false;
        return rightExpr.equals(that.rightExpr);
    }

    @Override
    public int hashCode() {
        int result = leftExpr.hashCode();
        result = 31 * result + binOp.hashCode();
        result = 31 * result + rightExpr.hashCode();
        return result;
    }
}

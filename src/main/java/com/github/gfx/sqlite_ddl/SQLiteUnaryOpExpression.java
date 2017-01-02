package com.github.gfx.sqlite_ddl;

public class SQLiteUnaryOpExpression extends SQLiteExpression {

    public SQLiteSymbol unaryOp;

    public SQLiteExpression expr;

    public SQLiteUnaryOpExpression(SQLiteSymbol unaryOp, SQLiteExpression expr) {
        this.unaryOp = unaryOp;
        this.expr = expr;
    }

    @Override
    public String toString() {
        return String.valueOf(unaryOp) + String.valueOf(expr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteUnaryOpExpression that = (SQLiteUnaryOpExpression) o;

        if (!unaryOp.equals(that.unaryOp)) return false;
        return expr.equals(that.expr);
    }

    @Override
    public int hashCode() {
        int result = unaryOp.hashCode();
        result = 31 * result + expr.hashCode();
        return result;
    }
}

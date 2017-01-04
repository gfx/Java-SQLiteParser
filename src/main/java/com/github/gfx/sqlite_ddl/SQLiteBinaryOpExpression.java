package com.github.gfx.sqlite_ddl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SQLiteBinaryOpExpression extends SQLiteExpression {

    public SQLiteExpression leftExpr;

    public List<SQLiteToken> binOp; // e.g. "==", "not like", "is not"

    public SQLiteExpression rightExpr;

    public SQLiteBinaryOpExpression(SQLiteExpression leftExpr, SQLiteToken binOp, SQLiteExpression rightExpr) {
        this(leftExpr, binOp, null, rightExpr);
    }

    public SQLiteBinaryOpExpression(SQLiteExpression leftExpr, SQLiteToken binOp1, SQLiteToken binOp2, SQLiteExpression rightExpr) {
        this.leftExpr = leftExpr;
        if (binOp1 != null && binOp2 != null) {
            binOp = Arrays.asList(binOp1, binOp2);
        } else if (binOp1 != null){
            binOp = Collections.singletonList(binOp1);
        } else if (binOp2 != null) {
            binOp = Collections.singletonList(binOp2);
        } else {
            throw new AssertionError("Missing binOp1 and/or binOp2");
        }
        this.rightExpr = rightExpr;
    }

    private String binOpAsString() {
        return binOp.size() == 1 ? binOp.get(0).toString() : binOp.get(0) + " " + binOp.get(1);
    }

    @Override
    public String toString() {
        return leftExpr + " " + binOpAsString() + " " + rightExpr;
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

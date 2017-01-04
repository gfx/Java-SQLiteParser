package com.github.gfx.sqlite_ddl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SQLiteListExpression extends SQLiteExpression implements Iterable<SQLiteExpression> {
    public final List<SQLiteExpression> list = new ArrayList<>();

    public SQLiteListExpression() {
    }
    public SQLiteListExpression(SQLiteExpression... exprs) {
        Collections.addAll(list, exprs);
    }

    public void add(SQLiteExpression expr) {
        list.add(expr);
    }

    @Override
    public Iterator<SQLiteExpression> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("(");
        for (SQLiteExpression expression : list) {
            s.append(expression);
            s.append(", ");
        }
        if (!list.isEmpty()) {
            s.setLength(s.length() - ", ".length());
        }
        s.append(")");
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteListExpression that = (SQLiteListExpression) o;

        return list.equals(that.list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }
}

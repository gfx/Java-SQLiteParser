package com.github.gfx.sqlite_ddl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SQLiteListExpression extends SQLiteExpression implements Iterable<SQLiteExpression> {
    public final List<SQLiteExpression> list = new ArrayList<>();

    public void add(SQLiteExpression expr) {
        list.add(expr);
    }

    @Override
    public Iterator<SQLiteExpression> iterator() {
        return list.iterator();
    }
}

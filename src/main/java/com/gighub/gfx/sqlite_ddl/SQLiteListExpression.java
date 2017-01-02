package com.gighub.gfx.sqlite_ddl;

import java.util.ArrayList;
import java.util.List;

public class SQLiteListExpression extends SQLiteExpression {
    public final List<SQLiteExpression> list = new ArrayList<>();

    public void add(SQLiteExpression expr) {
        list.add(expr);
    }
}

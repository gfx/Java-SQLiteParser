package com.github.gfx.sqlite_ddl;

import com.github.gfx.sqlite_ddl.g.Token;

public class SQLiteColumnConstraint extends SQLiteNode {

    public final SQLiteTokenList tokens = new SQLiteTokenList();

    public void addToken(Token token) {
        tokens.add(token);
    }

    public SQLiteName name;

    public SQLiteExpression defaultExpr;

    public SQLiteExpression checkExpr;

    public SQLiteName collateName;

    public boolean isPrimaryKey() {
        return tokens.contains("primary");
    }
}

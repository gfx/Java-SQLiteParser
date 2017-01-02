package com.github.gfx.sqlite_ddl;

import com.github.gfx.sqlite_ddl.g.Token;

public class SQLiteStatement extends SQLiteNode {

    public final SQLiteTokenList tokens = new SQLiteTokenList();

    public void addToken(Token token) {
        tokens.add(token);
    }
}

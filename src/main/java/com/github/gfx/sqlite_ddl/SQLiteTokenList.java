package com.github.gfx.sqlite_ddl;

import com.github.gfx.sqlite_ddl.g.Token;

import java.util.ArrayList;
import java.util.List;

public class SQLiteTokenList {

    public final List<SQLiteToken> tokens = new ArrayList<>();

    public void add(Token token) {
        tokens.add(SQLiteToken.create(token));
    }

    public void addAll(SQLiteTokenList tokenList) {
        tokens.addAll(tokenList.tokens);
    }

    public boolean contains(String token) {
        for (SQLiteToken node : tokens) {
            if (node.contentEquals(token)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteTokenList that = (SQLiteTokenList) o;

        return tokens.equals(that.tokens);
    }

    @Override
    public int hashCode() {
        return tokens.hashCode();
    }
}

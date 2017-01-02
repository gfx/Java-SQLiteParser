package com.gighub.gfx.sqlite_ddl;

public class SQLiteSymbol extends SQLiteNode implements SQLiteToken {
    public final String token;

    public SQLiteSymbol(String token) {
        this.token = token;
    }

    @Override
    public boolean contentEquals(String content) {
        return token.equals(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteSymbol that = (SQLiteSymbol) o;
        return token.equals(that.token);
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(token);
    }
}

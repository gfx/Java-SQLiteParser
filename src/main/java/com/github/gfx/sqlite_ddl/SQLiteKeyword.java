package com.github.gfx.sqlite_ddl;

import java.util.Locale;

public class SQLiteKeyword extends SQLiteToken {

    public final String token;

    public SQLiteKeyword(String token) {
        this.token = token;
    }

    @Override
    public boolean contentEquals(String content) {
        return token.equalsIgnoreCase(content);
    }

    @Override
    public String toString() {
        return token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteKeyword that = (SQLiteKeyword) o;

        return token != null ? token.equalsIgnoreCase(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        return token != null ? token.toLowerCase(Locale.ENGLISH).hashCode() : 0;
    }

}

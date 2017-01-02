package com.github.gfx.sqlite_ddl;

public class SQLiteSimpleName extends SQLiteName {

    String identifier = "";

    public SQLiteSimpleName() {
    }

    public SQLiteSimpleName(String identifier) {
        this.identifier = identifier;
    }

    @Override
    public String getName() {
        return ensureNotEscaped(identifier);
    }

    @Override
    public String toString() {
        return ensureEscaped(identifier);
    }

}


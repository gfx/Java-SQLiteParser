package com.github.gfx.sqlite_ddl;

public class SQLiteQualifiedName extends SQLiteName {

    public final SQLiteName scope;

    public final SQLiteName name;

    public SQLiteQualifiedName(SQLiteName scope, SQLiteName name) {
        this.scope = scope;
        this.name = name;
    }

    @Override
    public String getName() {
        return scope.getName() + "." + name.getName();
    }

    @Override
    public String toString() {
        return scope + "." + name;
    }
}

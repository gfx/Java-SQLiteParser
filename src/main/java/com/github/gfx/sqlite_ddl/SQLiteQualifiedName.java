package com.github.gfx.sqlite_ddl;

public class SQLiteQualifiedName extends SQLiteName {

    public SQLiteName scope;

    public SQLiteName name;

    public SQLiteQualifiedName(SQLiteName scope, SQLiteName name) {
        this.scope = scope;
        this.name = name;
    }

    @Override
    public String getName() {
        if (scope == null) {
            return name.getName();
        } else {
            return scope.getName() + "." + name.getName();
        }
    }

    @Override
    public String toString() {
        if (scope == null) {
            return String.valueOf(name);
        } else {
            return scope + "." + name;
        }
    }
}

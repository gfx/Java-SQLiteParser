package com.gighub.gfx.sqlite_ddl;

public class SQLiteFunctionExpression extends SQLiteExpression {

    public final SQLiteName name;

    public final SQLiteKeyword distinct;

    public final SQLiteSymbol wildcard;

    public final SQLiteListExpression args;

    public SQLiteFunctionExpression(SQLiteName name, SQLiteKeyword distinct, SQLiteSymbol wildcard, SQLiteListExpression args) {
        this.name = name;
        this.distinct = distinct;
        this.wildcard = wildcard;
        this.args = args;
    }
}

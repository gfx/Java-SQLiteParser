package com.gighub.gfx.sqlite_ddl.test;

import com.gighub.gfx.sqlite_ddl.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SQLiteCreateStatementTest {
    @Test
    public void smokeTest() throws Exception {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (id integer primary key, value text not null)");
        assertThat(c.getTableName().toString(), is("`foo`"));
        assertThat(c.getColumns(), hasSize(2));
    }

    @Test(expected = SQLiteParserException.class)
    public void parseInvalidSyntax() throws Exception {
        SQLiteParserUtils.parse("create table foo (");
    }

    @Test(expected = SQLiteParserException.class)
    public void parseInvalidStatement() throws Exception {
        SQLiteParserUtils.parse("!");
    }

    @Test
    public void tokens() {
        SQLiteStatement s = SQLiteParserUtils.parse("create table foo (id integer primary key)");

        assertThat(s.tokens.tokens, contains(
                new SQLiteKeyword("create"),
                new SQLiteKeyword("table"),
                new SQLiteSimpleName("foo"),
                new SQLiteSymbol("("),
                new SQLiteSimpleName("id"),
                new SQLiteSimpleName("integer"),
                new SQLiteKeyword("primary"),
                new SQLiteKeyword("key"),
                new SQLiteSymbol(")")
        ));
    }

    @Test
    public void ignoreCase() {
        SQLiteStatement a = SQLiteParserUtils.parse("CREATE TABLE foo (id INTEGER PRIMARY KEY)");
        SQLiteStatement b = SQLiteParserUtils.parse("create table foo (id integer primary key)");

        assertThat(a.tokens, is(b.tokens));
    }

    public void column() {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (id integer primary key, value text not null)");

        SQLiteColumn primaryKey = c.getColumns().get(0);
        assertThat(primaryKey.getColumnName().getName(), is("id"));
        assertThat(primaryKey.getType().toString(), is("integer"));
        assertThat(primaryKey.isPrimaryKey(), is(true));
    }

    @Test
    public void columnConstraintDefault() {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (value text default(1 + 2))");

        assertThat(c.getColumns().get(0).getDefaultExpr().toString(), is("1 + 2"));
    }

    @Test
    public void columnConstraintCheck() {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (value integer check(value > 0))");

        assertThat(c.getColumns().get(0).getCheckExpr().toString(), is("`value` > 0"));
    }

}

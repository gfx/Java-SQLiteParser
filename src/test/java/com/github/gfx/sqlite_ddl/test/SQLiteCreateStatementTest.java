package com.github.gfx.sqlite_ddl.test;

import com.github.gfx.sqlite_ddl.*;
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

    @Test
    public void column() {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (id integer primary key, value text not null)");

        SQLiteColumn primaryKey = c.getColumns().get(0);
        assertThat(primaryKey.getColumnName().getName(), is("id"));
        assertThat(primaryKey.getType(), is(new SQLiteType(new SQLiteSimpleName("integer"), null, null)));
        assertThat(primaryKey.isPrimaryKey(), is(true));
    }

    @Test
    public void columnWithoutType() {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (id, value)");

        SQLiteColumn primaryKey = c.getColumns().get(0);
        assertThat(primaryKey.getColumnName().getName(), is("id"));
        assertThat(primaryKey.getType(), is(nullValue()));
        assertThat(primaryKey.isPrimaryKey(), is(false));
    }

    @Test
    public void columnTypeWithP1() {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (id varchar(8))");

        SQLiteColumn column = c.getColumns().get(0);
        assertThat(column.getType().toString(), is("`varchar`(8)"));
    }

    @Test
    public void columnTypeWithP1AndP2() {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (id decimal(5, 2))");

        SQLiteColumn column = c.getColumns().get(0);
        assertThat(column.getType().toString(), is("`decimal`(5,2)"));
    }

    @Test
    public void columnConstraintDefault() {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (value text default(1 + 2))");

        SQLiteColumn column = c.getColumns().get(0);
        assertThat(column.getDefaultExpr(), is(new SQLiteBinaryOpExpression(
                new SQLiteNumericLiteral("1"),
                new SQLiteSymbol("+"),
                new SQLiteNumericLiteral("2")
        )));
    }

    @Test
    public void columnConstraintCheck() {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (value integer check(value > 0))");

        assertThat(c.getColumns().get(0).getCheckExpr().toString(), is("`value` > 0"));
    }

}

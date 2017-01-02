package com.gighub.gfx.sqlite_ddl.test;

import com.gighub.gfx.sqlite_ddl.*;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SQLiteParserUtilsTest {
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
    public void constraints() {
        SQLiteCreateTableStatement c = SQLiteParserUtils.parseCreateTableStatement(
                "create table foo (value text default(1 + 2))");

        List<SQLiteColumnConstraint> constraints = c.getColumns().get(0).getConstraints();

        assertThat(constraints.get(0).defaultExpr.toString(), is("1 + 2"));
    }
}

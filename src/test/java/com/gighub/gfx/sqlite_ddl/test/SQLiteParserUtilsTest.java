package com.gighub.gfx.sqlite_ddl.test;

import com.gighub.gfx.sqlite_ddl.CreateTableStatement;
import com.gighub.gfx.sqlite_ddl.SQLiteComponent;
import com.gighub.gfx.sqlite_ddl.SQLiteParserException;
import com.gighub.gfx.sqlite_ddl.SQLiteParserUtils;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class SQLiteParserUtilsTest {
    @Test
    public void smokeTest() throws Exception {
        SQLiteComponent c = SQLiteParserUtils.parse("create table foo (id integer primary key)");

        assertThat(c, is(instanceOf(CreateTableStatement.class)));
    }

    @Test(expected = SQLiteParserException.class)
    public void parseInvalidSyntax() throws Exception {
        SQLiteParserUtils.parse("create table foo (");
    }

    @Test
    public void ignoreCase() {
        SQLiteComponent a = SQLiteParserUtils.parse("CREATE TABLE foo (id INTEGER PRIMARY KEY)");
        SQLiteComponent b = SQLiteParserUtils.parse("create table foo (id integer primary key)");

        assertThat(a.getTokens(), is(b.getTokens()));
    }
}

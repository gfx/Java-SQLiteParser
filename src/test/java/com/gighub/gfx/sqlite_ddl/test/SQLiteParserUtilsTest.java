package com.gighub.gfx.sqlite_ddl.test;

import com.gighub.gfx.sqlite_ddl.SQLiteParserException;
import com.gighub.gfx.sqlite_ddl.SQLiteParserUtils;
import org.junit.Test;

public class SQLiteParserUtilsTest {
    @Test
    public void smokeTest() throws Exception {
        SQLiteParserUtils.parse("CREATE TABLE foo (id INTEGER PRIMARY KEY)");
        SQLiteParserUtils.parse("create table foo (id integer primary key)");
    }

    @Test(expected = SQLiteParserException.class)
    public void parseInvalidCode() throws Exception {
        SQLiteParserUtils.parse("CREATE TABLE foo (");
    }

}

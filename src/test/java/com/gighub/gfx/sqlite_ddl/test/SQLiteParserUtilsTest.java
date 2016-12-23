package com.gighub.gfx.sqlite_ddl.test;

import com.gighub.gfx.sqlite_ddl.SQLiteParserUtils;
import org.junit.Test;

public class SQLiteParserUtilsTest {
    @Test
    public void parse() throws Exception {
        SQLiteParserUtils.parse("CREATE TABLE foo (id INTEGER PRIMARY KEY)");
    }

}

package com.gighub.gfx.sqlite_ddl;

import com.github.gfx.sqlite_ddl.g.ParseException;
import com.github.gfx.sqlite_ddl.g.SQLiteParser;

import java.io.StringReader;

public class SQLiteParserUtils {
    public static SQLiteStatement parse(String sql) {
        SQLiteParser parser = new SQLiteParser(new StringReader(sql));

        try {
            return parser.statement();
        } catch (ParseException e) {
            throw new SQLiteParserException(e);
        }
    }

    public static SQLiteCreateTableStatement parseCreateTableStatement(String sql) {
        SQLiteParser parser = new SQLiteParser(new StringReader(sql));

        try {
            return parser.createTableStatement();
        } catch (ParseException e) {
            throw new SQLiteParserException(e);
        }
    }
}

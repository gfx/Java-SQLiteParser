package com.gighub.gfx.sqlite_ddl;

import com.github.gfx.sqlite_ddl.g.ParseException;
import com.github.gfx.sqlite_ddl.g.SQLiteParser;

import java.io.StringReader;

public class SQLiteParserUtils {
    public static SQLiteComponent parse(String sql) {
        SQLiteParser parser = new SQLiteParser(new StringReader(sql));

        try {
            parser.CreateStatement();
        } catch (ParseException e) {
            throw new SQLiteParserException(e);
        }
        return parser.token_source.rootComponent;
    }
}

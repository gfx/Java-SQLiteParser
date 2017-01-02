package com.gighub.gfx.sqlite_ddl;

import com.github.gfx.sqlite_ddl.g.ParseException;
import com.github.gfx.sqlite_ddl.g.SQLiteParser;
import com.github.gfx.sqlite_ddl.g.TokenMgrError;

import java.io.StringReader;

public class SQLiteParserUtils {
    public static SQLiteStatement parse(String sql) {
        SQLiteParser parser = new SQLiteParser(new StringReader(sql));

        try {
            return parser.statement();
        } catch (ParseException | TokenMgrError e) {
            throw new SQLiteParserException(e);
        }
    }

    public static SQLiteCreateTableStatement parseCreateTableStatement(String sql) {
        SQLiteParser parser = new SQLiteParser(new StringReader(sql));

        try {
            return parser.createTableStatement();
        } catch (ParseException | TokenMgrError e) {
            throw new SQLiteParserException(e);
        }
    }

    public static SQLiteExpression parseExpression(String sql) {
        SQLiteParser parser = new SQLiteParser(new StringReader(sql));

        try {
            return parser.expr();
        } catch (ParseException | TokenMgrError e) {
            throw new SQLiteParserException(e);
        }
    }
}

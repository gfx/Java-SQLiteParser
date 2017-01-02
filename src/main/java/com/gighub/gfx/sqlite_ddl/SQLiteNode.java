package com.gighub.gfx.sqlite_ddl;

import com.github.gfx.sqlite_ddl.g.SQLiteParserConstants;
import com.github.gfx.sqlite_ddl.g.Token;

public abstract class SQLiteNode {

    public static SQLiteToken create(Token token) {
        if (SQLiteKeyword.isKeyword(token)) {
            return new SQLiteKeyword(token.image);
        } else if (token.kind == SQLiteParserConstants.IDENTIFIER) {
            return new SQLiteSimpleName(token.image);
        } else {
            return new SQLiteSymbol(token.image);
        }
    }
}

package com.github.gfx.sqlite_ddl;

@SuppressWarnings("serial")
public class SQLiteParserException extends RuntimeException {
    public SQLiteParserException(String message) {
        super(message);
    }

    public SQLiteParserException(String message, Throwable cause) {
        super(message, cause);
    }

    public SQLiteParserException(Throwable cause) {
        super(cause);
    }
}

package com.github.gfx.sqlite_ddl;

import com.github.gfx.sqlite_ddl.g.Token;

import java.util.Locale;

import static com.github.gfx.sqlite_ddl.g.SQLiteParserConstants.*;

public class SQLiteKeyword extends SQLiteNode implements SQLiteToken {

    public static boolean isKeyword(Token token) {
        switch (token.kind) {
            case K_ABORT:
                return true;
            case K_ACTION:
                return true;
            case K_ADD:
                return true;
            case K_AFTER:
                return true;
            case K_ALL:
                return true;
            case K_ALTER:
                return true;
            case K_ANALYZE:
                return true;
            case K_AND:
                return true;
            case K_AS:
                return true;
            case K_ASC:
                return true;
            case K_ATTACH:
                return true;
            case K_AUTOINCREMENT:
                return true;
            case K_BEFORE:
                return true;
            case K_BEGIN:
                return true;
            case K_BETWEEN:
                return true;
            case K_BY:
                return true;
            case K_CASCADE:
                return true;
            case K_CASE:
                return true;
            case K_CAST:
                return true;
            case K_CHECK:
                return true;
            case K_COLLATE:
                return true;
            case K_COLUMN:
                return true;
            case K_COMMIT:
                return true;
            case K_CONFLICT:
                return true;
            case K_CONSTRAINT:
                return true;
            case K_CREATE:
                return true;
            case K_CROSS:
                return true;
            case K_CURRENT_DATE:
                return true;
            case K_CURRENT_TIME:
                return true;
            case K_CURRENT_TIMESTAMP:
                return true;
            case K_DATABASE:
                return true;
            case K_DEFAULT:
                return true;
            case K_DEFERRABLE:
                return true;
            case K_DEFERRED:
                return true;
            case K_DELETE:
                return true;
            case K_DESC:
                return true;
            case K_DETACH:
                return true;
            case K_DISTINCT:
                return true;
            case K_DROP:
                return true;
            case K_EACH:
                return true;
            case K_ELSE:
                return true;
            case K_END:
                return true;
            case K_ESCAPE:
                return true;
            case K_EXCEPT:
                return true;
            case K_EXCLUSIVE:
                return true;
            case K_EXISTS:
                return true;
            case K_EXPLAIN:
                return true;
            case K_FAIL:
                return true;
            case K_FOR:
                return true;
            case K_FOREIGN:
                return true;
            case K_FROM:
                return true;
            case K_FULL:
                return true;
            case K_GLOB:
                return true;
            case K_GROUP:
                return true;
            case K_HAVING:
                return true;
            case K_IF:
                return true;
            case K_IGNORE:
                return true;
            case K_IMMEDIATE:
                return true;
            case K_IN:
                return true;
            case K_INDEX:
                return true;
            case K_INDEXED:
                return true;
            case K_INITIALLY:
                return true;
            case K_INNER:
                return true;
            case K_INSERT:
                return true;
            case K_INSTEAD:
                return true;
            case K_INTERSECT:
                return true;
            case K_INTO:
                return true;
            case K_IS:
                return true;
            case K_ISNULL:
                return true;
            case K_JOIN:
                return true;
            case K_KEY:
                return true;
            case K_LEFT:
                return true;
            case K_LIKE:
                return true;
            case K_LIMIT:
                return true;
            case K_MATCH:
                return true;
            case K_NATURAL:
                return true;
            case K_NO:
                return true;
            case K_NOT:
                return true;
            case K_NOTNULL:
                return true;
            case K_NULL:
                return true;
            case K_OF:
                return true;
            case K_OFFSET:
                return true;
            case K_ON:
                return true;
            case K_OR:
                return true;
            case K_ORDER:
                return true;
            case K_OUTER:
                return true;
            case K_PLAN:
                return true;
            case K_PRAGMA:
                return true;
            case K_PRIMARY:
                return true;
            case K_QUERY:
                return true;
            case K_RAISE:
                return true;
            case K_RECURSIVE:
                return true;
            case K_REFERENCES:
                return true;
            case K_REGEXP:
                return true;
            case K_REINDEX:
                return true;
            case K_RELEASE:
                return true;
            case K_RENAME:
                return true;
            case K_REPLACE:
                return true;
            case K_RESTRICT:
                return true;
            case K_RIGHT:
                return true;
            case K_ROLLBACK:
                return true;
            case K_ROW:
                return true;
            case K_SAVEPOINT:
                return true;
            case K_SELECT:
                return true;
            case K_SET:
                return true;
            case K_TABLE:
                return true;
            case K_TEMP:
                return true;
            case K_TEMPORARY:
                return true;
            case K_THEN:
                return true;
            case K_TO:
                return true;
            case K_TRANSACTION:
                return true;
            case K_TRIGGER:
                return true;
            case K_UNION:
                return true;
            case K_UNIQUE:
                return true;
            case K_UPDATE:
                return true;
            case K_USING:
                return true;
            case K_VACUUM:
                return true;
            case K_VALUES:
                return true;
            case K_VIEW:
                return true;
            case K_VIRTUAL:
                return true;
            case K_WHEN:
                return true;
            case K_WHERE:
                return true;
            case K_WITH:
                return true;
            case K_WITHOUT:
                return true;
            default:
                return false;
        }
    }

    public final String token;

    public SQLiteKeyword(String token) {
        this.token = token;
    }

    @Override
    public boolean contentEquals(String content) {
        return token.equalsIgnoreCase(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteKeyword that = (SQLiteKeyword) o;

        return token != null ? token.equalsIgnoreCase(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        return token != null ? token.toLowerCase(Locale.ENGLISH).hashCode() : 0;
    }

}

package com.gighub.gfx.sqlite_ddl;

import java.util.Locale;

public abstract class SQLiteName extends SQLiteNode implements SQLiteToken {

    public static String ensureEscaped(String s) {
        if (s.startsWith("\"") || s.startsWith("`") || s.startsWith("[")) {
            return s;
        } else {
            return "`" + s.replaceAll("`", "``") + "`";
        }
    }

    public static String ensureNotEscaped(String s) {
        if (s.startsWith("\"")) {
            assert s.endsWith("\"");
            return s.substring(1, s.length() - 2).replaceAll("\"\"", "\"");
        } else if (s.startsWith("`")) {
            assert s.endsWith("`");
            return s.substring(1, s.length() - 2).replace("``", "`");
        } else if (s.startsWith("[")) {
            assert s.endsWith("]");
            return s.substring(1, s.length() - 2);
        } else {
            return s;
        }
    }

    /**
     * @return the identifier of the name, which is not escaped.
     */
    public abstract String getName();

    @Override
    public boolean contentEquals(String content) {
        return getName().equalsIgnoreCase(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SQLiteName)) {
            return false;
        }

        SQLiteName that = (SQLiteName) o;
        return getName().equalsIgnoreCase(that.getName());
    }

    @Override
    public int hashCode() {
        return getName().toLowerCase(Locale.ENGLISH).hashCode();
    }
}

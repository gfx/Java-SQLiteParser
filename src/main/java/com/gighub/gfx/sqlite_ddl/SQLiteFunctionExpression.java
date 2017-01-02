package com.gighub.gfx.sqlite_ddl;

public class SQLiteFunctionExpression extends SQLiteExpression {

    public final SQLiteName name;

    public final SQLiteKeyword distinct;

    public final SQLiteSymbol wildcard;

    public final SQLiteListExpression args;

    public SQLiteFunctionExpression(SQLiteName name, SQLiteKeyword distinct, SQLiteSymbol wildcard, SQLiteListExpression args) {
        this.name = name;
        this.distinct = distinct;
        this.wildcard = wildcard;
        this.args = args;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(name.toString());
        if (wildcard != null) {
            s.append(wildcard);
        } else if (args != null) {
            s.append("(");
            if (distinct != null) {
                s.append(distinct);
                s.append(" ");
            }
            for (SQLiteExpression arg : args) {
                s.append(arg);
                s.append(", ");
            }
            s.setLength(s.length() - 2);
            s.append(")");
        }
        return s.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteFunctionExpression that = (SQLiteFunctionExpression) o;

        if (!name.equals(that.name)) return false;
        if (distinct != null ? !distinct.equals(that.distinct) : that.distinct != null) return false;
        if (wildcard != null ? !wildcard.equals(that.wildcard) : that.wildcard != null) return false;
        return args != null ? args.equals(that.args) : that.args == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (distinct != null ? distinct.hashCode() : 0);
        result = 31 * result + (wildcard != null ? wildcard.hashCode() : 0);
        result = 31 * result + (args != null ? args.hashCode() : 0);
        return result;
    }
}

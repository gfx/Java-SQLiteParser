package com.gighub.gfx.sqlite_ddl;

/**
 * SQLite type notation, where {@link #p1} is the precision or the length
 * and {@link #p2} is the scale.
 */
public class SQLiteType extends SQLiteNode {

    public SQLiteName typeName;

    public SQLiteExpression p1;

    public SQLiteExpression p2;

    public SQLiteType(SQLiteName typeName, SQLiteExpression p1, SQLiteExpression p2) {
        this.typeName = typeName;
        this.p1 = p1;
        this.p2 = p2;
    }

    @Override
    public String toString() {
        if (p1 == null && p2 == null) {
            return String.valueOf(typeName);
        } else if (p2 == null) {
            return typeName + "(" + p1 + ")";
        } else {
            return typeName + "(" + p1 + "," + p2 + ")";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SQLiteType that = (SQLiteType) o;

        if (!typeName.equals(that.typeName)) return false;
        if (p1 != null ? !p1.equals(that.p1) : that.p1 != null) return false;
        return p2 != null ? p2.equals(that.p2) : that.p2 == null;
    }

    @Override
    public int hashCode() {
        int result = typeName.hashCode();
        result = 31 * result + (p1 != null ? p1.hashCode() : 0);
        result = 31 * result + (p2 != null ? p2.hashCode() : 0);
        return result;
    }
}

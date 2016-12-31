package com.gighub.gfx.sqlite_ddl;

import java.util.ArrayList;
import java.util.List;

public class SQLiteColumn extends SQLiteComponent {

    Name name;

    String type;

    List<Constraint> constraints = new ArrayList<>();

    public Name getName() {
        return name;
    }

    public void setName(String name) {
        this.name = new Name(name);
    }

    public String getType() {
        return type;
    }

    public List<Constraint> getConstraints() {
        return constraints;
    }

    @Override
    public String toString() {
        StringBuilder columnSpecBuilder = new StringBuilder(name);

        if (type != null) {
            columnSpecBuilder.append(' ');
            columnSpecBuilder.append(type);
        }

        for (Constraint constraint : constraints) {
            columnSpecBuilder.append(' ');
            columnSpecBuilder.append(constraint);
        }
        return columnSpecBuilder.toString();
    }

    public static class Constraint extends SQLiteComponent {

        boolean primaryKey;

        boolean nullable = true;

        String defaultExpr;

        public boolean isPrimaryKey() {
            return primaryKey;
        }

        public boolean isNullable() {
            return !primaryKey && nullable;
        }

        public String getDefaultExpr() {
            return defaultExpr;
        }
    }
}

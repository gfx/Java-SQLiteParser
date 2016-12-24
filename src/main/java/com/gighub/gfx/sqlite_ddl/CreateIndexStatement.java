package com.gighub.gfx.sqlite_ddl;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of {@code CREATE INDEX $index ON $table ($columns...)}.
 */
public class CreateIndexStatement extends SQLiteComponent {

    protected Name indexName;

    protected Name tableName;

    final List<Name> columns = new ArrayList<>();

    public Name getIndexName() {
        return indexName;
    }

    public Name getTableName() {
        return tableName;
    }

    public List<Name> getColumns() {
        return columns;
    }
}

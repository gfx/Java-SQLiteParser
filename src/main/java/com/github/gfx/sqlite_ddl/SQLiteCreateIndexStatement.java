package com.github.gfx.sqlite_ddl;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of {@code CREATE INDEX $index ON $table ($columns...)}.
 */
public class SQLiteCreateIndexStatement extends SQLiteStatement {

    public SQLiteName indexName;

    public SQLiteName tableName;

    public final List<SQLiteName> columns = new ArrayList<>();
}

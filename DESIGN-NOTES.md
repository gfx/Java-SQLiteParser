# The Design Notes

There are SQL parsers available in Java projects:

* https://github.com/bkiers/sqlite-parser - an ANTLR4 based grammar file
* https://github.com/JSQLParser/JSqlParser - a JavaCC based parser library

However, they are not suitable to parse SQLite statements on Android.

ANTLR4 [does not work well on Android](https://github.com/antlr/antlr4/issues/1525), and JSqlParser does not handle non-standard, SQLite-specific syntax.

The project only aims to parse SQLite DDL, not full SQLite statements, as a part of the [Orma](https://github.com/gfx/Android-Orma) project.

2016/12/23

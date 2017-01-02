package com.github.gfx.sqlite_ddl.test;

import com.github.gfx.sqlite_ddl.*;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class SQLiteExpressionTest {

    @Test
    public void add() throws Exception {
        SQLiteExpression expr = SQLiteParserUtils.parseExpression("1 + 2 + 3");

        assertThat(expr, is(
                new SQLiteBinaryOpExpression(
                        new SQLiteBinaryOpExpression(
                                new SQLiteNumericLiteral("1"),
                                new SQLiteSymbol("+"),
                                new SQLiteNumericLiteral("2")
                        ),
                        new SQLiteSymbol("+"),
                        new SQLiteNumericLiteral("3")
                )));
    }

    @Test
    public void addAndMultiply() throws Exception {
        SQLiteExpression expr = SQLiteParserUtils.parseExpression("1 + 2 * 3");

        assertThat(expr, is(
                new SQLiteBinaryOpExpression(
                        new SQLiteNumericLiteral("1"),
                        new SQLiteSymbol("+"),
                        new SQLiteBinaryOpExpression(
                                new SQLiteNumericLiteral("2"),
                                new SQLiteSymbol("*"),
                                new SQLiteNumericLiteral("3")
                        )
                )));
    }

    @Test
    public void eqAndOrAndEq() throws Exception {
        SQLiteExpression expr = SQLiteParserUtils.parseExpression("foo == ? or foo == ?");

        SQLiteNameExpr foo = new SQLiteNameExpr(new SQLiteSimpleName("foo"));
        SQLiteBindParameter ph = new SQLiteBindParameter("?");

        assertThat(expr, is(
                new SQLiteBinaryOpExpression(
                        new SQLiteBinaryOpExpression(
                                foo,
                                new SQLiteSymbol("=="),
                                ph

                        ),
                        new SQLiteSymbol("or"),
                        new SQLiteBinaryOpExpression(
                                foo,
                                new SQLiteSymbol("=="),
                                ph

                        )
                )));
    }

    @Test
    public void unaryOpPrecedence() throws Exception {
        SQLiteExpression expr = SQLiteParserUtils.parseExpression("-1 * 2");

        assertThat(expr, is(
                new SQLiteBinaryOpExpression(
                        new SQLiteUnaryOpExpression(
                                new SQLiteSymbol("-"),
                                new SQLiteNumericLiteral("1")
                        ),
                        new SQLiteSymbol("*"),
                        new SQLiteNumericLiteral("2")
                )));
    }

    @Test
    public void functionExprWithoutArgs() throws Exception {
        SQLiteExpression expr = SQLiteParserUtils.parseExpression("count()");

        assertThat(expr, is(
                new SQLiteFunctionExpression(
                        new SQLiteSimpleName("count"),
                        null,
                        null,
                        null
                )));
    }

    @Test
    public void functionExprWithWildcard() throws Exception {
        SQLiteExpression expr = SQLiteParserUtils.parseExpression("count(*)");

        assertThat(expr, is(
                new SQLiteFunctionExpression(
                        new SQLiteSimpleName("count"),
                        null,
                        new SQLiteSymbol("*"),
                        null
                )));
    }

}

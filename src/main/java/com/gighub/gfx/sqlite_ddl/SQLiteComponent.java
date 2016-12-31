package com.gighub.gfx.sqlite_ddl;

import com.github.gfx.sqlite_ddl.g.SQLiteParserConstants;
import com.github.gfx.sqlite_ddl.g.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SQLiteComponent {

    protected final List<CharSequence> tokens = new ArrayList<>();

    public void addToken(Token token) {
        if (isKeyword(token)) {
            tokens.add(new Keyword(token.image));
        } else if (token.kind == SQLiteParserConstants.IDENTIFIER) {
            tokens.add(new Name(token.image));
        } else {
            tokens.add(token.image);
        }
    }

    private boolean isKeyword(Token token) {
        return SQLiteParserConstants.tokenImage[token.kind].startsWith("K_");
    }

    public List<CharSequence> getTokens() {
        return tokens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SQLiteComponent)) {
            return false;
        }

        SQLiteComponent that = (SQLiteComponent) o;
        return tokens.equals(that.tokens);

    }

    @Override
    public int hashCode() {
        return tokens.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (CharSequence token : tokens) {
            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(token);
        }

        return sb.toString();
    }

    public static class CaseInsensitiveToken implements CharSequence {

        final String token;

        public CaseInsensitiveToken(String token) {
            this.token = token;
        }

        @Override
        public int length() {
            return token.length();
        }

        @Override
        public char charAt(int index) {
            return token.charAt(index);
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            return token.subSequence(start, end);
        }

        @Override
        public String toString() {
            return token;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof CaseInsensitiveToken)) {
                return false;
            }

            CaseInsensitiveToken that = (CaseInsensitiveToken) o;
            return token.equalsIgnoreCase(that.token);

        }

        @Override
        public int hashCode() {
            return token.toLowerCase(Locale.US).hashCode();
        }
    }

    public static class Keyword extends CaseInsensitiveToken {

        public Keyword(String token) {
            super(token);
        }
    }

    public static class Name extends CaseInsensitiveToken {

        public Name(String token) {
            super(ensureEscaped(token));
        }

        public String getUnquotedToken() {
            return ensureNotEscaped(token);
        }

        @Override
        public String toString() {
            return token;
        }
    }

    public static String ensureEscaped(String s) {
        return s;
    }

    public static String ensureNotEscaped(String s) {
        return s;
    }
}


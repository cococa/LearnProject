package com.cocoa.lox;

import java.util.ArrayList;
import java.util.List;

import static com.cocoa.lox.TokenType.*;

public class Scanner {
    private String source;
    private List<Token> tokens = new ArrayList<>();


    private int start = 0;
    private int current = 0;
    private int line = 1;


    public Scanner(String source) {
        this.source = source;
    }


    private boolean isAtEnd() {
        return current >= source.length();
    }

    public List<Token> scanTokens() {
        while (!isAtEnd()) {
            // We are at the beginning of the next lexeme.
            start = current;
            scanToken();
        }
        tokens.add(new Token(TokenType.EOF, "", null, line));
        return tokens;
    }


    private char advance() {
        current++;
        return source.charAt(current - 1);
    }


    private void addToken(TokenType type) {
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal) {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }


    private void scanToken() {
        char c = advance();
        switch (c) {
            case '(':
                addToken(LEFT_PAREN);
                break;
            case ')':
                addToken(RIGHT_PAREN);
                break;
            case '{':
                addToken(LEFT_BRACE);
                break;
            case '}':
                addToken(RIGHT_BRACE);
                break;
            case ',':
                addToken(COMMA);
                break;
            case '.':
                addToken(DOT);
                break;
            case '-':
                addToken(MINUS);
                break;
            case '+':
                addToken(PLUS);
                break;
            case ';':
                addToken(SEMICOLON);
                break;
            case '*':
                addToken(STAR);
                break;
        }
    }


}

package com.cocoa.lox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cocoa.lox.TokenType.*;

public class Scanner {

    private static final Map<String, TokenType> keywords;

    static {
        keywords = new HashMap<>();
        keywords.put("and", AND);
        keywords.put("class", CLASS);
        keywords.put("else", ELSE);
        keywords.put("false", FALSE);
        keywords.put("for", FOR);
        keywords.put("fun", FUN);
        keywords.put("if", IF);
        keywords.put("nil", NIL);
        keywords.put("or", OR);
        keywords.put("print", PRINT);
        keywords.put("return", RETURN);
        keywords.put("super", SUPER);
        keywords.put("this", THIS);
        keywords.put("true", TRUE);
        keywords.put("var", VAR);
        keywords.put("while", WHILE);
    }


    private final String source;
    private final List<Token> tokens = new ArrayList<>();


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


    private boolean match(char expected) {
        if (isAtEnd()) {
            return false;
        }
        if (source.charAt(current) != expected) {
            return false;
        }
        current++;
        return true;
    }

    private char peek() {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }


    private void getStringLine() {
        char c = peek();
        while (c != '"' && !isAtEnd()) {
            if (c == '\n') {
                line++;
            }
            c = advance();
        }
        //到结尾都没发现闭合的 "
        if (isAtEnd()) {
            throw new NullPointerException("");
        }
        //此时start 到current substring 的结果是 "xxxx", 所以要去掉"
        String value = source.substring(start + 1, current - 1);
        addToken(STRING, value);
    }

    private void getNumber() {
        char c = peek();
        while (isDigit(c) || c == '.') {
            c = advance();
        }
        current--;
        //此时start 到current substring 的结果是 "xxxx", 所以要去掉"
        String value = source.substring(start, current);
        if (value.indexOf(".") > -1) {
            addToken(NUMBER, Double.parseDouble(value));
        } else {
            addToken(NUMBER, Integer.parseInt(value));
        }
    }


    private void getIdentifier() {
        char c = peek();
        while (isDigit(c) || isAlpha(c)) {
            current++;
            c = peek();
        }
        String text = source.substring(start, current);
        TokenType type = keywords.get(text);
        if (type == null) type = IDENTIFIER;
        addToken(type);
    }


    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                c == '_';
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
            case '!':
                addToken(match('=') ? BANG_EQUAL : BANG);
                break;
            case '=':
                addToken(match('=') ? EQUAL_EQUAL : EQUAL);
                break;
            case '<':
                addToken(match('=') ? LESS_EQUAL : LESS);
                break;
            case '>':
                addToken(match('=') ? GREATER_EQUAL : GREATER);
                break;
            case ' ':
            case '\r':
            case '\t':
                break;
            case '\n':
                line++;
                break;
            case '/':
                if (match('/')) {
                    // A comment goes until the end of the line.
                    while (peek() != '\n' && !isAtEnd()) advance();
                } else {
                    addToken(SLASH);
                }
                break;
            case '"':
                getStringLine();
                break;
            default:
                if (isDigit(c)) {
                    getNumber();
                } else if (isAlpha(c)) {
                    getIdentifier();
                }
//            default: throw new NullPointerException();
        }
    }


}

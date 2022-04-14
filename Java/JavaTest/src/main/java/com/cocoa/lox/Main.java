package com.cocoa.lox;


import java.util.List;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner("var name = 1;");
        List<Token> tokens = scanner.scanTokens();
        tokens.stream().forEach(System.out::println);
//        System.out.println(tokens);

    }


}

package com.cocoa.lox;


import java.util.Calendar;
import java.util.List;

public class Main {

    public static void main(String[] args) {


//        String source = "        String s = \"12\n" +
//                "                3\";";

//        String source = "String s = \"12\" +\n" +
//                "                \"34\";";
//
//        String source = "//zhushi \n" +
//                "var name = 1 * 1; \n";


        String source = "var a = 123.12;";

        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        tokens.stream().forEach(System.out::println);




    }

}




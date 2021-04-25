package com.labuladong.dontaiguihua;

public class N123 {

    public static void main(String[] args) {
//        String  ss = "(123123";
//
//        String result = ss.replace("()","");
//        System.out.println(result);


        String ss = "({})";

        boolean result = isValid(ss);
        System.out.println(result);

    }


    public static boolean isValid(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }

        return s.length() == 0;
    }

}

package com.cocoa.lt;

class Main {

    public static void main(String[] args) {


        System.out.println(new Main().myAtoi("3.123"));

    }


    public int myAtoi(String s) {
        if(s.contains("+-")|| s.contains("-+")){
            return 0;
        }
        int length = s.length();
        int result = 0;
        int temp = 1;
        int len = 0;
        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if ((c > '9' || c < '0')) {
                if ('-' == c && result != 0) {
                    temp = -1;
                }
                if (c != ' ' && c != '+' && c != '-' && result != 0) {
                    result = 0;
                }
                if(c == '.'){
                    result = 0;
                    len = 0;
                }

            } else {
                int sigle = c - '0';
                int sqare = getSqare(len);
                Boolean overflow = isMultOverflow(sigle, sqare);
                if (overflow) {

                    if (i != 0 && '-' == s.charAt(i - 1)) {
                        result = Integer.MIN_VALUE;
                    }else {
                        result = Integer.MAX_VALUE;
                    }


                    break;
                } else {
                    int a = sigle * sqare;
                    overflow = isAddOverflow(a, result);
                    if (overflow) {
                        result = Integer.MAX_VALUE;
                        break;
                    } else {
                        result += a;
                        len++;
                    }
                }
            }
        }
        return result * temp;
    }


    private int getSqare(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }
        return res;
    }

    private Boolean isMultOverflow(int a, int b) {
        return Integer.MAX_VALUE / a < b;
    }

    private Boolean isAddOverflow(int a, int b) {
        return Integer.MAX_VALUE - b < b;
    }
}
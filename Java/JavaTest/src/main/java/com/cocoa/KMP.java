package com.cocoa;


//static class Solution {
//    public int strStr(String haystack, String needle) {
//        int n = haystack.length(), m = needle.length();
//        if (m == 0) {
//            return 0;
//        }
//        int[] pi = new int[m];
//        for (int i = 1, j = 0; i < m; i++) {
//            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
//                j = pi[j - 1];
//            }
//            if (needle.charAt(i) == needle.charAt(j)) {
//                j++;
//            }
//            pi[i] = j;
//        }
//        for (int i = 0, j = 0; i < n; i++) {
//            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
//                j = pi[j - 1];
//            }
//            if (haystack.charAt(i) == needle.charAt(j)) {
//                j++;
//            }
//            if (j == m) {
//                return i - m + 1;
//            }
//        }
//        return -1;
//    }
//
//}

//        int a = new Solution().strStr("abcabcde", "abcd");
//        System.out.println(a);

public class KMP {

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        int[] lps = computeLPSArray(pattern);

        int matchIndex = search(text, pattern, lps);

        if (matchIndex != -1) {
            System.out.println("Pattern found at index " + matchIndex);
        } else {
            System.out.println("Pattern not found in the text");
        }
    }

    private static int[] computeLPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    private static int search(String text, String pattern, int[] lps) {
        int i = 0;  // 指向 text 的指针
        int j = 0;  // 指向 pattern 的指针

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == pattern.length()) {
                // Pattern found
                return i - j;
            } else if (i < text.length() && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;  // Pattern not found
    }
}

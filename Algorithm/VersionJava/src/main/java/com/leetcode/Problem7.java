package com.leetcode;

//        给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
//        如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//
//        假设环境不允许存储 64 位整数（有符号或无符号）。
//         
//
//        示例 1：
//
//        输入：x = 123
//        输出：321
//        示例 2：
//
//        输入：x = -123
//        输出：-321
//        示例 3：
//
//        输入：x = 120
//        输出：21
//        示例 4：
//
//        输入：x = 0
//        输出：0
//         
//
//        提示：
//
//        -231 <= x <= 231 - 1
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/reverse-integer
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class Problem7 {


    /**
     * Integer.MAX_VALUE    2147483647
     * Integer.MIN_VALUE   -2147483648
     *
     * @param args
     */
    public static void main(String[] args) {

        int result = 0;
        long number = 1534236469;
        while (number != 0) {
            int t = (int) (number % 10);

            // 这里的思路是，假设 max 是143,
            // 如果当前的数是大于14的，比如67， 那67*10 ,怎么都是大于143，就肯定溢出了
            // 如果当前的数是小于14的，那么个位数加上什么，都不会大于143
            // 如果当前的数是等于14的，就判断个位数 （t > Integer.MAX_VALUE % 10 ）
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && t > Integer.MAX_VALUE % 10)) {
                result = 0;
                break;
            }

            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && t < Integer.MIN_VALUE % 10)) {
                result = 0;
                break;
            }

            result = result * 10 + t;

            number /= 10;
        }
        System.out.println(result);

//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);


    }

}
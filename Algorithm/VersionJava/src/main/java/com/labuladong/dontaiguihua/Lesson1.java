package com.labuladong.dontaiguihua;

import java.math.BigInteger;


public class Lesson1 {

    private int count = 1;

    // 暴力递归解法
    public int fib1(int n) {
        count++;
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    /**
     * 缓存递归解法, 时间复杂度是  O(n) ，但是加了空间复杂度
     * 这样的解题思路是[自顶向下]  比如n =20 ,   20 = 19 + 18, 然后拆分出19= 18+ 17
     * 换一种思路，可以「自底向上」 从 1,2 开始，向上推进，所以动态规划的解题不需要使用递归，看下面的方法， fib3
     *
     * @param array
     * @param n
     * @return BigInteger 考虑到 long 类型会溢出
     */
    public BigInteger fib2(BigInteger array[], int n) {
        if (n == 1 || n == 2) {
            return new BigInteger("1");
        }
        BigInteger cache = array[n];
        if (cache != null) {
            return cache;
        }
        count++;
        BigInteger t = fib2(array, n - 1).add(fib2(array, n - 2));
        System.out.println(n + "----" + t);
        array[n] = t;//.set(n, t);
        return t;
    }

    /**
     * fib3 的空间复杂度还是 O(n) ，时间复杂度 O(n) , 当然，还可以再继续优化，省去空间复杂度
     * @param n
     * @return
     */
    public BigInteger fib3(int n) {
        BigInteger one = new BigInteger("1");
        if (n == 1 || n == 2) {
            return one;
        }
        BigInteger[] cache = new BigInteger[n + 1];
        cache[0] = one;
        cache[1] = one;
        cache[2] = one;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1].add(cache[i - 2]);
        }
        return cache[n];
    }



    public BigInteger fib4(int n) {
        BigInteger one = new BigInteger("1");
        if (n == 1 || n == 2) {
            return one;
        }
        BigInteger sum = new BigInteger("0");
        BigInteger cache1 = one;
        BigInteger cache2 = one;
        for (int i = 3; i <= n; i++) {
            sum = cache1.add(cache2);
            cache1 = cache2;
            cache2 = sum;
        }
        return sum;
    }


    public static void main(String[] args) {

//        Lesson1 lesson1 = new Lesson1();
//        System.out.println("---fib(n)--"+ lesson1.fib1(100));
//        System.out.println("---count--"+ lesson1.count);


//        Lesson1 lesson2 = new Lesson1();
//        int len = 100;
//        BigInteger array[] = new BigInteger[len + 1];
//        System.out.println("---fib(n)--" + lesson2.fib2(array, len));
//        System.out.println("---count--" + lesson2.count);
//        Arrays.stream(array).forEach(System.out::println);


        Lesson1 lesson3 = new Lesson1();
        System.out.println("---fib(n)--" + lesson3.fib3(100));

//        Lesson1 lesson4 = new Lesson1();
//        System.out.println("---fib(n)--" + lesson4.fib4(100));




    }


}

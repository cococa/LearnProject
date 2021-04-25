package com.labuladong.dontaiguihua;

public class Lesson3 {




    public int getMaxSubsequence(int[] numbers) {

        int pre = numbers[0];
        int result = 1;
        for (int i = 1; i < numbers.length; i++) {
            int item = numbers[i];
            if (item > pre) {
                result++;
            }
            pre = item;
        }
        return result;
    }


    public static void main(String[] args) {

        Lesson3 lesson2 = new Lesson3();
        int[] list = {10, 9, 111, 5, 3, 7, 101, 18};
        int result = lesson2.getMaxSubsequence(list);
        System.out.println("----" + result);


    }

}

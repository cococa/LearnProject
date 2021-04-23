package com.labuladong.dontaiguihua;

public class Lesson2 {

    /**
     * coins  = {1, 2, 5};
     * amount =  10;
     *
     *
     * 1. dp 数组初始化为 amount+1 长度。 初始值为amount+1 ，因为用1来算，amount = amount *1 ，最大的数为amount，
     *    初始值 amount+1 则表示没有解，最后的那个if就是用来判断这个的
     *
     * 2. 开始循环，假如dp的 index coins 在出现，则  dp[index] = 1 , 否则就是 index 本身需要的硬币数，比如3需要两个硬币，dp[3] = 2
     *    当然还有中情况，就是无解，就是  dp[index] = amount +1
     *
     * 3. 举例，假如dp的 index 到了  7 . 则用 7去减coins[0]   = 6,  然后 1 + dp[i - coin] ,就是本次解 7= 1+ [6] ,然后拿dp [6] 的次数加上1就是 7的次数
     *    然后依次遍历  coins[1]， coins[2]  算出最优的 dp[7]
     *
     *
     *
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math. min(dp[i], 1 + dp[i - coin]);
            }
        }
        if(dp[amount] == amount+ 1){
            return -1;
        }
        return dp[amount];
    }


    public static void main(String[] args) {

        Lesson2 lesson2 = new Lesson2();
        int[] coins = {1, 2, 5};
        int result = lesson2.coinChange(coins, 10);
        System.out.println("----" + result);


    }

}

package HOT100题.动态规划;

import java.util.Arrays;

public class 零钱兑换 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(coinChange(coins, 11));
    }


    /**
     * dp[i]表示金额i所需的最少的硬币个数
     * dp[i] = min{dp[i-coins[0]]+1, dp[i-coins[1]]+1,..., dp[i-coins[n]]+1)}
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0;


        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i-coins[j]] != Integer.MAX_VALUE)
                    min = Math.min(min, dp[i-coins[j]]+1);
            }
            dp[i] = min;
        }

        if (dp[amount] == Integer.MAX_VALUE)
            return -1;

       return dp[amount];
    }

}

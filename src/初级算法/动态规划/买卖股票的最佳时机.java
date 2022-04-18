package 初级算法.动态规划;

import java.util.Arrays;

public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }


    /**
     * dp[i] = dp[i-1] || (dp[i-1]+prices[i]-prices[i-1])     如果prices[i] > prices[i-1]则利润提高，否则利润不变
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                dp[i] = dp[i-1]+prices[i]-prices[i-1];
            else
                dp[i] = dp[i-1];

        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
    }
}

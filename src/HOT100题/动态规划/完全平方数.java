package HOT100题.动态规划;


import java.util.Arrays;

public class 完全平方数 {
    public static void main(String[] args) {
        System.out.println(numSquares(13));
    }
    /**
     * dp[i]表示 和为i的完全平方数的最少数量
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            int temp = (int) Math.sqrt(i);
            if (temp*temp == i) {
                dp[i] = 1;
                continue;
            }

            for (int j = i-1; j >= 1; j--) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }
        return dp[n];
    }
}

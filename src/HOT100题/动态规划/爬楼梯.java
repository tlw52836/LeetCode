package HOT100题.动态规划;

public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }


    /**
     * 动态规划 dp[i] = d[i-1] + dp[i-2]  到达i的方式 = 到达i-1（再走一步） + 到达i-2（再走两步）
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                dp[i] = 1;
            else if (i == 1)
                dp[i] = 2;
            else
                dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
}

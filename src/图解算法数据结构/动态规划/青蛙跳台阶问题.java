package 图解算法数据结构.动态规划;

public class 青蛙跳台阶问题 {
    public static void main(String[] args) {
        System.out.println(numWays(100));
    }

    public static int numWays(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        return dp[n];
    }
}

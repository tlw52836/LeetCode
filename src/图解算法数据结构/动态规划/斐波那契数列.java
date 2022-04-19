package 图解算法数据结构.动态规划;

public class 斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(fib(22));
    }
    public static int fib(int n) {
        if (n == 0)
            return 0;
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2;i <= n;i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }
}

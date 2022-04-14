package HOT100题;

public class 不同路径_动态规划 {
    public static void main(String[] args) {
        System.out.println("结果:" + uniquePaths(3, 7));
    }

    /**
     * dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * dp[0][...] = 1
     * dp[...][0] = 1
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.println("dp矩阵:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[m-1][n-1];
    }

}

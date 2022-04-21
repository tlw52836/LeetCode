package 图解算法数据结构.动态规划;

import java.util.Arrays;

public class 礼物的最大价值 {
    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{{1, 2, 5}, {3, 2, 1}}));
    }

    public static int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];  //dp[i][j]表示到位置(i, j)处可获得的礼物最大价值

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 && j != 0)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                else if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else if (i == 0)
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                else
                    dp[i][j] = dp[i-1][j] + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

}

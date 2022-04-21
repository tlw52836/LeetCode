package 图解算法数据结构.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n个骰子的点数 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dicesProbability(2)));
    }

    /**
     * 动态规划：dp[i][j]表示前i个骰子掷出每个点数的概率
     * @param n
     * @return
     */
    public static double[] dicesProbability(int n) {
        double[][] dp = new double[n+1][6*n+1];
        Arrays.fill(dp[1],1.0/6);

        for (int i = 2; i <= n; i++) {
            for (int j = i-1; j <= 6*(i-1); j++) {
                dp[i][j+1] += 1.0/6 * dp[i-1][j];
                dp[i][j+2] += 1.0/6 * dp[i-1][j];
                dp[i][j+3] += 1.0/6 * dp[i-1][j];
                dp[i][j+4] += 1.0/6 * dp[i-1][j];
                dp[i][j+5] += 1.0/6 * dp[i-1][j];
                dp[i][j+6] += 1.0/6 * dp[i-1][j];
            }
        }

        double[] res = new double[6*n-n+1];
        for (int i = n; i <= 6*n; i++) {
            res[i-n] = dp[n][i];
        }
        return res;
    }
}

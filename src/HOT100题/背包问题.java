package HOT100题;

public class 背包问题 {
    public static void main(String[] args) {
        int w[] = {0,1,2,3,5,3};
        int v[] = {0,6,5,8,15,3};
        int bagW = 20;
        System.out.println(getMaxValue(w, v, bagW));
    }

    public static int getMaxValue (int[] w, int[] v,int bagW) {
        int n = w.length-1;
        int[][] dp = new int[n+1][bagW+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= bagW; j++) {
                if (j >= w[i])
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]] + v[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][bagW];
    }
}

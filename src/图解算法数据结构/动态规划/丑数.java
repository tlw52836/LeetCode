package 图解算法数据结构.动态规划;

public class 丑数 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber2(10));
    }


    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];  //dp[i]表示第i个丑数
        int a, b, c;  //记录
        boolean flag1, flag2, flag3;

        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            flag1 = true;
            flag2 = true;
            flag3 = true;

            a = 0;
            b = 0;
            c = 0;

            for (int j = 0; j < i; j++) {
                if (2*dp[j] > dp[i-1] && flag1) {
                    flag1 = false;
                    a = 2 * dp[j];
                }

                if (3*dp[j] > dp[i-1] && flag2) {
                    flag2 = false;
                    b = 3 * dp[j];
                }

                if (5*dp[j] > dp[i-1] && flag3) {
                    flag3 = false;
                    c = 5 * dp[j];
                }
            }

            a = Math.min(a,b);
            a = Math.min(a, c);
            dp[i] = a;
        }

        return dp[n-1];
    }


    /**
     * 优化
     * @param n
     * @return
     */
    public static int nthUglyNumber2(int n) {
        int[] dp = new int[n];  //dp[i]表示第i个丑数
        int a = 0, b = 0, c = 0;  //分别指向当前*2 *3 *5的最小数
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int n1 = 2 * dp[a];
            int n2 = 3 * dp[b];
            int n3 = 5 * dp[c];

            dp[i] = Math.min(Math.min(n1, n2), n3);

            if (dp[i] == n1)
                a++;
            if (dp[i] == n2)
                b++;
            if (dp[i] == n3)
                c++;
        }

        return dp[n-1];
    }
}

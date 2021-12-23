public class 回文子串 {
    public static void main(String[] args) {
        String s = "fdsklf";
        System.out.println(countSubstrings(s));
    }

    /**
     * 动态规划
     * dp[i][j]表示s[i...j]是否是回文串
     * 则dp[i][j] = (s[i] == s[j]) & dp[i-1][j-1]
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] ss = s.toCharArray();
        int res = 0;

        for (int i = 0; i < ss.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (ss[i] == ss[j]) {
                    if (i-j <= 2 || dp[j+1][i-1]) {
                        dp[j][i] = true;
                        res++;
                    }
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return res;
    }
}

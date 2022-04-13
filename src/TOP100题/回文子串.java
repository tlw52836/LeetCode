package TOP100题;

import java.util.Arrays;

public class 回文子串 {
    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println(countSubstrings(s));
    }

    /**
     * 动态规划
     * dp[i][j]表示s[i...j]是否是回文串
     * 则dp[i][j] = (s[i] == s[j]) & dp[i+1][j-1]
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] ss = s.toCharArray();
        int res = 0;

        for (int j = 0; j < ss.length; j++) {
            for (int i = 0; i <= j; i++) {
                if (ss[i] == ss[j]) {
                    if (j-i <= 2 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}

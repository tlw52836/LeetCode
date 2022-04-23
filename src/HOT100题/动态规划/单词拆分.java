package HOT100题.动态规划;

import java.util.*;

public class 单词拆分 {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<String>(){{
            add("leet");
            add("code");
        }};
        System.out.println(wordBreak("leetcode",wordDict));
    }

    /**
     * dp[i] 表示 s的前i位是否可以用 wordDict中的单词表示
     * dp[i] = {dp[0] && wordDict.contains(s[1...n]), dp[1] && wordDict.contains(s[2...n]),...,dp[n]}
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {

       Set<String> set = new HashSet<>(wordDict);
       boolean[] dp = new boolean[s.length()+1];
       dp[0] = true;
       int n = s.length();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (dp[j-1] && set.contains(s.substring(j-1,i)))
                    dp[i] = true;
            }
        }

        return dp[n];
    }
}

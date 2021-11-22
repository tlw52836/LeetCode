import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 单词拆分 {
    public static void main(String[] args) {
        System.out.println(wordBreak("leetcode", Arrays.asList(new String[]{"leet", "code"})));
    }

    /**
     * 动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        /**
         * dp[0] = true
         * dp[t] 存放是s[0...t-1]是否可用字典表示
         */
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                /**
                 * dp[j] = dp[i] && wordDict.contains(s.substring(i, j))
                 */
                if (dp[i] && wordDict.contains(s.substring(i, j)))
                    dp[j] = true;
            }
        }

        return dp[s.length()];
    }
}

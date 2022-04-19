package 图解算法数据结构.动态规划;

import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        System.out.println("res:" +lengthOfLongestSubstring("dvdf"));
    }

    /**
     * dp[i]表示以字母s[i]为结尾的最长不含重复字符的子字符串长度
     * dp[i] = dp[i-1]+1（以s[i-1]为结尾的最长不含重复字符的子字符串不包含s[i]） || 1
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0)
            return 0;

        int max;
        int[] dp = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();

        dp[0] = 1;
        map.put(s.charAt(0), 0);
        max = 1;

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.getOrDefault(ch, -1) >= (i-dp[i-1])) {
                dp[i] = i - map.get(ch);
            } else {
                dp[i] = dp[i-1] + 1;
                max = Math.max(max, dp[i]);
            }
            map.put(ch, i);
        }
        return max;
    }

}

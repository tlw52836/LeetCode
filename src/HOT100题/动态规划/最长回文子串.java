package HOT100题.动态规划;

public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println("result:" + longestPalindrome(s));
    }

    /**
     * 动态规划：
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];  //标记s[i..j]是否为回文串
        char[] ch = s.toCharArray();

        //记录最长回文串的开始与结束序号
        int begin = 0, end = 0;
        int maxLen = 0;


        for (int j = 0; j < len; j++) {
            for (int i = 0; i <= j; i++) {
                //若ch[j] != ch[i]则s[i...j]不是回文串
                if (ch[i] != ch[j]) {
                    continue;
                } else {
                    //若ch[i] == ch[j]，且在3个字符以内，则s[i...j]必是回文串
                    if (j-i <= 2 || dp[i+1][j-1]) {
                        if (j-i+1 > maxLen) {
                            begin = i;
                            end = j;
                            maxLen = j-i+1;
                        }
                        dp[i][j] = true;
                    } else {
                        continue;
                    }
                }
            }
        }

        return s.substring(begin, end+1);
    }
}

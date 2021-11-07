import java.util.*;

public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "a";
        System.out.println("result:" + longestPalindrome(s));
    }

    /**
     * 动态规划：
     * f(i) 表示s[0...i]中最长回文子串，f(i+1) = Math.length(f(i),is_Palindrome(s[0...i+1]),is_Palindrome(s[1...i+]),is_Palindrome(s[2...i+1])...)
     * 其中s[0...i+1],s[1...i+],s[2...i+1]...即新添加的字串
     * 二位数组dp[i][j]用于标记s[i...j]是否为回文串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];  //标记s[i..j]是否为回文串
        //记录最长回文串的开始与结束序号
        int begin = 0, end = 0;
        int l = 0;

        char[] ch = s.toCharArray();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (ch[i] != ch[j]) {
                    continue;
                } else {
                    if (i-j <= 2 || dp[j+1][i-1] == 1) {
                        if (i-j+1 > l) {
                            begin = j;
                            end = i;
                            l = i-j+1;
                        }
                        dp[j][i] = 1;
                        System.out.println("---------------");
                        System.out.println("i = " + i + " j = " + j);
                        System.out.println("begin = " + begin + " end = " + end);
                        for (int k = 0; k < len; k++) {
                            System.out.println(Arrays.toString(dp[k]));
                        }

                    } else {
                        continue;
                    }
                }
            }
        }

        return s.substring(begin, end+1);
    }
}

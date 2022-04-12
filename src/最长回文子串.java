public class 最长回文子串 {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println("result:" + longestPalindrome(s));
    }


    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        char[] ss = s.toCharArray();
        int i, j;  //左右指针
        int maxLen = 0;
        String res = "";

        for (int k = 0; k < ss.length; k++) {

            i = k;
            j = k;

            //若左边字符与中心点相等则左移左指针
            while ((i-1) >= 0 && ss[i-1] == ss[k])
                i--;

            //若右边字符与中心点相等则右移右指针
            while ((j+1) < ss.length && ss[j+1] == ss[k])
                j++;

            //若左边字符与右边字符相等，则分别向两边移动左右指针
            while ((i-1) >= 0 && (j+1) < ss.length && ss[i-1] == ss[j+1]) {
                i--;
                j++;
            }
            if (j-i+1 > maxLen) {
                maxLen = j-i+1;
                res = s.substring(i,j+1);
            }

        }

        return res;
    }


    /**
     * 动态规划：
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
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

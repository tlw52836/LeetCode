package HOT100题;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串_回溯 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    /**
     * dfs + 回溯 + 动态规划
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];  //标记s[i..j]是否为回文串
        char[] ch = s.toCharArray();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                //若ch[i] != ch[j]则s[i...j]不是回文串
                if (ch[i] != ch[j]) {
                    continue;
                } else {
                    //若ch[i] == ch[j]，且在3个字符以内，则s[i...j]必是回文串
                    if (i-j <= 2 || dp[j+1][i-1])
                        dp[j][i] = true;
                     else
                        continue;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        List<String> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        dfs (list, res, dp, s, 0);

        return res;
    }

    /**
     * pos用于记录每个s在起始串中的位置
     * @param list
     * @param res
     * @param dp
     * @param s
     * @param pos
     */
    public static void dfs(List<String> list, List<List<String>> res,  boolean[][]dp, String s, int pos) {
        if (s.length() == 0)
            res.add(new ArrayList<>(list));

        for (int i = 1; i <= s.length(); i++) {
            //剪枝
            if (!dp[pos][pos+i-1])
                continue;

            list.add(s.substring(0, i));
            dfs(list, res, dp, s.substring(i, s.length()), pos+i);
            //回溯
            list.remove(list.size()-1);
        }
    }
}

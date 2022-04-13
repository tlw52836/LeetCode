package TOP100题;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串_dfs_回溯_动态规划 {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    /**
     * dfs + 回溯
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        dfs (list, res, s);

        return res;
    }

    public static void dfs(List<String> list, List<List<String>> res,  String s) {
        if (s.length() == 0)
            res.add(new ArrayList<>(list));

        for (int i = 1; i <= s.length(); i++) {
            //剪枝
            if (!isPalind(s.substring(0, i)))
                continue;

            list.add(s.substring(0, i));
            dfs(list, res, s.substring(i, s.length()));
            //回溯
            list.remove(list.size()-1);
        }
    }

    public static boolean isPalind(String s) {
        char[] ss = s.toCharArray();
        int i = 0;
        int j = ss.length-1;
        while (i < j) {
            if (ss[i] != ss[j])
                return false;
            i++;
            j--;
        }
        return true;
    }
}

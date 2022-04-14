package HOT100题;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        dfs (list, res, n, k, 1);

        return res;
    }

    public static void dfs(List<Integer> list, List<List<Integer>> res, int n, int k, int begin) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i <= n; i++) {
            list.add(i);
            dfs(list, res, n, k, i+1);
            list.remove(list.size()-1);
        }
    }
}

package HOT100题.排列组合;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    /**
     * 无重复元素的数组（元素不可重复使用），返回k个数的组合
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(n, k, res, list, 1);
        return res;
    }

    //begin字段控制能不能重复使用元素
    public static void dfs(int n, int k, List<List<Integer>> res, List<Integer> list, int begin) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        //一个for循环代表一层
        for (int i = begin; i <= n; i++) {
            list.add(i);
            dfs(n, k, res, list, i+1);  //下一层传入这一层的begin+1(i+1)，表示不可以重复使用该元素
            list.remove(list.size()-1);
        }
    }
}

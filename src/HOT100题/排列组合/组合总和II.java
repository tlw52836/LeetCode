package HOT100题.排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates, 8));
    }

    /**
     * 有重复元素的数组（元素不可以重复使用），返回和为target的组合
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //排序后，使得可以剪枝
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, res, list, 0);
        return res;
    }

    //begin字段控制能不能重复使用元素
    public static void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> list, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        //一个for循环代表一层
        for (int i = begin; i < candidates.length; i++) {
            //同一层元素不能重复,重复则剪枝（基于排序后）
            if (i > begin && candidates[i-1] == candidates[i])
                continue;

            //排序后便可以剪枝
            if (target - candidates[i] < 0)
                return;

            target = target - candidates[i];
            list.add(candidates[i]);
            dfs(candidates, target, res, list, i+1); //下一层传入这一层的begin+1(i+1)，表示不可以重复使用该元素
            list.remove(list.size()-1);
            target = target + candidates[i];
        }
    }
}

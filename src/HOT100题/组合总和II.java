package HOT100题;

import java.util.*;

public class 组合总和II {
    public static void main(String[] args) {
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 30;
        System.out.println(combinationSum2(candidates, target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] visit = new int[candidates.length];

        //对数组进行排序，剪枝的关键
        Arrays.sort(candidates);

        dfs(candidates, target, res, visit, list, 0);

        return new ArrayList<>(res);
    }

    /**
     * dfs + 回溯
     * @param candidates
     * @param target
     * @param res
     * @param visit
     * @param list
     */
    public static void dfs(int[] candidates, int target, List<List<Integer>> res, int[] visit, List<Integer> list, int begin) {
        if (target == 0){
            System.out.println(list);
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i-1])
                continue;
            //剪枝1
            if (target - candidates[i] < 0)
                return;

            list.add(candidates[i]);
            dfs(candidates, target-candidates[i], res, visit, list, i+1);
            //回溯
            list.remove(list.size()-1);
        }
    }
}

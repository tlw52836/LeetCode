import java.util.*;

public class 组合总和II {
    public static void main(String[] args) {
        int[] candidates = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int target = 27;
        System.out.println(combinationSum2(candidates, target));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] visit = new int[candidates.length];

        //对数组进行排序，剪枝的关键
        Arrays.sort(candidates);

        dfs(candidates, target, res, visit, list);
        res = remove(res);

        return res;
    }

    /**
     * dfs + 回溯
     * @param candidates
     * @param target
     * @param res
     * @param visit
     * @param list
     */
    public static void dfs(int[] candidates, int target, List<List<Integer>> res, int[] visit, List<Integer> list) {
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            //剪枝1
            if (target - candidates[i] < 0)
                return;
            //剪枝2
            if (visit[i] == 1)
                continue;

            visit[i] = 1;
            list.add(candidates[i]);
            dfs(candidates, target-candidates[i], res, visit, list);
            //回溯
            list.remove(list.size()-1);
            visit[i] = 0;
        }
    }

    /**
     * 去除重复元素
     */
    public static List<List<Integer>> remove(List<List<Integer>> res) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < res.size(); i++) {
            Object[] array = res.get(i).toArray();
            Arrays.sort(array);
            set.add(new ArrayList(Arrays.asList(array)));
        }
        return new ArrayList<>(set);
    }
}

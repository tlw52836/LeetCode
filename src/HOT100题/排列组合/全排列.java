package HOT100题.排列组合;

import java.util.ArrayList;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    /**
     * 无重复元素的数组，全排列
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        dfs(nums, res, list, visit);
        return res;
    }


    //visit用于记录前面层已经访问过的元素
    public static void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visit) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        //一个for循环代表一层
        for (int i = 0; i < nums.length; i++) {
            if (visit[i])
                continue;
            visit[i] = true;
            list.add(nums[i]);
            dfs(nums, res, list, visit);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }
}

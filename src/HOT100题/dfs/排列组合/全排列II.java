package HOT100题.dfs.排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 全排列II {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(permuteUnique(nums));
    }


    /**
     * 有重复元素的数组，全排列
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            //同一层元素不能重复,重复则剪枝（基于排序后）
            if (i > 0 && visit[i-1] && nums[i] == nums[i-1])
                continue;

            if (visit[i])
                continue;

            visit[i] = true;
            list.add(nums[i]);
            dfs(nums, res, list, visit);
            list.remove(list.size()-1);
            visit[i] = false;
        }
    }
}

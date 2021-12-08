import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 全排列II {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> res = new HashSet<>();
        boolean[] visit = new boolean[nums.length];

        dfs (list, res, visit, nums);

        return new ArrayList<>(res);
    }

    /**
     * 去重方式一：利用Set 方式二：标记同一层访问过的点
     * @param list
     * @param res
     * @param visit
     * @param nums
     */
    public static void dfs(List<Integer> list, Set<List<Integer>> res,boolean[] visit, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        boolean[] flag = new boolean[nums.length];  //去重：标记同一层中已经访问过的点
        for (int i = 0; i < nums.length; i++) {
            //剪枝
            if (visit[i] == true) {
                flag[i] = true;
                continue;
            }

            //去除重复元素
            if (i > 0 && flag[i-1] && nums[i] == nums[i-1])
                continue;

            visit[i] = true;
            list.add(nums[i]);
            dfs(list, res, visit, nums);
            //回溯
            list.remove(list.size()-1);
            visit[i] = false;
        }
    }
}

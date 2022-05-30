package HOT100题.dfs.排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
    }


    /**
     * 无重复元素的数组（元素可以重复使用），返回和为target的组合
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序后，使得可以剪枝
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, res, list, 0);
        return res;
    }

    //begin字段控制能不能重复使用元素
    public static void dfs(int[] candisates, int target, List<List<Integer>> res, List<Integer> list, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        //一个for循环代表一层
        for (int i = begin; i < candisates.length; i++) {
            //排序后便可以剪枝
            if (target - candisates[i] < 0)
                return;
            target = target -candisates[i];
            list.add(candisates[i]);
            dfs(candisates, target, res, list, i);  //下一层依然传入这一层begin(i)，表示可以重复使用该元素
            list.remove(list.size()-1);
            target = target + candisates[i];
        }

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        for (List<Integer> l:res) {
            System.out.println(l);
        }
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */

    public static List<List<Integer>> subsets(int[] nums) {

        //初始化
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList( new Integer[]{nums[0]}));
        
        for (int i = 1; i < nums.length; i++) {

            int len = res.size();
            for (int j = 0; j < len; j++) {
                List<Integer> list = new ArrayList<>(res.get(j));
                list.add(nums[i]);
                res.add(list);
            }
            res.add(Arrays.asList( new Integer[]{nums[i]}));
        }

        res.add(new ArrayList<>());

        return res;
    }
}

package TOP100题;

import java.util.ArrayList;
import java.util.List;

public class 统计按位或能得到最大值的子集数目 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5};
        Solution s = new Solution();
        System.out.println(s.countMaxOrSubsets(nums));
    }

   static class Solution {
        private int res = 0;
        private int desc = 0;

        public int countMaxOrSubsets(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                desc = nums[i] | desc;
            }

            for (int i = 1; i <= nums.length; i++) {
                List<Integer> list = new ArrayList<>();
                dfs(nums, i, list, 0);
            }

            return res;
        }

        public void dfs (int[] nums, int n, List<Integer> list, int begin) {
            if (list.size() == n) {
                int t = 0;
                for (int i = 0; i < n; i++) {
                    t = list.get(i) | t;
                }
                if (desc == t)
                    res ++;
                return;
            }

            for (int i = begin; i < nums.length; i++) {
                list.add(nums[i]);
                dfs (nums, n, list, i+1);
                list.remove(list.size()-1);
            }
        }
   }

}

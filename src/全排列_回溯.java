import java.util.ArrayList;
import java.util.List;

public class 全排列_回溯 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Solution().permute(nums));

    }

    static class Solution{
        private int[] nums;
        private int[] visit;  //记录是否访问过
        private List<List<Integer>> results;  //保存结果

        /**
         * dfs + 回溯
         * @param nums
         * @return
         */
        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            this.visit = new int[nums.length];
            this.results = new ArrayList<>();

            //用于存放排列结果
            for (int i = 0; i < nums.length; i++) {
                visit[i] = 1;
                List<Integer> list = new ArrayList<>();  //保存目前访问过的路径
                list.add(nums[i]);

                dfs(list);

                /**
                 * 回溯
                 */
                list.remove(list.size()-1);
                visit[i] = 0;
            }
            return results;
        }

        public void dfs(List list) {
            //System.out.println("list:" + list);
            if(list.size() == nums.length) {
                results.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                /**
                 * 剪枝
                 */
                if (visit[i] == 1) {
                    continue;
                } else {
                    visit[i] = 1;
                    list.add(nums[i]);
                    dfs(list);
                    /**
                     * 回溯
                     */
                    list.remove(list.size()-1);
                    visit[i] = 0;
                }
            }
        }
    }
}

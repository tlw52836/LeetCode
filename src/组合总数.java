import java.util.*;

public class 组合总数 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution().combinationSum(candidates, target));
    }

    static class Solution {
        private int[] candidates;
        private List<List<Integer>> result;  //存放结果
        private Stack<Integer> s;  //存放中间结果

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.candidates = candidates;
            this.result = new ArrayList<>();
            this.s = new Stack<>();

            dfs(target);

            remove();

            return result;
        }

        public void dfs(int target) {
            if (target == 0) {
                result.add(new ArrayList<>(s));
                return;
            }

            for (int i = 0; i < candidates.length; i++) {
                /**
                 * 剪枝
                 */
                if (target - candidates[i] < 0) {
                    return;
                } else {
                    s.push(candidates[i]);
                    dfs(target - candidates[i]);
                    s.pop();
                }
            }
        }

        /**
         * 移除重复元素
         */
        public void remove() {
            Set<Integer>
            for (int i = 0; i < result.size(); i++) {
                Object[] objects = result.get(i).toArray();
                Arrays.sort(objects);
                List list = new ArrayList(Arrays.asList(objects));

                result.set(i,list);
            }
        }
    }
}

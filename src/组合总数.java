import java.util.*;

public class 组合总数 {
    public static void main(String[] args) {
        int[] candidates = {10, 7, 6, 3, 5, 1};
        int target = 9;
        System.out.println(new Solution().combinationSum(candidates, target));
    }

    static class Solution {
        private int[] candidates;
        private List<List<Integer>> result;  //存放结果
        private Stack<Integer> s;  //存放中间结果

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
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
                    return;  //方式一：Arrays.sort(candidates) + return   方式二：continue,该方式不能剪枝，导致效率低下
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
            Set<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < result.size(); i++) {
                Object[] objs = result.get(i).toArray();
                Arrays.sort(objs);
                List list = new ArrayList<>(Arrays.asList(objs));
                set.add(list);
            }
            result = new ArrayList<>(set);
        }
    }
}

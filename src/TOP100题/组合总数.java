package TOP100题;

import java.util.*;

public class 组合总数 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(new Solution().combinationSum(candidates, target));
    }

    static class Solution {
        private int[] candidates;
        private List<List<Integer>> result;  //存放结果
        private Stack<Integer> s;  //存放中间结果

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);  //排序以便于剪枝
            this.candidates = candidates;
            this.result = new ArrayList<>();
            this.s = new Stack<>();

            dfs(target, 0);

            return result;
        }

        public void dfs(int target, int begin) {  //使用begin来排除重复的结果
            if (target == 0) {
                result.add(new ArrayList<>(s));
                return;
            }

            for (int i = begin; i < candidates.length; i++) {
                /**
                 * 剪枝
                 */
                if (target - candidates[i] < 0) {
                    return;  //方式一：Arrays.sort(candidates) + return   方式二：continue,该方式不能剪枝，导致效率低下
                } else {
                    s.push(candidates[i]);
                    dfs(target - candidates[i], i);
                    s.pop();
                }
            }
        }
    }

}

import java.util.*;

public class 括号生成 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }

    static class Solution {
        private int n;
        private List<String> list;
        private int[] visit;
        private String s;

        public List<String> generateParenthesis(int n) {
            this.n = 2 * n;
            this.list = new ArrayList<>();
            this.visit = new int[this.n+1];
            this.s = "";

            Set<String> sets = new HashSet<>();
            for (int i = 1; i <= n ; i++) {
                if (i <= n/2) {
                    visit[i] = 1;
                    s += "(";
                    dfs(s, sets);
                    visit[i] = 0;
                } else {
                    visit[i] = 1;
                    s += ")";
                    dfs(s, sets);
                    visit[i] = 0;
                }

            }
            dfs("", sets);
            this.list = new ArrayList<>(sets);

//            for (int i = 0; i < list.size(); i++) {
//                if (!isValid(list.get(i))) {
//                    list.remove(i);
//                }
//            }

            return this.list;
        }

        /**
         * dfs + 回溯生成所有情形
         * @param s
         */
        public void dfs(String s, Set<String> sets) {
            /**
             * 满足条件
             */
            if (s.length() == n) {
                sets.add(s);
                s = "";  //重置
                return;
            }

            for (int i = 1; i <= n; i++) {
                /**
                 * 剪枝
                 */
                if(visit[i] == 1){
                    continue;
                }

                if (i <= n/2) {
                    visit[i] = 1;
                    s += "(";
                    dfs(s, sets);
                    visit[i] = 0;
                } else {
                    visit[i] = 1;
                    s += ")";
                    dfs(s, sets);
                    visit[i] = 0;
                }
            }
        }

        /**
         * 判断是否是有效括号
         * @param s
         * @return
         */
        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    if (stack.empty() || stack.pop() != '(') {
                        return false;
                    }
                }
            }

            if (!stack.empty()) {
                return false;
            }

            return true;
        }
    }
}

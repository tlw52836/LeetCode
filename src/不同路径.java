public class 不同路径 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(23, 12));
    }
    static class Solution {
        private static final int[][] direction = {{1, 0}, {0, 1}};
        private int m;
        private int n;
        private int res;

        public int uniquePaths(int m, int n) {
            this.m = m;
            this.n = n;
            this.res = 0;

            dfs(1,1);

            return res;
        }

        public void dfs(int a, int b) {

            /**
             * 到达目标值
             */
            if (a == m && b == n) {
                res++;
                //System.out.println("res:" + res);
                return;
            }


            for (int i = 0; i < direction.length; i++) {
                a = a + direction[i][0];
                b = b + direction[i][1];
                //System.out.println("a,b:" + a + " " + b);

                /**
                 *剪枝
                 */
                if (a > m || b > n) {
                    a = a - direction[i][0];
                    b = b - direction[i][1];
                   continue;
                }

                dfs(a, b);

                /**
                 * 回溯
                 */
                a = a - direction[i][0];
                b = b - direction[i][1];

            }
        }
    }
}

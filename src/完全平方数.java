public class 完全平方数 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(12));
    }


    static class Solution {
        private int res = -1;

        public int numSquares(int n) {
            int m = (int) Math.sqrt(n);
            dfs(m, n, 0);
            return res;
        }

        public void dfs(int m, int n, int count) {
            if (n == 0) {
                if (count < res)
                    res = count;
            }

            for (int i = m; i >= 1; i--) {
                if (!isSquare(m) || n-m*m < 0)
                    continue;

                dfs(m,n-m*m, count+1);
            }
        }

        public boolean isSquare(int num) {
            double a = Math.sqrt(num);
            int b = (int) a;
            double c = a - b;
            if (c != 0)
                return false;
            return true;
        }
    }


}

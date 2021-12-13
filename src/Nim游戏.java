public class Nim游戏 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canWinNim(4));
    }
    static class Solution {
        private boolean res = false;
        public boolean canWinNim(int n) {
            dfs(n, 1);
            return res;
        }


        public void dfs(int n, int person) {

            if (n >= 1 && n <= 3) {
                if (person == 1)
                    res = true;
                return;
            }

            for (int i = 3; i >= 1 && res == false; i--) {
                if (n - i < 0)
                    continue;
                dfs (n-i, person % 2 + 1);
            }
        }
    }
}

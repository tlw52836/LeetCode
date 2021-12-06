import java.util.Stack;

public class 零钱兑换 {

    static class Solution {
        private int res = -1;
        private int count = 0;


        public int coinChange(int[] coins, int amount) {
            return 0;
        }


        public void dfs(int[] coins, int amount){
            for (int i = coins.length-1; i >= 0; i--) {
                if (amount - coins[i] == 0) {
                    count++;
                    return;
                }
                else if (amount - coins[i] > 0) {
                    dfs(coins,amount - coins[i]);
                }

                else
                    continue;

            }
        }
    }

}

package HOT100题;

import java.util.Arrays;

public class 零钱兑换 {
    public static void main(String[] args) {
        int[] coins = {411,412,413,414,415,416,417,418,419,420,421,422};
        int amount = 9864;
        Solution s = new Solution();
        System.out.println(s.coinChange(coins, amount));
    }

//    static class Solution {
//        private int res = Integer.MAX_VALUE;
//
//        public int coinChange(int[] coins, int amount) {
//            Arrays.sort(coins);
//            List<List<Integer>> list = new ArrayList<>();
//            dfs(coins, amount, 0, list, coins.length-1);
//            return res == Integer.MAX_VALUE ? -1 : res;
//        }
//
//
//        public void dfs(int[] coins, int amount, int count, List<List<Integer>> list, int depth) {
//            if (amount == 0) {
//                System.out.println(list);
//                if (count < res)
//                    res = count;
//                return;
//            }
//
//            if (depth < 0)
//                return;
//
//            for (int i = amount/coins[depth]; i >= 0; i--) {
//
//                //剪枝
//                if (count+i >= res) {
//                    return;
//                }
//                List<Integer> l = new ArrayList<>();
//                l.add(i);
//                l.add(coins[depth]);
//
//                list.add(l);
//                dfs(coins, amount-coins[depth]*i, count+i, list, depth-1);
//                list.remove(list.size()-1);
//            }
//        }
//    }

    static class Solution {
        private int res = Integer.MAX_VALUE;

        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            dfs(coins, amount, 0, coins.length-1);
            return res == Integer.MAX_VALUE ? -1 : res;
        }


        public void dfs(int[] coins, int amount, int count, int depth) {
            if (amount == 0) {
                if (count < res)
                    res = count;
                return;
            }

            if (depth < 0)
                return;

            for (int i = amount/coins[depth]; i >= 0; i--) {

                //剪枝
                if (count+i >= res) {
                    return;
                }
                dfs(coins, amount-coins[depth]*i, count+i, depth-1);
            }
        }
    }

}

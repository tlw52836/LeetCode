package 初级算法.数组;

public class 买卖股票的最佳时机II {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;

        int res = 0;
        int t = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i-1]) {
                if (i == prices.length-1)
                    res += (prices[i] - t);
                else
                    continue;
            }
            else {
                res += (prices[i-1] - t);
                t = prices[i];
            }
        }
        return res;
    }
}

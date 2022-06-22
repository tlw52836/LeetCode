package 剑指OfferII.动态规划;

public class 房屋偷盗 {
    /**
     * dp[i]前i个房间能偷盗的最大金额
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        int a = nums[0];  //dp[i-2]
        int b = Math.max(nums[0], nums[1]);  //dp[i-1]
        int res = b;
        for (int i = 2; i < nums.length; i++) {
           int c = Math.max(nums[i]+a, b);
           a = b;
           b = c;
           res = Math.max(res, c);
        }
        return res;
    }
}

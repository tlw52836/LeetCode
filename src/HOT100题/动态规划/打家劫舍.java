package HOT100题.动态规划;

public class 打家劫舍 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }

    /**
     * dp[i]表示以房屋i为偷窃结尾目标的最大偷窃额度
     * dp[i] = max(dp[i-2]+nums[i], dp[i])
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int dp1 = 0;
        int dp2 = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = dp2;

            dp2 = Math.max(dp1+nums[i], dp2);
            dp1 = temp;
        }

        return dp2;
    }

}

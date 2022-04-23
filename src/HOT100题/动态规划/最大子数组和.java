package HOT100题.动态规划;

public class 最大子数组和 {
    public static void main(String[] args) {
        System.out.println(maxSubArray2(new int[]{5,4,-1,7,8}));
    }

    /**
     * dp[i]为以nums[i]为结尾的最大子数组和
     * dp[i] = max(dp[i-1] + nums[i], nums[i])
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {

        int[] dp = new int[nums.length];
        int maxSum = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }


    /**
     * 空间优化
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {

        int maxSum = nums[0];
        int a = nums[0];

        for (int i = 1; i < nums.length; i++) {
            a = Math.max(a + nums[i], nums[i]);
            maxSum = Math.max(maxSum, a);
        }

        return maxSum;
    }
}

package 图解算法数据结构.动态规划;

public class 连续子数组的最大和 {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, -2}));
    }

    /**
     * dp[i]表示以nums[i]结尾的最大连续子数组
     * dp[i] = max{dp[i-1]+nums[i], nums[i]}
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];  //记录nums[i...j]的和
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i-1] > 0 ? dp[i-1]+nums[i]:nums[i];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

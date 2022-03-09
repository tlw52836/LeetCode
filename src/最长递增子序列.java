public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }


    /**
     * 动态规划
     * dp[i]表示以nums[i]为结尾的最长递增子序列长度
     * dp[i] = max(dp[j])+1  i > j,dp[i] > dp[j]
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max,dp[j]+1);
                }
            }
            dp[i] = max;
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}

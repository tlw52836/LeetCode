package HOT100题.动态规划;

public class 最长递增子序列 {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }

    /**
     * 动态规划
     * dp[i]表示以nums[i]为结尾的最长递增子序列长度
     * dp[i] = max(dp[j])+1  i > j,dp[i] > dp[j]
     * @param nums
     * @return
     */

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length+1];
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    temp = Math.max(temp, dp[j]+1);
                }
            }

            dp[i] = temp;
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}

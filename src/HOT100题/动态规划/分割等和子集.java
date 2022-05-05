package HOT100题.动态规划;


public class 分割等和子集 {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 5}));
    }

    /**
     * dp[i][j]表示前i个数据是否能找出和为j
     * dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j]
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num:nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;

        int target = sum / 2;

        boolean[][] dp = new boolean[nums.length+1][target+1];
        dp[0][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i-1] <= j)
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[nums.length][target];
    }
}

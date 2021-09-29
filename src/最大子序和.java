public class 最大子序和 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    /**
     * 动态规划：最优子结构、重叠子问题
     * f[i] = max(f[i-1]+num[i],nums[i])  //f[i-1]表示以nums[i-1]为结束点的最大子序列和
     * @param nums
     * @return
     */

    public static int maxSubArray(int[] nums) {
        int preMaxSum = 0;
        int maxSum = nums[0];  //用于保存最大子序列和
        for (int i = 0; i < nums.length; i++) {
            preMaxSum = Math.max(preMaxSum + nums[i],nums[i]);
            maxSum = Math.max(maxSum,preMaxSum);
        }
        return maxSum;
    }
}

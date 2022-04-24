package HOT100题.动态规划;

public class 乘积最大子数组 {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-4,-3,-2}));
    }

    /**
     *
     * dp1[i]为以nums[i]为结尾的乘积最大子数组的积
     * dp2[i]为以nums[i]为结尾的乘积最小子数组的积
     * dp1[i] = max(dp1[i-1]*nums[i], dp2[i-1]*nums[i], nums[i])
     * @param nums
     * @return
     */

    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int max = nums[0];  //以nums[i]为结尾的乘积最大子数组的积
        int min = nums[0];  //记录以nums[i]为结尾的乘积最小子数组的积


        for (int i = 1; i < nums.length; i++) {
            int temp = max;

            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            maxProduct = Math.max(maxProduct, max);

            min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);
        }

        return maxProduct;
    }
}

public class 最大子序和 {
    public static void main(String[] args) {
        int[] nums = {-1,0,-2};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            int j = i + 1;
            while (j < nums.length) {
                sum += nums[j];
                if (sum > maxSum) {
                    maxSum = sum;
                }
                if(sum <= 0){
                    break;
                }
                j++;
            }
        }
        return maxSum;
    }
}

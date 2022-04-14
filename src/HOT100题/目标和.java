package HOT100题;

public class 目标和 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(findTargetSumWays(nums, 3));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        int res = 0;
        int[] sums = new int[(int) Math.pow(2, nums.length)];
        int[] dupls = new int[(int) Math.pow(2, nums.length)];  //存放所有和
        int sLen = 0;
        int dLen = 0;
        sums[sLen++] = nums[0];
        sums[sLen++] = -nums[0];

        int[] temp;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < sLen; j++) {
                dupls[dLen++] = sums[j] + nums[i];
                dupls[dLen++] = sums[j] - nums[i];
            }
            temp = sums;
            sums = dupls;
            dupls = temp;

            sLen = dLen;
            dLen = 0;
        }

        for (int sum:sums) {
            if (sum == target) {
                res++;
            }
        }

        return res;
    }
}

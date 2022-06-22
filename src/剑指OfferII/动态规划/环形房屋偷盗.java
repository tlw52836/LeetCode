package 剑指OfferII.动态规划;

public class 环形房屋偷盗 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,1,1}));
    }

    public static int rob(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        return Math.max(robRange(nums, 1, nums.length-1), robRange(nums, 0, nums.length-2));
    }

    public static int robRange(int[] nums, int start, int end) {
        if (end - start < 1)
            return nums[start];

        int a = nums[start], b = Math.max(nums[start], nums[start+1]);
        int res = Math.max(a, b);


        for (int i = start + 2; i <= end; i++) {
            int c = Math.max(nums[i] + a, b);
            a = b;
            b = c;
            res = Math.max(res, a);
            res = Math.max(res, b);

        }
        return res;
    }
}

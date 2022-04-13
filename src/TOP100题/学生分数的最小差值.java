package TOP100题;

import java.util.Arrays;

public class 学生分数的最小差值 {
    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 7};
        int k = 2;
        int res = minimumDifference(nums, k);
        System.out.println(res);
    }

    public static int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = k - 1;

        int res = Integer.MAX_VALUE;
        while (j < nums.length) {
            if (nums[j] - nums[i] < res)
                res = nums[j] - nums[i];
            i++;
            j++;
        }
        return res;
    }
}

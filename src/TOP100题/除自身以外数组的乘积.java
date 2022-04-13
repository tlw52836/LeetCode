package TOP100题;

import java.util.Arrays;

public class 除自身以外数组的乘积 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        nums = productExceptSelf(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] pre = new int[nums.length];
        int[] suf = new int[nums.length];

        pre[0] = 1;
        suf[nums.length-1] = 1;

        int sum = 1;
        for (int i = 0; i < nums.length-1; i++) {
            sum = sum * nums[i];
            pre[i+1] = sum;
        }

        sum = 1;
        for (int i = nums.length-1; i > 0; i--) {
            sum = sum * nums[i];
            suf[i-1] = sum;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = pre[i] * suf[i];
        }

        return nums;
    }
}

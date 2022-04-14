package 初级算法.数组;

import java.util.Arrays;

public class 移动零 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution s = new Solution();
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static class Solution {
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != 0){
                    nums[j++] = nums[i];
                }
            }

            while (j < nums.length) {
                nums[j++] = 0;
            }
        }
    }
}

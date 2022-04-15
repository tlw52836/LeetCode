package 初级算法.设计问题;

import java.util.*;

public class 打乱数组 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution s = new Solution(nums);
        for (int i = 0; i < 1; i++) {
            System.out.println(Arrays.toString(s.shuffle()));
        }
    }

 static class Solution {
        private int[] nums;
        private int[] initNums;

        public Solution(int[] nums) {
            initNums = Arrays.copyOf(nums,nums.length);  //创建一个新数组并且赋值
            this.nums = nums;
        }

        public int[] reset() {
            for (int i = 0; i < nums.length; i++) {  //将初始数组复制到nums
                nums[i] = initNums[i];
            }
            return nums;
        }

        public int[] shuffle() {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
               list.add(nums[i]);
            }

            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                int index = random.nextInt(list.size());
                nums[i] = list.get(index);
                list.remove(index);
            }
            return nums;
        }
    }
}

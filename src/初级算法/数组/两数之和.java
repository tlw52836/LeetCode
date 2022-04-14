package 初级算法.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(Arrays.toString(twoSum(nums, 3)));
        
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target-nums[i]) != null) {
                return new int[]{map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}

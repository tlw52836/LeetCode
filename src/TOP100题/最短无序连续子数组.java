package TOP100题;

import java.util.Arrays;

public class 最短无序连续子数组 {
    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }
    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int[] newNums = Arrays.copyOf(nums, len);
        Arrays.sort(newNums);

        int i = 0, j = len-1;

        while (i < len && nums[i] == newNums[i]) {
            i++;
        }

        if (i == len)
            return 0;

        while (j >= 0 && nums[j] == newNums[j]) {
            j--;
        }

        return j-i+1;
    }
}

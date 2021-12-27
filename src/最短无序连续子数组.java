import java.util.Arrays;

public class 最短无序连续子数组 {
    public static void main(String[] args) {
        int[] nums = {2,6,4,8,10,9,15};
        findUnsortedSubarray(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static int findUnsortedSubarray(int[] nums) {
        int res = 0;
        int i = 0;
        int j = nums.length-1;
        while (i < j) {
            while (i+1 < nums.length && nums[i] <= nums[i+1]) {
                i++;
            }

            while (j-1 > 0 && nums[j] >= nums[j-1]) {
                j--;
            }

            Arrays.sort(nums, i, j+1);
            res = j -i + 1;
        }

        return res;
    }
}

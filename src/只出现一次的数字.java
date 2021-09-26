import java.util.Arrays;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));

    }
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length) {
            if (i == nums.length - 1) {
                return nums[i];
            }
            if(nums[i] != nums[i+1])
                return nums[i];
            else
                i = i + 2;
        }
        return 0;
    }
}

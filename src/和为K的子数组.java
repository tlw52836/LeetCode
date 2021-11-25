import java.util.Arrays;

public class 和为K的子数组 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1};
        int k = 3;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                System.out.println("i,j:" + i + " " +j);
                sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += nums[l];
                    if (sum > k)
                        break;
                }

                System.out.println(sum);
                if (sum == k)
                    res++;


            }
        }

        return res;
    }
}

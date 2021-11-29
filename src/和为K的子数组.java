import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println("res:" + subarraySum(nums, k));
    }

    /**
     * 方法一：暴力法
     * @param nums
     * @param k
     * @return
     */
//    public static int subarraySum(int[] nums, int k) {
//        int sum = 0;
//        int res = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum == k)
//                    res++;
//            }
//        }
//
//        return res;
//    }


    /**
     * sum[i...j] = sum[1...j] - sum[1...i]
     * 令sum[i...j] = sum[1...j] - sum[1...i] = k 得 sum[1...i] = sum[1...j] - k
     * 利用map记录sum[1...i]的个数 即 key为sum[1...i]的值 value为个数
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int count = map.getOrDefault(sum-k, 0);
            res += count;

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return res;
    }
}

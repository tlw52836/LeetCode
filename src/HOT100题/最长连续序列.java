package HOT100题;

import java.util.HashSet;
import java.util.Set;

public class 最长连续序列 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,8,5,6,7,9,3,55,88,77,99,999999999};
        System.out.println(longestConsecutive(nums));
    }

    /**
     * 复杂度O(nlogn)
     * @param nums
     * @return
     */
//    public static int longestConsecutive(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//
//        Arrays.sort(nums);
//
//        int res = 1;
//        int preRes = 1;
//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i+1] == nums[i]+1){
//                preRes++;
//                if (preRes > res)
//                    res = preRes;
//            }
//            else if (nums[i+1] == nums[i])
//                continue;
//            else
//                preRes = 1;
//        }
//
//        return res;
//    }

    /**
     * 复杂度O(n)
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);

            if (nums[i] < min)
                min = nums[i];

            if (nums[i] > max)
                max = nums[i];
        }

        System.out.println(min + " " + max);
        int t = min;
        int res = 0;
        int preRes = 0;
        while (t <= max) {
            if (set.contains(t)) {
                preRes++;
                if (preRes > res)
                    res = preRes;
            }
            else {
                t =
                preRes = 0;
            }
            t++;
        }

        return res;
    }
}

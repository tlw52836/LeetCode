public class 乘积最大子数组 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }

    /**
     * 暴力法
     * @param nums
     * @return
     */
//    public static int maxProduct(int[] nums) {
//        int t;
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < nums.length; i++) {
//            t = 1;
//            for (int j = i; j < nums.length; j++) {
//                t *= nums[j];
//                if (t > max) {
//                    max = t;
//                }
//            }
//        }
//
//        return max;
//    }


    public static int maxProduct(int[] nums) {
        int t;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            t = 1;
            for (int j = i; j < nums.length; j++) {
                t *= nums[j];
                if (t > max) {
                    max = t;
                }
            }
        }

        return max;
    }
}

import java.util.Arrays;

public class 颜色分类 {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

//    public static void sortColors(int[] nums) {
//        int t;
//        for (int i = 0; i < nums.length-1; i++) {
//            for (int j = 0; j < nums.length-1-i; j++) {
//                if (nums[j] > nums[j+1]) {
//                    t = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = t;
//                }
//            }
//        }
//    }

    /**
     * 两次交换：第一次将0交换到前面，第二次将1交换到前面
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[j];
                nums[j++] = 0;
            }
        }

        for (int i = j; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[j];
                nums[j++] = 1;
            }
        }
    }
}

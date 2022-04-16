package 初级算法.其他;

public class 丢失的数字 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        System.out.println(missingNumber2(nums));
    }

    /**
     * 以空间换时间
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int[] index = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            index[nums[i]] = 1;
        }
        for (int i = 0; i < index.length; i++) {
            if (index[i] == 0)
                return i;
        }
        return -1;
    }


    /**
     * 数学的方法
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int total = (0 + n) * (n + 1) / 2;
        return total -sum;
    }

}

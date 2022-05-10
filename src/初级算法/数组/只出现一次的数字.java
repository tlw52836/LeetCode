package 初级算法.数组;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));

    }

    /**
     * a表示任何数
     * 0 ^ a = a
     * a ^ a = 0
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}

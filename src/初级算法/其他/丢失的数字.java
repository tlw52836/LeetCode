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

    /**
     * 找缺失数 、找出现一次数都是异或的经典应用
     * 我们可以先求得[1, n]的异或和ans  然后用ans对各个nums[i]进行异或
     * 这样最终得到的异或和表达式中，只有缺失元素出现次数为 1 次，其余元素均出现两次（x ⊕x = 0x⊕x=0）  即最终答案ans为缺失元素
     * @param nums
     * @return
     */

    public static int missingNumber3(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i <= n; i++) {
            ans ^= i;
        }
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

}

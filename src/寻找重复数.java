import java.util.Arrays;

public class 寻找重复数 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }
    public static int findDuplicate(int[] nums) {
        int l = 1, r = nums.length-1;
        int mid;
        int count;
        int flag = -1;

        while (l <= r) {
            mid = (l + r) / 2;
            count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    count++;
            }

            if (count <= mid) {
                l = mid + 1;
            }
            else {
                r = mid  - 1;
                flag = mid;
            }
        }
        return flag;
    }
}

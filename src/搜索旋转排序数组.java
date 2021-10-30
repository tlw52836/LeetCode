import java.util.ArrayList;
import java.util.List;

public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }
    public static int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        int mid = (l + r) / 2;
        while (l <= r) {
            System.out.println("mid:" + mid);
            if ((nums[mid] > target && nums[l] <= target) || (nums[mid] < target && nums[r] < target)) {  //向左搜索
                r = mid -1;
                mid = (l + r) / 2;
            } else if ((nums[mid] > target && nums[l] > target) || (nums[mid] < target && nums[r] >= target)) {   //向右搜索
                l = mid + 1;
                mid = (l + r
                ) / 2;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

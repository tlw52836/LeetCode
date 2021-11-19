import java.util.ArrayList;
import java.util.List;

public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,3));
    }


    /**
     * 二分法：将nums[mid]与nums[l]进行比较以判断nums[l...mid],nums[mid...r]那个是有序数列，再进行后续判断
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        int mid;

        while (l <= r) {
            mid = (l + r) / 2;
            System.out.println("mid:" + mid);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target ) {
                if (nums[l] <= nums[mid]) {  //左边是有序序列
                    if (nums[l] <= target)
                        r = mid -1;
                    else
                        l = mid + 1;
                } else {  //右边是有序序列
                    r = mid - 1;
                }
            } else {
                if (nums[l] <= nums[mid]) {  //左边是有序序列
                    l = mid + 1;
                } else {  //右边是有序序列
                    if (nums[r] >= target)
                        l = mid + 1;
                    else
                        r = mid - 1;
                }
            }
        }
        return -1;
    }
}

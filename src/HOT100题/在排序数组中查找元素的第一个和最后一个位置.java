package HOT100题;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] a = searchRange(nums,8);
        System.out.println("[" + a[0] + "," + a[1] + "]");
    }

    /**
     * 利用二分查找先找到与target值相等的下标，再利用指针m,n在下标附近寻找最左与最右的下标
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int a[] = {-1,-1};  //用于保存结果
        int l = 0;
        int r = nums.length - 1;
        int mid = (l + r) / 2;
        while (l <= r) {
            if (nums[mid] < target) {
                l = mid + 1;
                mid = (l + r) / 2;
            } else if (nums[mid] > target) {
                r = mid -1;
                mid = (l + r) / 2;
            }else{
                int m =  mid,n = mid;
                //向左遍历
                while (m >= 0 && nums[m] == target) {
                    m--;
                }
                a[0] = m + 1;  //记录左值
                while (n < nums.length && nums[n] == target) {
                    n++;
                }
                a[1] = n - 1;  //记录右值
                break;  //找到最左最右值工作完成
            }
        }
        return a;
    }
}

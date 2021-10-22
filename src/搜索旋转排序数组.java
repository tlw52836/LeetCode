import java.util.ArrayList;
import java.util.List;

public class 搜索旋转排序数组 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
        for(int num:nums)
            System.out.print(num + " ");
    }
    public static int search(int[] nums, int target) {
        int l = 0,r = nums.length-1;
        int mid = (l + r) / 2;
        int t = -1;  //用于记录target所在下标
        while (l <= r) {
            if (nums[mid] < target) {
                l = mid + 1;
                mid = (l + r) / 2;
            } else if (nums[mid] > target) {
                r = mid - 1;
                mid = (l + r) / 2;
            } else {
                System.out.println("mid:" + mid);
               t = mid;
               break;
            }
        }
        //存放左右两边的数据
        List<Integer> lList = new ArrayList<>();

        if (t != -1) {
            for(int i = 0;i < t;i++)
                lList.add(nums[i]);
            //将nums[t]放在第一个位置
            int j = 0;
            nums[j++] = nums[t];
            //将右边的数据移动到左边
            for(int i = t+1;i < nums.length;i++)
                nums[j++] = nums[i];
            //将左边的数据放置右边
            for(int i = 0;i < lList.size();i++)
                nums[j++] = lList.get(i);
        }
        return t;
    }
}

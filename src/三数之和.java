import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

    }

    /**
     * 排序+双指针
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        for(int i = 0;i < nums.length;i++){
            //nums[i]大于0，后面找不到两个数与之相加为0
            if(nums[i] > 0)
                break;
            //去除相同项
            if(i > 0 && nums[i] == nums[i-1])
                continue;

            int m = i + 1;
            int n = nums.length - 1;
            while (m < n) {
                if(nums[i] + nums[m] + nums[n] < 0){
                    m++;
                }
                else if(nums[i] + nums[m] + nums[n] > 0){
                    n--;
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[m]);
                    list.add(nums[n]);
                    lists.add(list);
                    m++;
                    n--;
                    while(m < nums.length && nums[m] == nums[m-1]){
                        m++;
                    }
                    while(n > 0 && nums[n] == nums[n+1]){
                        n--;
                    }
                }
            }
        }

        return lists;

    }
}

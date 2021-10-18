import java.util.Arrays;

public class 下一个排列 {
    public static void main(String[] args) {
        int[] nums = {4,2,0,2,3,2,0};
        System.out.println(findMin(nums,0,nums.length-1));
        nextPermutation(nums);
        for(int num:nums){
            System.out.print(num);
        }
    }
    public static void nextPermutation(int[] nums) {
        int min;  //记录每次最小值下标
        int i,t;

        for(i = nums.length-2;i >= 0;i--){
            System.out.println("i:" + i);
            min = findMin(nums,i+1,nums.length-1);
            if(nums[i] < nums[min]){
                t = nums[i];
                nums[i] = nums[min];
                nums[min] = t;
                break;
            }
        }

        if(i == -1){
            Arrays.sort(nums);
        }
    }

    /**
     * 寻找num[left,right]大于目标值nums[left-1]的最小值下标
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public static int findMin(int[] nums,int left,int right){
        int min = left-1;  //记录最小值下标
        int minNum = nums[left-1];
        for(int i = right - 1;i >= left;i--){
            if (nums[i] > nums[left-1] && nums[i] < nums[min]) {
                min = i;
            }
        }
        return min;
    }

}




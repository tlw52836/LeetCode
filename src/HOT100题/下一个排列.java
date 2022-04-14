package HOT100题;

import java.util.Arrays;

public class 下一个排列 {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        for(int num:nums){
            System.out.print(num);
        }
    }

    /**
     * 从右向左遍历，在nums[i+1...nums.length-1]中找出比nums[i]大的最小值
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int min;  //记录每次最小值下标
        int i,t;

        for(i = nums.length-2;i >= 0;i--){
            min = findMin(nums,i+1,nums.length-1,nums[i]);
            if(min != -1){
                t = nums[i];
                nums[i] = nums[min];
                nums[min] = t;
                Arrays.sort(nums,i+1,nums.length);  //对nums[i+1...nums.length-1]进行排序
                break;
            }
        }
        if(i == -1){
            Arrays.sort(nums);
        }
    }

    /**
     * 寻找num[left...right]大于目标值n的最小值下标
     * @param nums
     * @param left
     * @param right
     * @param n
     * @return
     */
    public static int findMin(int[] nums,int left,int right,int n){
        int min = -1;  //记录下标
        int minNum = 101;  //记录最小值

        for(int i = right;i >= left;i--){
            if (nums[i] > n && nums[i] < minNum) {
                minNum = nums[i];
                min = i;
            }
        }
        return min;
    }

}




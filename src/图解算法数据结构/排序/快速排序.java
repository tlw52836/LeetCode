package 图解算法数据结构.排序;

import java.util.Arrays;

public class 快速排序 {
    public static void main(String[] args) {
        int[] nums = {5, 6, 5, 2, 7, 65, 4536, 45, 654, 65, 546, 75, 45, 45, 1};
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }


    public static void quickSort (int[] nums, int l, int r) {
        if (l < r) {
            int posi = partition(nums, l, r);
            quickSort(nums, l, posi-1);
            quickSort(nums, posi+1, r);
        }
    }

    /**
     * 利用哨兵进行划分操作，如果选第一个元素为哨兵则应从右边j开始遍历
     * @param nums
     * @param l
     * @param r
     * @return
     */
    public static int partition (int[] nums, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l])
                j--;
            while (i < j && nums[i] <= nums[l])
                i++;
            //交换
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;

        return i;
    }
}

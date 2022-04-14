package HOT100题;

import java.util.ArrayList;
import java.util.List;

public class 找到所有数组中消失的数字 {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int[] a = new int[nums.length+1];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            a[nums[i]] = 1;
        }
        for (int j = 1; j < a.length; j++) {
            if (a[j] == 0) {
                list.add(j);
            }
        }
        return list;
    }
}

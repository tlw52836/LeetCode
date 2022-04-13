package 初级算法;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 两个数组的交集II {
    public static void main(String[] args) {

    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                i++;
                j++;
                res.add(nums1[i]);
            } else if (nums1[i] < nums2[2]) {
                i++;
            } else {
                j++;
            }
        }
        res.toArray(a);

        return res.toArray();
    }

}

package TOP100题;

import java.util.*;

public class 至少在两个数组中出现的值 {
    public static void main(String[] args) {
        int[] nums1 = {1,1,3,2};
        int[] nums2 = {2,3};
        int[] nums3 = {3};

//        List<Integer> list1 = new ArrayList<>();
//        for (int num:nums1)
//            list1.add(num);
//        list1.remove(new Integer(1));
//        System.out.println(list1);

        List<Integer> res = twoOutOfThree(nums1, nums2, nums3);
        System.out.println(res);
    }
    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Set<Integer> set2 = new HashSet();
        Set<Integer> set3 = new HashSet();
        List<Integer> res = new ArrayList<>();

        for (int num:nums2)
           set2.add(num);
        for (int num:nums3)
            set3.add(num);

        boolean flag;
        for (int i = 0; i < nums1.length; i++) {
            flag = false;
            if (set2.contains(nums1[i])) {
                set2.remove(new Integer(nums1[i]));
                flag = true;
            }

            if (set3.contains(nums1[i])) {
                set3.remove(new Integer(nums1[i]));
                flag = true;
            }
            if (flag)
                res.add(nums1[i]);
        }

        for (Integer num:set2) {
            if (set3.contains(num))
                res.add(num);
        }

        return res;
    }
}

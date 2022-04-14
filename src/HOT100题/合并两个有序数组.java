package HOT100题;

public class 合并两个有序数组 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, 3, nums2, 3);
        for (int k = 0; k < nums1.length; k++) {
            System.out.print(nums1[k] + " ");
        }

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m+n];
        int i = 0, j = 0;
        int t = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j])
                nums[t++] = nums1[i++];
            else
                nums[t++] = nums2[j++];
        }

        while (i < m)
            nums[t++] = nums1[i++];

        while (j < n)
            nums[t++] = nums2[j++];

        for (int k = 0; k < nums.length; k++) {
            nums1[k] = nums[k];
        }
    }
}

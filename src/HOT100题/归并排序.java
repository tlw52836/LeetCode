package HOT100题;

public class 归并排序 {
    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        sortArray(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length-1, temp);
        return nums;
    }
    public static void sort(int[] nums, int l, int r, int[] temp) {
        if (l < r) {
            int mid = (l + r) / 2;
            sort(nums, l, mid, temp);
            sort(nums, mid+1, r, temp);
            merge(nums, l, mid, r, temp);
        }
    }

    public static void merge(int[] nums, int l, int mid, int r, int[] temp) {
        int i = l, j = mid + 1;
        int t = l;

        while (i <=mid && j <= r) {
            if (nums[i] < nums[j])
                temp[t++] = nums[i++];
            else
                temp[t++] = nums[j++];
        }

        while (i <= mid)
            temp[t++] = nums[i++];
        while (j <= r)
            temp[t++] = nums[j++];

        for (int k = l; k <= r; k++) {
            nums[k] = temp[k];
        }
    }
}

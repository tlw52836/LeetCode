public class 数组中的第K个最大元素_建立K个元素的堆 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        buildMinHeap(nums, k);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                nums[0] = nums[i];
                downAdjust(nums, k, 0);
            }

        }
        return nums[0];
    }

    /**
     * 建堆
     * @param nums
     */
    public static void buildMinHeap(int[] nums, int n) {
        for (int i = n/2; i >= 0 ; i--) {
            upAdjust(nums, n, i);
        }
    }

    /**
     * 向上调整
     * @param nums
     * @param i 需要调整的元素下标
     */
    public static void upAdjust(int[] nums, int n, int i) {
        int minIndex = i;
        if (2*i+1 < n && nums[2*i+1] < nums[minIndex]) {
            minIndex = 2 * i + 1;
        }

        if (2*i+2 < n && nums[2*i+2] < nums[minIndex]) {
            minIndex = 2 * i + 2;
        }

        if (minIndex != i) {
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
            downAdjust(nums, n, minIndex);
        }
    }

    /**
     * 向下调整
     * @param nums
     * @param i 需要调整的元素下标
     */
    private static void downAdjust(int[] nums, int n, int i) {
        int minIndex = i;
        while (2*i+1 < n) {
            if (2*i+1 < n && nums[2*i+1] < nums[minIndex]) {
                minIndex = 2 * i + 1;
            }

            if (2*i+2 < n && nums[2*i+2] < nums[minIndex]) {
                minIndex = 2 * i + 2;
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
                i = minIndex;
            } else {
                break;
            }
        }
    }
}


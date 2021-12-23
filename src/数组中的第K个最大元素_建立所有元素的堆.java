import java.util.Arrays;

public class 数组中的第K个最大元素_建立所有元素的堆 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        buildMaxHeap(nums, nums.length);
        //删除前k-1个元素，则堆顶为第k大的元素
        for (int i = 0; i < k-1; i++) {
            nums[0] = nums[nums.length-1-i];
            downAdjust(nums, nums.length-1-i, 0);
            for (int j = 0; j < nums.length-1-i; j++) {
                System.out.print(nums[j] + " ");
            }
            System.out.println();
        }

        return nums[0];
    }

    /**
     * 建堆
     * @param nums
     */
    public static void buildMaxHeap(int[] nums, int n) {
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
        int maxIndex = i;
        if (2*i+1 < n && nums[2*i+1] > nums[maxIndex]) {
            maxIndex = 2 * i + 1;
        }

        if (2*i+2 < n && nums[2*i+2] > nums[maxIndex]) {
            maxIndex = 2 * i + 2;
        }

        if (maxIndex != i) {
            int temp = nums[i];
            nums[i] = nums[maxIndex];
            nums[maxIndex] = temp;
            downAdjust(nums, n, maxIndex);
        }
    }

    /**
     * 向下调整
     * @param nums
     * @param i 需要调整的元素下标
     */
    private static void downAdjust(int[] nums, int n, int i) {
        int maxIndex = i;
        while (2*i+1 < n) {
            if (2*i+1 < n && nums[2*i+1] > nums[maxIndex]) {
                maxIndex = 2 * i + 1;
            }

            if (2*i+2 < n && nums[2*i+2] > nums[maxIndex]) {
                maxIndex = 2 * i + 2;
            }
            if (maxIndex != i) {
                int temp = nums[i];
                nums[i] = nums[maxIndex];
                nums[maxIndex] = temp;
                i = maxIndex;
            } else {
                break;
            }
        }
    }
}


package TOP100题;

import java.util.HashMap;
import java.util.Map;

public class 前K个高频元素 {
    public static void main(String[] args) {

        int[] nums = {4,1,-1,2,-1,2,3};
        int[] res = topKFrequent(nums, 2);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i], maps.getOrDefault(nums[i], 0)+1);
        }

        int[][] arr = new int[maps.size()][2];
        int i = 0;
        for (Map.Entry m:maps.entrySet()) {
            arr[i][0] = (int) m.getKey();
            arr[i][1] = (int) m.getValue();
            i++;
        }
        bulidMinHeap(arr,k);

        for (int j = k; j < arr.length; j++) {
            if (arr[j][1] > arr[0][1]) {
                arr[0] = arr[j];
                downAdjust(arr, k, 0);
            }
        }

        for (int j = 0; j < k; j++) {
            res[j] = arr[j][0];
        }

        return res;
    }

    /**
     * 建堆
     * @param nums
     * @param n
     */
    public static void bulidMinHeap(int[][]nums, int n) {
        for (int i = n/2; i >= 0; i--) {
            upAdjust(nums, n, i);
        }
    }

    /**
     * 向上调整
     * @param nums
     * @param n 范围
     * @param i 需要调整的元素下标
     */
    private static void upAdjust(int[][] nums, int n, int i) {
        int minIndex = i;
        if (2*i+1 < n && nums[2*i+1][1] < nums[minIndex][1]) {
            minIndex = 2 * i + 1;
        }

        if (2*i+2 < n && nums[2*i+2][1] < nums[minIndex][1]) {
            minIndex = 2 * i + 2;
        }

        if (minIndex != i) {
            int[] temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
            downAdjust(nums, n, minIndex);
        }

    }

    /**
     * 向下调整
     * @param nums
     * @param n
     * @param i
     */
    private static void downAdjust(int[][] nums, int n, int i) {
        int minIndex = i;
        while (2*i+1 < n) {
            if (2*i+1 < n && nums[2*i+1][1] < nums[minIndex][1]) {
                minIndex = 2 * i + 1;
            }

            if (2*i+2 < n && nums[2*i+2][1] < nums[minIndex][1]) {
                minIndex = 2 * i + 2;
            }

            if (minIndex != i) {
                int[] temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
                i = minIndex;
            } else {
                break;
            }
        }
    }

    /**
     * 打印函数
     * @param arr
     * @param n
     */
    public static void print(int[][] arr, int n) {
        System.out.println("===================================");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }

}

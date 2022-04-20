package 初级算法.其他;

public class 缺失数字 {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3,0,1}));
    }
    public static int missingNumber(int[] nums) {
        int[] index = new int[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            index[nums[i]] = 1;
        }
        for (int i = 0; i < index.length; i++) {
            if (index[i] == 0)
                return i;
        }
        return -1;
    }
}

package HOT100题;

public class 跳跃游戏II {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int step = jump(nums);
        System.out.println(step);
    }

    public static int jump(int[] nums) {
        int maxPosi = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length; i++) {
            maxPosi = Math.max(maxPosi, i + nums[i]);
            if (i == end && i != nums.length-1) {
                end =  maxPosi;
                step++;
            }
        }
        return step;
    }
}

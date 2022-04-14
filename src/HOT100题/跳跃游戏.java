package HOT100题;

public class 跳跃游戏 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int reach = 0;  //记录当前能跳到的最大下标
        for (int i = 0; i < nums.length; i++) {
            if (i > reach)
                return false;
            else
                reach = Math.max(reach, i+nums[i]);
        }
        return true;
    }
}


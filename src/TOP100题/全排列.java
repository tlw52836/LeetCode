package TOP100题;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 全排列 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(permute(nums));

    }

    /**
     * 动态规划:将num[i]依次插入前i-1个数的组合的排列数中，每次插入都有i种方法
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        //用于存放排列结果
        List<List<Integer>> lists = new ArrayList<>();

        //将第一个num以list的方式放入lists
        ArrayList<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        lists.add(l);

        for (int i = 1; i < nums.length; i++) {
            int listsLen = lists.size();
            //依次遍历链表
            for (int j = 0; j < listsLen; j++) {
                List<Integer> list = lists.remove(0);
                for (int k = 0; k <= list.size(); k++) {
                    //复制list
                    List list2 = new ArrayList(list);
                    list2.add(k,nums[i]);
                    lists.add(list2);
                }
            }
            System.out.println("list:" + lists);
        }
        return lists;
    }

}

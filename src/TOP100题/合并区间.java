package TOP100题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {
    public static void main(String[] args) {
        int[][] intervals = {{1,3}};
        int[][] m = merge(intervals);
        for(int i = 0;i < m.length;i++){
            System.out.println("[" + m[i][0] + "," + m[i][1] + "]");
        }
    }

    /**
     * 将区间按照左端点进行排序，再逐一判断第i-1区间是否需要与第i个区间进行合并
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {

        if(intervals.length == 1){
            return intervals;
        }
        //区间按照左端点进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        /**
         * TOP100题.合并区间
         */
        List<int[]> list = new ArrayList<>();  //用于保存合并后的数组
        for(int i = 1;i < intervals.length;i++){
            if(intervals[i-1][1] >= intervals[i][0]){
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i-1][1],intervals[i][1]);
                if(i == intervals.length-1){
                    list.add(intervals[i]);
                }
            }
            else{
                list.add(intervals[i-1]);
                if(i == intervals.length-1){
                    list.add(intervals[i]);
                }
            }
        }

        return list.toArray(new int[list.size()][]);  //列表转数组
    }
}

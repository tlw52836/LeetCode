package HOT100题;

import java.util.HashMap;
import java.util.Map;

public class 任务调度器 {

    public static void main(String[] args) {
        char[] task = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(task, n));
    }

    /**
     * 桶装法:详见题解
     * @param tasks
     * @param n
     * @return
     */
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> maps = new HashMap<>();
        int max = -1;
        int maxCount = 0;
        int all = 0;

        for (int i = 0; i < tasks.length; i++) {
            int count =  maps.getOrDefault(tasks[i],0) + 1;
            max = Math.max(max, count);
            maps.put(tasks[i], count);
        }

        for (int m:maps.values()) {
            if (m == max)
                maxCount++;
            all += m;
        }

       return Math.max(all, (max-1)*(n+1)+maxCount);
    }
}

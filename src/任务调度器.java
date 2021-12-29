import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 任务调度器 {

    public static void main(String[] args) {
        char[] task = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval(task, n));
    }
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            maps.put(tasks[i], maps.getOrDefault(tasks[i],0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        int max = -1;
        int all = 0;

        for (int m:maps.values()) {
            max = Math.max(max, m);
            all += m;
            list.add(m);
        }

        System.out.println(max);
        if (all-((max-1)*(n+1)+1) >= 0)
            return all;
        else
            return (max-1) * (n+1) + 1;
    }
}

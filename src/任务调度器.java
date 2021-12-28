import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 任务调度器 {

    public static void main(String[] args) {

    }
    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> maps = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            maps.put(tasks[i], maps.getOrDefault(tasks[i],0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        int maxIndex = -1;
        for (int i = 0; i < maps.size(); i++) {
            list.add(maps.get(i));
        }

        return 0;
    }
}

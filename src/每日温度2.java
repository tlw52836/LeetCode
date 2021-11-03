import java.util.Arrays;
import java.util.Stack;

public class 每日温度2 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    /**
     * 利用栈进行操作
     * @param temperatures
     * @return
     */
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] days = new int[temperatures.length];  //存储结果
        int a;
        for (int i = 0; i < temperatures.length; i++) {
            if (s.empty() || temperatures[i] <= temperatures[s.peek()]) {
                s.push(i);
                continue;
            }
            while (!s.empty() && temperatures[i] > temperatures[s.peek()]) {
                a = s.pop();
                days[a] = i - a;
            }
            s.push(i);
        }
        return days;
    }
}

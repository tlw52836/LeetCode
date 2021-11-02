import java.util.Arrays;
import java.util.Stack;

public class 每日温度2 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] days = new int[temperatures.length];
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] <= temperatures[s.peek()]) {
                s.push(i);
                continue;
            }
            while (temperatures[s.pop()]temperatures[i])
        }
        return days;
    }
}

package HOT100题;

import java.util.Arrays;

public class 每日温度_暴力 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        int k;  //标记天数
        for (int i = 0; i < temperatures.length-1; i++) {
            k = 0;
            for (int j = i+1; j < temperatures.length; j++) {
                k++;
                if (temperatures[j] > temperatures[i]) {
                    days[i] = k;
                    break;
                }
            }
        }
        return days;
    }
}

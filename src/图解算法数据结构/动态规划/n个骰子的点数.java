package 图解算法数据结构.动态规划;

import java.util.ArrayList;
import java.util.List;

public class n个骰子的点数 {
    public static void main(String[] args) {

    }

    public static double[] dicesProbability(int n) {
        double[][] dp = new double[n+1][6*n+1];
        int sum = 0;
        int sumCopy = 0;
        for (int i = 1; i <= n; i++) {
            sumCopy = sum;
            sum = 0;
            for (int j = i; j <= 6*i; j++) {
                for (int k = i-1; k <= (i-1)*(i-1); k++) {
                    if ()
                }
            }

        }
        return null;
    }
}

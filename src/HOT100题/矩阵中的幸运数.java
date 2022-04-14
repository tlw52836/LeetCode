package HOT100题;

import java.util.ArrayList;
import java.util.List;

public class 矩阵中的幸运数 {
    public static void main(String[] args) {
        int[][] matrix = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        System.out.println(luckyNumbers(matrix));
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMinIndex = new int[m];
        List<Integer> res = new ArrayList<>();

        int min;
        for (int i = 0; i < m; i++) {
            min = 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] < matrix[i][min])
                    min = j;
            }
            rowMinIndex[i] = min;
        }

        for (int i = 0; i < m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (matrix[j][rowMinIndex[i]] > matrix[i][rowMinIndex[i]])
                    break;
            }

            if (j >= m)
                res.add(matrix[i][rowMinIndex[i]]);
        }

        return res;
    }
}

package 初级算法.数组;

import java.util.Arrays;

public class 旋转图像 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate2(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

    /**
     * matrix[i][j] -> matrix[j][n-1-i]
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               res[j][n-1-i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = res[i][j];
            }
        }
    }

    /**
     * 先转置，再交换列（原地）
     * 1 2 3    1 4 7    7 4 1
     * 4 5 6 -> 2 5 8 -> 8 5 2
     * 7 8 9    3 6 9    9 6 3
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;

        //转置
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        //交换列
        int i = 0, j = n - 1;
        while (i < j) {
            for (int k = 0; k < n; k++) {
                int temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
            i++;
            j--;
        }
    }

}

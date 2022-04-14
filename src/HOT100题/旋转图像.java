package HOT100题;

public class 旋转图像 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(matrix[i][0] + " " + matrix[i][1] + " " + matrix[i][2]);

        }
    }

    /**
     * 1  4  7     7  4  1
     * 2  5  8     8  5  2
     * 3  6  9     9  6  3
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        /**
         * 先将矩阵转置
         */
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        /**
         * 再交换矩阵的对应列
         */

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }

        }

    }
}

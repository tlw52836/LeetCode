package TOP100题;

public class 统计全为1的正方形子矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,1,1}, {1,1,1,1}, {0,1,1,1}};
        System.out.println(countSquares(matrix));
    }

    /**
     * dp[i][j] 表示以matrix[i][j]为右下角的正方形最大面积（或者是正方形个数）
     * dp[i][j] = min{dp[i-1][j], dp[i][j-1], dp[i-1][j-1]} + 1
     * @param matrix
     * @return
     */
    public static int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        print(matrix);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || j == 0 || matrix[i][j] == 0)) {
                    res += matrix[i][j];
                }
                else {
                    int temp = Math.min(matrix[i-1][j], matrix[i][j-1]);
                    matrix[i][j] = Math.min(temp, matrix[i-1][j-1]) + 1;
                    res += matrix[i][j];
                }
            }

        }
        System.out.println("==================");
        print(matrix);
        
        return res;
    }

    public static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

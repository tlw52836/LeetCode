package TOP100题;

public class 螺旋矩阵II {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        //右下左上四个方向
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int num = 1;
        int i = 0, j = 0;
        int k = 0;
        boolean flag = true;

        while (flag) {
            int t = 0;
            matrix[i][j] = num++;
            while (i+direct[k][0] < 0 || i+direct[k][0] >= n || j+direct[k][1] < 0 || j+direct[k][1] >= n || matrix[i+direct[k][0]][j+direct[k][1]] != 0) {
                k = (k + 1) % 4;
                t++;
                if (t == 3) {
                    flag = false;
                    break;
                }
            }
            i = i+direct[k][0];
            j = j+direct[k][1];
        }

        return matrix;
    }
}

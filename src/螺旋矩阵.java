import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visit = new boolean[row][col];

        int i = 0, j = 0, k = 0;
        while (true) {
            res.add(matrix[i][j]);
            int t = 0;
            while (i+direct[k][0] < 0 || i+direct[k][0] >= row || j+direct[k][1] < 0 || j+direct[k][1] >= col || visit[i+direct[k][0]][j+direct[k][1]] == true) {
                k = (k + 1) % 4;
                t++;
                if (t == 3)
                    break;
            }
            i = i+direct[k][0];
            j = j+direct[k][1];
        }
        return null;
    }

}

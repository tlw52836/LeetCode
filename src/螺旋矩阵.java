import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] direct = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visit = new boolean[row][col];

        int i = 0, j = 0, k = 0;
        while (true) {
            res.add(matrix[i][j]);
            while (i+direct[k][0] < 0 || i+direct[k][0] >= row || j+direct[k][1] < 0 || j+direct[k][1] >= col || visit[i+direct[i][0]][j+direct[i][1]] == true) {
                k = (k + 1) % 4;
            }
        }

        return res;
    }
}

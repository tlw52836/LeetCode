package HOT100题;

public class 搜索二维矩阵II {
    public static void main(String[] args) {

    }


    /**
     * 每一行进行折半查找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int l = 0, r = n;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (matrix[i][mid] == target)
                    return true;
                else if (matrix[i][mid] < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return false;
    }


    /**
     * 从右上角开始查找，如果matrix[i][j] < target，则往下查找    如果matrix[i][j] >  target，则往左查找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0, j = n -1;
        while (i < m && j > -1) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] < target)
                i++;
            else
                j--;
        }
        return false;
    }
}

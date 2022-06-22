package 剑指OfferII.栈;

import java.util.Stack;

public class 矩阵中最大的矩形 {
    public static void main(String[] args) {
        String[] matrix = {"10100","10111","11111","10010"};
        System.out.println(maximalRectangle(matrix));
    }
    public static int maximalRectangle(String[] matrix) {
        if (matrix.length <= 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length();
        int[][] seqCount = new int[m][n];  //suqCount[i][j]记录第i行中，以matrix[i][j]为结尾的连续1的个数
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i].charAt(j) == '1') {
                    seqCount[i][j] = ++count;
                } else {
                    seqCount[i][j] = 0;
                    count = 0;
                }
            }
        }

        int res = 0;
        for (int j = 0; j < n; j++) {
            Stack<Integer> s = new Stack<>();
            s.push(-1);
            for (int i = 0; i < m; i++) {
                while(s.peek() != -1 && seqCount[i][j] < seqCount[s.peek()][j]) {
                    res = Math.max(res, seqCount[s.pop()][j] * (i - s.peek() - 1));
                }
                s.push(i);
            }

            while (s.peek() != -1) {
                res = Math.max(res, seqCount[s.pop()][j] * (m - s.peek() - 1));
            }
        }

        return res;
    }
}

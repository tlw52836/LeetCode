package HOT100题;

import java.util.ArrayList;
import java.util.List;

public class N皇后 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
//    public static List<List<String>> solveNQueens(int n) {
//        List<Integer> rows = new ArrayList<>();  //标记访问过的列
//        List<Integer[]> points = new ArrayList<>();  //标记不能走的两斜对角线线上的点
//        List<String> ss = new ArrayList<>();  //存放某次结果
//        List<List<String>> res = new ArrayList<>();
//
//        dfs(rows, points, ss, res, n, 0);
//
//        return res;
//    }
//
//    /**
//     * dfs + 回溯
//     * @param rows
//     * @param points
//     * @param ss
//     * @param res
//     * @param n
//     * @param depth
//     */
//    public static void dfs(List<Integer> rows, List<Integer[]> points, List<String> ss, List<List<String>> res,  int n, int depth) {
//
//        //返回一条结果
//        if (ss.size() == n) {
//            res.add(new ArrayList<>(ss));
//            return;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (rows.contains(i) || isPointContains(points, depth, i))
//                continue;
//
//            rows.add(i);  //标记访问过的列
//
//            int t = 0;
//            //标记不能走的斜对角线线上的点
//            for (int j = depth+1, k = i+1; j < n && k < n; j++, k++) {
//                points.add(new Integer[]{j, k});
//                t++;
//            }
//
//            for (int j = depth+1, k = i -1; j < n && k >= 0; j++,k--) {
//                points.add(new Integer[]{j, k});
//                t++;
//            }
//
//
//            String str = "";
//            for (int j = 0; j < n; j++) {
//                if (j != i) {
//                    str += ".";
//                } else {
//                    str += "Q";
//                }
//            }
//            ss.add(str);
//
//            dfs(rows, points, ss, res, n, depth+1);
//            /**
//             * 回溯
//             */
//            ss.remove(ss.size()-1);
//            for (int j = 0; j < t; j++) {
//                points.remove(points.size()-1);
//            }
//
//            rows.remove(rows.size()-1);
//        }
//    }
//
//    /**
//     * 判断点集points中是否包含点(m, n)
//     * @param points
//     * @param m
//     * @param n
//     * @return
//     */
//    public static boolean isPointContains(List<Integer[]> points, int m, int n) {
//        for (int i = 0; i < points.size(); i++) {
//            if (points.get(i)[0] == m && points.get(i)[1] == n)
//                return true;
//        }
//        return false;
//    }

    public static List<List<String>> solveNQueens(int n) {
        boolean[] rows = new boolean[n];  //标记访问过的列
        boolean[] posiDg = new boolean[2*n-1];  //标记不能走的正对角线 posiDg[i]: i = row + col
        boolean[] negaDg = new boolean[2*n-1];  //标记不能走的反对角线 negaDg[i]: i = n - row + col - 1
        List<List<String>> res = new ArrayList<>();  //存放最终结果
        char[][] grid = new char[n][n];

        //初始化棋盘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }

        dfs(rows, posiDg, negaDg, grid, res, n, 0);

        return res;
    }

    /**
     * dfs + 回溯
     * @param rows
     * @param posiDg
     * @param negaDg
     * @param grid
     * @param res
     * @param n
     * @param depth
     */
    public static void dfs(boolean[] rows, boolean[] posiDg, boolean[] negaDg, char[][] grid, List<List<String>> res,  int n, int depth) {

        //返回一条结果
        if (depth == n) {
            List<String> ss = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ss.add(new String(grid[i]));
            }
            res.add(ss);
            return;
        }

        for (int i = 0; i < n; i++) {
            /**
             * 剪枝
             */
            if (rows[i] || posiDg[depth+i] || negaDg[n-depth+i-1])
                continue;

            //标记访问过的列
            rows[i] = true;


            //标记正对角线与反对角线
            posiDg[depth+i] = true;
            negaDg[n-depth+i-1] = true;

            //构造并添加字符串
            grid[depth][i] = 'Q';

            dfs(rows, posiDg, negaDg, grid, res, n, depth+1);
            /**
             * 回溯
             */
            grid[depth][i] = '.';

            posiDg[depth+i] = false;
            negaDg[n-depth+i-1] = false;

            rows[i] = false;
        }
    }
}

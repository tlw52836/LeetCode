import java.util.ArrayList;
import java.util.List;

public class N皇后 {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<Integer> rows = new ArrayList<>();  //标记访问过的列
        List<Integer[]> points = new ArrayList<>();  //标记不能走的斜线上的点
        List<String> ss = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        dfs(rows, points, ss, res, n, 0);

        return res;
    }

    public static void dfs(List<Integer> rows, List<Integer[]> points, List<String> ss, List<List<String>> res,  int n, int depth) {

        if (ss.size() == n) {
            res.add(new ArrayList<>(ss));
            ss.clear();
            return;
        }

        if (depth == n)
            return;

        for (int i = 0; i < n; i++) {
            if (rows.contains(i) || isPointContains(points, depth, i))
                continue;

            rows.add(i);  //标记访问过的列

            int t = 0;
            //标记不能走的斜线上的点
            for (int j = depth+1, k = i+1; j < n && k < n; j++, k++) {
                points.add(new Integer[]{j, k});
                t++;
            }

            for (int j = depth+1, k = i -1; j < n && k >= 0; j++,k--) {
                points.add(new Integer[]{j, k});
                t++;
            }


            String str = "";
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    str += "*";
                } else {
                    str += "Q";
                }
            }
            ss.add(str);

            dfs(rows, points, ss, res, n, i+1);
            /**
             * 回溯
             */
            ss.remove(ss.size()-1);
            for (int j = 0; j < t; j++) {
                points.remove(points.size()-1);
            }

            rows.remove(rows.size()-1);
        }
    }

    /**
     * 判断点集points中是否包含点(m, n)
     * @param points
     * @param m
     * @param n
     * @return
     */
    public static boolean isPointContains(List<Integer[]> points, int m, int n) {
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i)[0] == m && points.get(i)[1] == n)
                return true;
        }
        return false;
    }
}

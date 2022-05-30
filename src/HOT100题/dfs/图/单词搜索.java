package HOT100题.dfs.图;

public class 单词搜索 {
    public static void main(String[] args) {
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int[][] visit = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, board, word, 0, visit)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * DFS 有两个要素：「访问相邻结点」和「判断 base case」
     * @param i
     * @param j
     * @param board
     * @param word
     * @param depth
     * @param visit
     * @return
     */
    public static boolean dfs(int i, int j, char[][] board, String word, int depth, int[][] visit) {
        //判断 base case
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;

        if (visit[i][j] == 1)
            return false;

        if (board[i][j] != word.charAt(depth))
            return false;

        if (depth+1 == word.length())
            return true;

        visit[i][j] = 1;
        depth++;

        //访问相邻结点
        boolean f1 = dfs(i - 1, j, board, word, depth, visit);
        boolean f2 = dfs(i + 1, j, board, word, depth, visit);
        boolean f3 = dfs(i, j - 1, board, word, depth, visit);
        boolean f4 = dfs(i, j + 1, board, word, depth, visit);

        //回溯
        visit[i][j] = 0;
        depth--;

        if (f1 || f2 || f3 || f4) {
            return true;
        } else {
            return false;
        }
    }
}

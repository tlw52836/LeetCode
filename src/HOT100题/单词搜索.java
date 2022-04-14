package HOT100题;

public class 单词搜索 {

    public static void main(String[] args) {
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        Solution s = new Solution();
        System.out.println(s.exist(board, "AAB"));

    }

    /**
     * 深度优先遍历 + 回溯
     */
    static class Solution {
        private char[][] board;
        private int[][] visit;  //记录已经访问过的结点
        private int row;  //行长
        private int col;  //列长
        private char[] ch;  //转化word为字符数组
        private final static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


        public boolean exist(char[][] board, String word) {
            this.board = board;
            this.row = board.length;
            this.col = board[0].length;
            this.visit = new int[row][col];
            this.ch = word.toCharArray();

            //依次判断board里的每个节点是否与word的首字母相同
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == ch[0]) {
                        visit[i][j] = 1;
                        if (dfs(i, j, 0)) {
                            return true;
                        }
                        visit[i][j] = 0;
                    }
                }
            }
            return false;
        }

        public boolean dfs (int m, int n, int depth) {
            //System.out.println("board[m][n]:" + board[m][n]);
            /**
             *得到目标值
             */
            if (depth == ch.length-1) {
                return true;
            }

            int a,b;
            for (int i = 0; i < direction.length; i++) {
                a = m + direction[i][0];
                b = n + direction[i][1];

                /**
                 * 剪枝
                 */
                if(a < 0 || a >= row || b < 0 || b >= col) {
                    continue;
                }

                if (visit[a][b] == 1) {
                    continue;
                }

                if (board[a][b] != ch[depth+1]) {
                    continue;
                }


                visit[a][b] = 1;  //标记为访问过的结点;
                if (dfs(a, b, depth+1)) {
                    return true;
                } else {
                    // 回溯
                    visit[a][b] = 0;
                }
            }
            return false;
        }
    }
}

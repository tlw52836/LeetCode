package HOT100题.dfs.图;

public class 岛屿数量 {
    public static void main(String[] args) {
        char[][] grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }

        return res;
    }


    /**
     *  DFS 有两个要素：「访问相邻结点」和「判断 base case」
     * @param i
     * @param j
     * @param grid
     */
    public static void dfs(int i, int j, char[][] grid) {
        //base csae:越界
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }

        //base case:水 或者 已访问过的结点
        if (grid[i][j] == '0' || grid[i][j] == '2') {
            return;
        }

        //标记已经访问过
        grid[i][j] = '2';

        //访问相邻结点
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
    }
}

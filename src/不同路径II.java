public class 不同路径II {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{1}, {0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;

        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                else  if(i == 0) {
                  if (j >0 && dp[i][j-1] == 0)
                      continue;
                  else
                      dp[i][j] =1;
                } else if (j ==  0) {
                    if (i > 0 && dp[i-1][j] == 0)
                        continue;
                    else
                        dp[i][j] =1;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

            }
            
        }

        return dp[row-1][col-1];
    }
}

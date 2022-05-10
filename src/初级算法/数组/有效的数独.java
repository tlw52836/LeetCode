package 初级算法.数组;

public class 有效的数独 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];  //记录每一行的元素  下标9表示9行  下标10用于记录1-9范围的数
        int[][] col = new int[9][10];  //记录每一列的元素
        int[][] box = new int[9][10];  //记录每个九宫格的元素

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';

                if (row[i][num] == 1 || col[j][num] == 1 || box[j/3 + 3*(i/3)][num] == 1)
                    return false;
                row[i][num] = 1;
                col[j][num] = 1;
                box[j/3 + 3*(i/3)][num] = 1;
            }
        }
        return true;
    }
}

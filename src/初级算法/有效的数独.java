package 初级算法;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 有效的数独 {
    public static void main(String[] args) {
//        char[][] board = new char[][]{{{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}}};
//        System.out.println(isValidSudoku(board));
    }
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> rSet = new HashSet<>();  //记录每行元素
        Set<Character> cSet = new HashSet<>();  //记录每行元素

        //判断每行、每列是否有重复元素
        for (int i = 0; i < board.length; i++) {
            rSet.clear();
            cSet.clear();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.' || board[j][i] == '.')
                    continue;
                boolean flag1 = rSet.add(board[i][j]);
                boolean flag2 = cSet.add(board[j][i]);
                if (!flag1 || !flag2)
                    return false;
            }

        }


        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        Set<Character> set4 = new HashSet<>();
        Set<Character> set5 = new HashSet<>();
        Set<Character> set6 = new HashSet<>();
        Set<Character> set7 = new HashSet<>();
        Set<Character> set8 = new HashSet<>();
        Set<Character> set9 = new HashSet<>();


        //判断3x3宫内是否有重复元素
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.' || board[i+3][j] == '.' || board[i+6][j] == '.' || board[i][j+3] == '.' || board[i+3][j+3] == '.' || board[i+6][j+3]  == '.' || board[i][j+6] == '.' || board[i+3][j+6] == '.' || board[i+6][j+6]  == '.' )
                    continue;
                boolean flag1 = set1.add(board[i][j]);
                boolean flag2 = set2.add(board[i+3][j]);
                boolean flag3 = set3.add(board[i+6][j]);

                boolean flag4 = set4.add(board[i][j+3]);
                boolean flag5 = set5.add(board[i+3][j+3]);
                boolean flag6 = set6.add(board[i+6][j+3]);

                boolean flag7 = set7.add(board[i][j+6]);
                boolean flag8 = set8.add(board[i+3][j+6]);
                boolean flag9 = set9.add(board[i+6][j+6]);

                if (!flag1 || !flag2 || !flag3 || !flag4 || !flag5 || !flag6 || !flag7 || !flag8 || !flag9)
                    return false;
            }
        }

        return true;
    }
}

package algorithm.leetcode.Algorithms._1_100._36_ValidSudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jialei.zou on 2018/11/25 .
 ref:
 https://leetcode.com/problems/valid-sudoku/

 Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated
 according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 图片
 A partially filled sudoku which is valid.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 Example 1:

 Input:
 [
 ["5","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: true
 Example 2:

 Input:
 [
 ["8","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: false
 Explanation: Same as Example 1, except with the 5 in the top left corner being
 modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 Note:

 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 The given board contain only digits 1-9 and the character '.'.
 The given board size is always 9x9.

 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        //按行
        for (int i=0;i<9;i++){
            for (int j=0; j<9;j++){
                if(board[i][j]!='.'&&set.contains(board[i][j])){
                    return false;
                }
                if(board[i][j]!='.'){
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }

        //按列
        for (int j=0;j<9;j++){
            for (int i=0; i<9;i++){
                if(board[i][j]!='.'&&set.contains(board[i][j])){
                    return false;
                }
                if(board[i][j]!='.'){
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        //按3*3
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                for (int m=0; m<3; m++){
                    for (int n=0; n<3; n++){
                        if(board[i*3+m][j*3+n]!='.'&&set.contains(board[i*3+m][j*3+n])){
                            return false;
                        }
                        if(board[i*3+m][j*3+n]!='.'){
                            System.out.println("set add:"+board[i*3+m][j*3+n]);
                            set.add(board[i*3+m][j*3+n]);
                        }
                    }
                }
                set.clear();
            }
        }

        return true;
    }

    private boolean isValidInput(char c){
        if(c=='.' || (c>='0'&&c<='9')){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] boardFalse = new char[][]{
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        char[][] boardTrue = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        char[][] boardFalse2 = new char[][]{
                {'.','4','.','.','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'},
                {'.','.','.','1','.','.','7','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','3','.','.','.','6','.'},
                {'.','.','.','.','.','6','.','9','.'},
                {'.','.','.','.','1','.','.','.','.'},
                {'.','.','.','.','.','.','2','.','.'},
                {'.','.','.','8','.','.','.','.','.'}
        };
        ValidSudoku validSudoku = new ValidSudoku();
//        System.out.println(validSudoku.isValidSudoku(boardFalse));
        System.out.println(validSudoku.isValidSudoku(boardFalse2));


    }
}

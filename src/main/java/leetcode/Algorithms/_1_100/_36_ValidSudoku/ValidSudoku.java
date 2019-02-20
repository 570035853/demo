package leetcode.Algorithms._1_100._36_ValidSudoku;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by jialei.zou on 2018/11/25 .
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++){
            Set<Integer> set = new HashSet<>();
            for (int j=0; j<9; j++){
                if(!isValidInput(board[i][j])){
                    return false;
                }
                if(board[i][j]!='.'){
                    Integer value = new Integer(board[i][j]);
                    if(set.contains(value)){
                        return false;
                    }else {
                        set.add(value);
                    }
                }
            }
        }
        return false;
    }

    private boolean isValidInput(char c){
        if(c=='.' || (c>='0'&&c<='9')){
            return true;
        }
        return false;
    }
}

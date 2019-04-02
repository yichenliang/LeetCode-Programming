package yichenliang.leetcode.withoutTopic;

/** 
 * 37. Sudoku Solver
 *
 * backtracking
 */

public class SudokuSolver {
	
	public void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0, 0);
        return;    
    }
    
    boolean solveSudokuHelper(char[][] board, int row, int col){
        // find a place to put a number in
        while(row < 9 && col < 9){
            if(board[row][col] == '.') break;
            if(col == 8){
                row++;
                col = 0;
            }
            else{
                col++;
            }
        }
        
        // all places are filled
        if(row >= 9) return true;
        
        // try to put a valid number in this place
        int newRow = row + col / 8; // next place in row
        int newCol = (col + 1) % 9; // next place in col
        for(int num = 1; num <= 9; num++){
            if(isValid(board, row, col, num)){
                board[row][col] = (char)(num + '0');
                boolean result = solveSudokuHelper(board, newRow, newCol);
                if(result) return true;
                // backtracking, change the current number sitting in this place
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    boolean isValid(char[][] board, int row, int col, int num){
        
        // check each row and col
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num + '0' || board[i][col] == num + '0') return false;
        }
        
        // check 3*3 square
        // mapping trick
        int rowMapping = (row / 3) * 3;
        int colMapping = (col / 3) * 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[rowMapping + i][colMapping + j] == num + '0') return false;
            }
        } 
        return true;
    }

}

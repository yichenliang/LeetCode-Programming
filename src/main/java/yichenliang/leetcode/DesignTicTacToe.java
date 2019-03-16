package yichenliang.leetcode;

/**
 * 772. Basic Calculator III
 * 
 * time complexity: O(n)
 * space complexity: O(n) 
 */

	class TicTacToe {
    
		int[][] grid;
		int len;
		
		/** Initialize your data structure here. */
		public TicTacToe(int n) {
			grid = new int[n][n];   
			len = n;
		}
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
		public int move(int row, int col, int player) {
			grid[row][col] = player;
        
			if(win(row, col, player)){
				return player;
			}
        
			return 0;
		}
    
		boolean win(int row, int col, int player){   
			if(row == col){  //  "\"
				if(dia1(player)) return true;
			}
			
			if(row + col == len - 1){  //  "/"
				if(dia2(player)) return true;
			}
        
			if(row(row, player) || col(col, player)) return true;
        
			return false;
		}
    
		boolean row(int row, int player){
			for(int j = 0; j < len; j++){
				if(grid[row][j] != player){
					return false;
				}
			}
			return true;
		}
    
		boolean col(int col, int player){
			for(int i = 0; i < len; i++){
				if(grid[i][col] != player){
					return false;
				}
			}
			return true;
		}
    
		boolean dia1(int player){
			for(int k = 0; k < len; k++){
				if(grid[k][k] != player){
					return false;
				}
			}
			return true;
		}
    
		boolean dia2(int player){
			for(int k = 0; k < len; k++){
				if(grid[k][len - 1 - k] != player){
					return false;
				}
			}
			return true;
		}
    
	}


 public class DesignTicTacToe {
	 
	 public static void main(String[] args) {
		 TicTacToe obj = new TicTacToe(3);
		 int param_1 = obj.move(1,2,2);
		 System.out.println(param_1);
		 int param_2 = obj.move(0,2,1);
		 System.out.println(param_2);
		 int param_3 = obj.move(0,0,2);
		 System.out.println(param_3);
		 int param_4 = obj.move(2,0,1);
		 System.out.println(param_4);
		 int param_5 = obj.move(0,1,2);
		 System.out.println(param_5);
		 int param_6 = obj.move(1,1,1);
		 System.out.println(param_6);
	 }
	 
 }

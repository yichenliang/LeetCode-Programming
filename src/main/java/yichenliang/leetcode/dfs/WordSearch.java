package yichenliang.leetcode.dfs;

/**
 *  79. Word Search
 *  
 *  dfs
 *  
 *  time complexity: O(m*n)
 *  space complexity: O(m*n + l)
 */

public class WordSearch {
	
	public boolean exist(char[][] board, String word) {
        
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        if(word.length() == 0) return false;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfsHelper(board, word, i, j, 0, visited)) return true;
            }
        }
        return false;
    }
    
    private boolean dfsHelper(char[][] board, String word, int i, int j, int index, boolean[][] visited){
        
        // end case
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        
        
        // normal case
        if(word.charAt(index) == board[i][j] && visited[i][j] == false){
            visited[i][j] = true;
            // up
            if(dfsHelper(board, word, i - 1, j, index + 1, visited)) return true;
                
            // down
            if(dfsHelper(board, word, i + 1, j, index + 1, visited)) return true;
                
            // left
            if(dfsHelper(board, word, i, j - 1, index + 1, visited)) return true;
                
            // right
            if(dfsHelper(board, word, i, j + 1, index + 1, visited)) return true;
            
            visited[i][j] = false;
        }
        return false;
        
    }

}

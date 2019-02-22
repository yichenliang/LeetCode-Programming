
public class Solution {
	
	public boolean exist(char[][] board, String word) {
        if(board == null || word == null) return false;
        if(board.length == 0 || board[0].length == 0){
            if(word.length() == 0){
                return true;
            }
            else{
                return false;
            }
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(searchHelper(board, visited, word.toCharArray(), 0, i, j)){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    boolean searchHelper(char[][] board, boolean[][] visited, char[] word, int index, int row, int col){
        
        // end case
        if(word.length == index) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(visited[row][col] == true || board[row][col] != word[index]) return false;
        
        visited[row][col] = true;
        
        //normal case
        //up
        boolean find = searchHelper(board, visited, word, index + 1, row - 1, col);
        if(find){
           return true;
        }
        
        //down
        find = searchHelper(board, visited, word, index + 1, row + 1, col); 
        if(find){
           return true;  
        }
        
        //left
        find = searchHelper(board, visited, word, index + 1, row, col - 1);
        if(find){
           return true;
        }
        
        //right
        find = searchHelper(board, visited, word, index + 1, row, col + 1);
        if(find){
            return true;
        }
        
        visited[row][col] = false;
        return false;
        
    }
    
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};	
		String word = "CCED";
		boolean result =  solution.exist(board, word);
		System.out.println(result);
		
    }
}

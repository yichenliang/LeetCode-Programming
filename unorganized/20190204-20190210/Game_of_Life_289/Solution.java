class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int live = 0;
                for(int k = Math.max(i-1, 0); k<= Math.min(i + 1, m-1); k++){
                    for(int l = Math.max(j-1, 0); l <= Math.min(j+1, n-1); l++){
                        live +=board[k][l]&1;
                    }
                }
                if(live == 3 || (live == 4 && board[i][j] == 1)){
                    board[i][j] = board[i][j] | 2;
                }
            }
        }
        
        // update
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = board[i][j] >> 1;
            }
        }
        
    }
}

// time complexity: O(mn)
// space complexity: O(1)
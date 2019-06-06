package yichenliang.leetcode.graph;

/**
 *  547. Friend Circles
 *  
 *  // DFS + graph
 *  
 *  time complexity: 
 * 
 */

public class FriendCircles {
	
	public int findCircleNum(int[][] M) {
        
        int len = M.length;
        int res = 0;
        //int[] visited = new int[len];
        for(int i = 0; i < len; i++){
           if(M[i][i] == 0) continue;
           res++;
           dfs(i, M, len);
        }
        
        return res;    
    }
    
    void dfs(int current, int[][] M, int len){
        
        for(int j = 0; j < len; j++){
            if(M[current][j] == 0){
                continue;
            }
            M[current][j] = M[j][current] = 0;
            dfs(j, M, len);
        }   
    }
    
}

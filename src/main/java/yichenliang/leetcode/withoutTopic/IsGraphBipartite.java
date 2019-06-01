package yichenliang.leetcode.withoutTopic;

/**
 *  785. Is Graph Bipartite?
 *  
 *  method : DFS
 *  
 *  time complexity: O(n*n)
 *  space complexity: O(n)
 */

public class IsGraphBipartite {
	
	public boolean isBipartite(int[][] graph) {
        
        int len = graph.length;
        int[] colors = new int[len];
        for(int i = 0; i < len; i++){
            if(colors[i] == 0){  // not be colored yet
                boolean res = dfs(graph, colors, i, 1);
                if(res == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    boolean dfs(int[][] graph, int[] colors, int num, int col){
        if(colors[num] != 0){ // already have color
            return colors[num] == col;
        }
        
        colors[num] = col;
        for(int node : graph[num]){
            if(dfs(graph, colors, node, -col) == false){
                return false;
            }
        }
        return true;
    }

}

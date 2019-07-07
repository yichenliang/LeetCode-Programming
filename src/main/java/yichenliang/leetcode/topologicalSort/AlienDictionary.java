package yichenliang.leetcode.topologicalSort;

import java.util.Arrays;

/**
 * 269. Alien Dictionary
 * 
 * dfs + topological sort
 * 
 * time complexity: O(V + E)
 * space complexity: O(n)
 */

public class AlienDictionary {
	
	public String alienOrder(String[] words) {
        
        boolean[][] graph = new boolean[26][26];
        int[] visited = new int[26];
        Arrays.fill(visited, -1);
        buildGraph(words, graph, visited);
        
        // topo sort
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            if(visited[i] == 0){
                if(!dfs(graph, visited, i, sb)){
                    return "";
                }
            }
        }
        return sb.reverse().toString();
    }
    
    private void buildGraph(String[] s, boolean[][] g, int[] v){
        int len = s.length;
        for(int i = 0; i < len; i++){
            String str = s[i];
            for(char c : str.toCharArray()){
                v[c - 'a'] = 0;
            }
            if(i != 0){
                String str1 = s[i - 1], str2 = s[i];
                int l = Math.min(str1.length(), str2.length());
                for(int j = 0; j < l; j++){
                    char ch1 = str1.charAt(j);
                    char ch2 = str2.charAt(j);
                    if(ch1 != ch2){
                        g[ch1 - 'a'][ch2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
    
    private boolean dfs(boolean[][] g, int[] v, int i, StringBuilder sb){
        v[i] = 1;
        for(int j = 0; j < 26; j++){
            if(g[i][j]){
                if(v[j] == 1) return false;
                if(v[j] == 0){
                    if(!dfs(g, v, j, sb)) return false;
                }
            }
        }
        v[i] = 2;
        sb.append((char)(i + 'a'));
        return true;
    }
}

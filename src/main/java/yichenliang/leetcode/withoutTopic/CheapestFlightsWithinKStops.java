package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *  787. Cheapest Flights Within K Stops
 * 
 *  graph dfs bfs dp
 * 
 *  dfs
 *  time complexity: O(n ^ (k + 1))
 *  space complexity: O(m)
 *  
 *  bfs
 *  time complexity: O(n ^ (k + 1))
 *  space complexity: O(n ^ (k + 1))
 *  
 *  dp
 *  time complexity: O(k*m)
 *  space complexity: O(n)
 */

public class CheapestFlightsWithinKStops {
	
	// dfs
	public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] each : flights){
            if(!graph.containsKey(each[0])){
                List<int[]> l = new ArrayList<>();
                graph.put(each[0], l);
            }
            graph.get(each[0]).add(new int[] {each[1], each[2]});
        }
        
        int[] ans = {Integer.MAX_VALUE};
        dfs(graph, K + 1, src, dst, 0, ans);
        return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
    }
    
    private void dfs(Map<Integer, List<int[]>> graph, int k, int src, int dst, int cost, int[] ans){
            if(dst == src){
                ans[0] = cost;
                return;
            }
            
            if(k == 0){
                return;
            }
            
            if(graph.containsKey(src)){
               for(int[] e : graph.get(src)){
                 if(cost + e[1] > ans[0]) continue;
                 dfs(graph, k - 1, e[0], dst, cost + e[1], ans);
               } 
            }      
    }
    
    ////////////////////////////////////
    // bfs
    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] each : flights){
            if(!graph.containsKey(each[0])){
                List<int[]> l = new ArrayList<>();
                graph.put(each[0], l);
            }
            graph.get(each[0]).add(new int[] {each[1], each[2]});
        }
        
        int ans = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src, 0});
        int steps = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                int[] cur = q.poll();
                int next = cur[0];
                int cost = cur[1];
                if(next == dst) ans = Math.min(ans, cost);
                if(graph.containsKey(next)){
                  for(int[] e : graph.get(next)){
                        if(cost + e[1] > ans) continue;
                        q.offer(new int[] {e[0], cost + e[1]});
                  }  
                }
                size--;
            }
            if(steps > K) break;
            steps++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /////////////////////////////////
    // dp
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] dp = new int[K + 2][n];
        for(int[] e : dp){
            Arrays.fill(e, Integer.MAX_VALUE / 2);
        }
        dp[0][src] = 0;
        
        for(int i = 1; i <= K + 1; i++){
            dp[i][src] = 0;
            for(int[] e : flights){
               dp[i][e[1]] = Math.min(dp[i][e[1]], dp[i - 1][e[0]] + e[2]);
               dp[i][e[1]] = Math.min(dp[i][e[1]], dp[i - 1][e[1]]);
            }
        }
        return dp[K + 1][dst] >= Integer.MAX_VALUE/2 ? -1 : dp[K + 1][dst];
    }
}

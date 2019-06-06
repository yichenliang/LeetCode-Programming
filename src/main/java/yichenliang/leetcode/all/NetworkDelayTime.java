package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *  743. Network Delay Time
 *  
 *  Method 1: Bellman-Ford
 *  time complexity: O(N*E)  N is the number of node, and E is the number of edges
 *  space complexity: O(n)
 *  
 *  Method 2: Dijkstra
 *  time complexity: O()
 *  space complexity: O()
 */

public class NetworkDelayTime {
	
	// method1: Bellman-Ford
	public int networkDelayTime1(int[][] times, int N, int K) {
        // Bellman-Ford 
        int[] res = new int[N];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[K - 1] = 0;
        int len = times.length;
        // N - 1 times iteration
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < len; j++){
                int source = times[j][0];
                int destination = times[j][1];
                int weight = times[j][2];
                if(res[source - 1] != Integer.MAX_VALUE){
                    res[destination - 1] = Math.min(res[destination - 1], weight + res[source - 1]);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            ans = Math.max(ans, res[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
	
	// Dijkstra
	public int networkDelayTime2(int[][] times, int N, int K) {
        int len = times.length;
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i = 0; i < len; i++){
            if(!graph.containsKey(times[i][0])){
                graph.put(times[i][0], new ArrayList<int[]>());
            }
            graph.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
              (n1, n2) -> n1[0] - n2[0]
        );
        
        heap.offer(new int[]{0, K});
        
        Map<Integer, Integer> visited = new HashMap<>();
        
        while(!heap.isEmpty()){
            int[] data = heap.poll();
            int d = data[0];
            int node = data[1];
            if(visited.containsKey(node)){
                continue;
            }
            visited.put(node, d);
            if(graph.containsKey(node)){
                for(int[] edge: graph.get(node)){
                    int nei = edge[0], d2 = edge[1];
                    if(!visited.containsKey(nei)){
                        heap.offer(new int[]{d + d2, nei});
                    }
                }
            }
        }
        
        if(visited.size() != N){
            return -1;
        }
        int ans = 0;
        for(int cand : visited.values()){
            ans = Math.max(ans, cand);
        }
        return ans;
    }
}

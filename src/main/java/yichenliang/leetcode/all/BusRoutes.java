package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 815. Bus Routes
 * 
 * time complexity: O(m * n)
 * space complexity:O(m * n) 
 * 
 */

public class BusRoutes {
	
public int numBusesToDestination(int[][] routes, int S, int T) {
        
        if(S == T){
            return 0;
        }
        
        // build graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int len = routes.length;
        for(int i = 0; i < len; i++){
            for(int stop : routes[i]){
                if(!graph.containsKey(stop)){
                    List<Integer> l = new ArrayList<>();
                    graph.put(stop, l);
                }
                graph.get(stop).add(i);
            }   
        }
         // BFS
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> q = new LinkedList<>();
            q.offer(S);
            int buses = 0;
            
            while(!q.isEmpty()){
                int size = q.size();
                buses++;
                while(size > 0){
                    int cur = q.poll();
                    for(int bus : graph.get(cur)){
                        if(visited.contains(bus)) continue;
                        visited.add(bus);
                        for(int stop : routes[bus]){
                            if(stop == T) return buses;
                            q.offer(stop);
                        }
                    }
                    size--;
                }
            }
        return -1;
    }

}

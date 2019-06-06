package yichenliang.leetcode.graph;

import java.util.HashSet;
import java.util.List;

/**
 * 841. Keys and Rooms
 *
 * graph
 * 
 * time complexity: O(n)
 * space complexity: O(node)
 * 
 */

public class KeysAndRooms {
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        int len = rooms.size();
        HashSet<Integer> visited = new HashSet<>();
        
        dfs(rooms, visited, 0);
        return len == visited.size(); 
    }
    
    private void dfs(List<List<Integer>> rooms, HashSet<Integer> visited, int index){
        if(visited.contains(index)) return;
        
        visited.add(index);
        List<Integer> nextRooms = rooms.get(index);
        for(int each : nextRooms){
            dfs(rooms, visited, each);
        }
    }

}

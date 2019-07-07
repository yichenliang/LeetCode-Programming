package yichenliang.leetcode.topologicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 207. Course Schedule
 * 
 * dfs + topological sort
 *
 * time complexity:O(n) 
 * space complexity: O(m + n)
 * 
 */

public class CourseSchedule {
	
//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//        
//        Map<Integer, List<Integer>> store = new HashMap<>();
//        int len = prerequisites.length;
//        for(int i = 0; i < len; i++){
//        	if(store.containsKey(prerequisites[i][0])) {
//        		int key = prerequisites[i][0];
//        		store.get(key).add(prerequisites[i][1]);
//        	}
//        	else {
//        		List<Integer> value = new ArrayList<>();
//        		value.add(prerequisites[i][1]);
//        		store.put(prerequisites[i][0], value);
//        	}   
//        }
//        
//        int[] visited = new int[numCourses];
//        
//        for(int i = 0; i < len; i++){
//            int key = prerequisites[i][0];
//            if(!dfs(store, visited, key)){
//               return false; 
//            }
//        }
//        
//        return true;
//    }
//    
//    boolean dfs(Map<Integer, List<Integer>> map, int[] vis, int k){
//    	
//    	// end case
//        if(vis[k] == 1){
//            return false;
//        }
//        
//        if(map.get(k) == null && vis[k] != 1){
//            return true;
//        }
//        
//        // normal case
//        vis[k] = 1;
//        List<Integer> valueSet = map.get(k);
//        for(int val : valueSet) {
//        	if(!dfs(map, vis, val)){
//                return false;
//            }
//        }
//        vis[k] = 0;
//        return true;
//    }
	
	// much faster! use this one
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> store = new HashMap<>();
        int len = prerequisites.length;
        for(int i = 0; i < len; i++){
        	if(store.containsKey(prerequisites[i][0])) {
        		int key = prerequisites[i][0];
        		store.get(key).add(prerequisites[i][1]);
        	}
        	else {
        		List<Integer> value = new ArrayList<>();
        		value.add(prerequisites[i][1]);
        		store.put(prerequisites[i][0], value);
        	}   
        }
        
        int[] visited = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++){
            if(visited[i] == 0 && store.get(i) != null){
                if(!dfs(store, visited, i)) return false;
            }
        }
        
        return true;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> map, int[] vis, int k){
        //visiting
        vis[k] = 1;
        for(Integer i : map.get(k)){
            if(vis[i] == 1) return false;
            if(vis[i] == 0 && map.get(i) != null){
                if(!dfs(map, vis, i)) return false;
            }
        }
        vis[k] = 2;
        return true;
    }

}

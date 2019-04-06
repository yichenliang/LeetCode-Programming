package yichenliang.leetcode.withoutTopic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 939. Minimum Area Rectangle
 * 
 * math: use diagonal to determine rectangle
 * 
 * time complexity: O(n^2)
 * space complexity: O(n)
 */

public class MinimumAreaRectangle {
	
	  public int minAreaRect(int[][] points) {
		  
		  int ans = Integer.MAX_VALUE;
	        
	        Map<Integer, Set<Integer>> store =new HashMap<>();
	        
	        for(int[] point : points){
	            if(!store.containsKey(point[0])){
	                store.put(point[0], new HashSet<>());
	            }
	            store.get(point[0]).add(point[1]);
	        }
	        
	        // scan every possible pairs to find a diagonal, and check whether this diagonal could form a rectangle
	        int len = points.length;
	        for(int i = 0; i < len; i++){
	            for(int j = 0; j < len; j++){
	                if(points[i][0] == points[j][0] || points[i][1] == points[j][1]){
	                    continue;
	                }
	                
	                if(store.get(points[i][0]).contains(points[j][1]) && store.get(points[j][0]).contains(points[i][1])){
	                    
	                    int curAns = Math.abs(points[i][0] - points[j][0]) * Math.abs(points[i][1] - points[j][1]);
	                    ans = Math.min(ans, curAns);
	                }
	            }
	        }
	        
	        return ans == Integer.MAX_VALUE ? 0 : ans;
	        
	  }
	       
}

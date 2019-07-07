package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 210. Course Schedule II
 * 
 * topological sort
 * 
 * time complexity: O(V + E)
 * space complexity: O(n)
 * 
 * 
 */

public class CourseScheduleII {

	 public int[] findOrder(int numCourses, int[][] prerequisites) {
	        
	        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0){
	            int[] res = new int[numCourses];
	            for(int i = 0; i < numCourses; i++){
	                res[i] = i;
	            }
	        } 
	        
	        HashMap<Integer, List<Integer>> g = new HashMap<>();
	        buildGraph(g, prerequisites);
	        
	        Stack<Integer> stack = new Stack<>();
	        int[] v = new int[numCourses];
	        for(int i = 0; i < numCourses; i++){
	            if(v[i] == 0){
	                if(!dfs(g, v, i, stack)){
	                    return new int[] {};
	                }  
	            }
	        }
	        int size = stack.size();
	        int[] res = new int[size];
	        int i = size - 1;
	        while(!stack.isEmpty()){
	            res[i] = stack.pop();
	            i--;
	        }
	        return res;
	    }
	    
	    private void buildGraph(HashMap<Integer, List<Integer>> g, int[][] p){
	        int len = p.length;
	        for(int i = 0; i < len; i++){
	            int key = p[i][0];
	            if(g.containsKey(key)){
	                g.get(key).add(p[i][1]);
	            }
	            else{
	                List<Integer> value = new ArrayList<>();
	                value.add(p[i][1]);
	                g.put(key, value);
	            }
	        }
	    }
	    
	    private boolean dfs(HashMap<Integer, List<Integer>> g, int[] v, int k, Stack<Integer> stack){
	        if(g.get(k) != null){
	            v[k] = 1;
	            for(int i : g.get(k)){
	                if(v[i] == 1) return false;
	                if(v[i] == 0){
	                    if(!dfs(g, v, i, stack)){
	                        return false;
	                    }
	                }
	            }
	        }
	        stack.push(k);
	        v[k] = 2;
	        return true;
	    }
}

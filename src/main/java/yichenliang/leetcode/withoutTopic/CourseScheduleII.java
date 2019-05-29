package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * 210. Course Schedule II
 * 
 * topologic sort
 * 
 */

public class CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int len = prerequisites.length;
        for(int i = 0; i < len; i++){
            int key = prerequisites[i][1];
            if(graph.containsKey(key)){
                graph.get(key).add(prerequisites[i][0]);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(key, list);
            }
        }
        
        int[] visit = new int[numCourses];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < numCourses; i++){
            if(dfs(i, graph, visit, stack)){
                int[] ans = {};
                return ans;
            }
        }
        
        // reverse stack
        int size = stack.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = stack.pop();
        }
        return ans;
    }
    
    
    boolean dfs(int cur, HashMap<Integer, List<Integer>> graph, int[] visit, Stack<Integer> stack){
        
        if(visit[cur] == 1){   
            return true;  // cause loop
        }
        
        if(visit[cur] == 2){
            return false;  // if it is visited, there is no need for further checking
        }
        
        visit[cur] = 1; // visiting
        
        List<Integer> curList = graph.get(cur);
        if(curList != null){
            for(Integer num : curList){
                if(dfs(num, graph, visit, stack)){
                    return true;
                }
            }   
        }
        
        visit[cur] = 2;  // visited
        stack.push(cur);
        return false;
    }
}

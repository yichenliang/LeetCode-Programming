package yichenliang.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *  863. All Nodes Distance K in Binary Tree
 *  
 *  graph + dfs + bfs
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class AllNodesDistanceKInBinaryTree {

	 class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }

	 public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
	        buildGraph(graph, root, null);
	        List<Integer> res = new ArrayList<>();
	        Queue<TreeNode> q = new LinkedList<>();
	        Set<TreeNode> visited = new HashSet<>();
	        int k = 0;
	        q.offer(target);
	        visited.add(target);
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int i = 0; i < size; i++){
	                TreeNode current = q.poll();
	                if(k == K){
	                    res.add(current.val);
	                }
	                else{
	                   List<TreeNode> l = graph.get(current);
	                   for(TreeNode each : l){
	                        if(each != null && !visited.contains(each)){
	                            visited.add(each);
	                            q.offer(each);
	                        }
	                    } 
	                }
	            }
	            k++;
	        }
	         return res;   
	    }
	    
	     private void buildGraph(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode p){
	        if(node == null) return;
	            if(!graph.containsKey(node)) graph.put(node, new ArrayList<TreeNode>());
	            if(!graph.containsKey(p)) graph.put(p, new ArrayList<TreeNode>());
	            
	            graph.get(node).add(p);
	            graph.get(p).add(node);
	            
	            buildGraph(graph, node.left, node);
	            buildGraph(graph, node.right, node);
	        
	    }

}

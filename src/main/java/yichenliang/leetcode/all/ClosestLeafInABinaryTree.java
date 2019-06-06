package yichenliang.leetcode.all;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 742. Closest Leaf in a Binary Tree
 * 
 *  Graph + DFS + BFS
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class ClosestLeafInABinaryTree {
	
	public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        dfs(graph, root, null);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();

        for (TreeNode node: graph.keySet()) {
            if (node != null && node.val == k) {
                queue.add(node);
                seen.add(node);
                break;
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                if (node != null) {
                    if (graph.get(node).size() <= 1)
                        return node.val;
                    for (TreeNode nei: graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            queue.add(nei);
                        }
                    }
                }
                size--;
            }   
        }
        return -1;
    }

    public void dfs(Map<TreeNode, List<TreeNode>> graph, TreeNode node, TreeNode parent) {
        if (node != null) {
            if (!graph.containsKey(node)) graph.put(node, new LinkedList<TreeNode>());
            if (!graph.containsKey(parent)) graph.put(parent, new LinkedList<TreeNode>());
            graph.get(node).add(parent);
            graph.get(parent).add(node);
            dfs(graph, node.left, node);
            dfs(graph, node.right, node);
        }
    }

}

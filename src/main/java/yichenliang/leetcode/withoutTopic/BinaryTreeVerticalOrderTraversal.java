package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  314. Binary Tree Vertical Order Traversal
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class BinaryTreeVerticalOrderTraversal {
	
	class Wrapper{
        int level;
        TreeNode node;
        Wrapper(int l, TreeNode root){
            level = l;
            node = root;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        Queue<Wrapper> queue = new LinkedList<>();
        Wrapper w = new Wrapper(0, root);
        queue.offer(w);
        
        int maxLevel = Integer.MIN_VALUE;
        int minLevel = Integer.MAX_VALUE;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Wrapper temp = queue.poll();
                if(temp.node == null){
                    continue;
                }
                int level = temp.level;
                maxLevel = Math.max(level, maxLevel);
                minLevel = Math.min(level, minLevel);
                if(map.containsKey(level)){
                    map.get(level).add(temp.node.val);
                }
                else{
                    List<Integer> l = new ArrayList<>();
                    l.add(temp.node.val);
                    map.put(level, l);
                }
                queue.offer(new Wrapper(level - 1, temp.node.left));
                queue.offer(new Wrapper(level + 1, temp.node.right));    
            }   
        }
        
        for(int i = minLevel; i <= maxLevel; i++){
            ans.add(map.get(i));   
        }
        return ans;
    }
}

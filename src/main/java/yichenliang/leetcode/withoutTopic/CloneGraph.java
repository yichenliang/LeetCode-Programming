package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 133. Clone Graph
 * 
 * method: HashMap, BFS
 * 
 */

public class CloneGraph {
	
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	public Node cloneGraph(Node node) {
        
        if(node == null) return null;
        
        // bfs
        LinkedList<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();  // key: old node, value: new node
        
        queue.offer(node);
        map.put(node, null);
        
        // first: clone node
        while(queue.size() > 0){
            Node curr = queue.poll();
            Node copy = new Node(curr.val, new ArrayList<Node>());
            map.put(curr, copy);
            for(Node n : curr.neighbors){
                if(!map.containsKey(n)){
                    queue.offer(n);
                    map.put(n, null);
                }
            }  
        }
        
        // second: clone edges (relations between two nodes)
        for(Node keyNode : map.keySet()){
            Node cpyNode = map.get(keyNode);
            for(Node n : keyNode.neighbors){
                cpyNode.neighbors.add(map.get(n));
            }
        }
        
        return map.get(node);
    }

}

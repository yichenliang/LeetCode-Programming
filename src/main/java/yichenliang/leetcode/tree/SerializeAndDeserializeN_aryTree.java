package yichenliang.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *  428. Serialize and Deserialize N-ary Tree
 *  
 *  method : dfs + stack
 *  
 *  serialize : Node -> String
 *  dfs
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 *  deserialize : String -> Node
 *  stack
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class SerializeAndDeserializeN_aryTree {
	
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	
	// Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        //sb.append('[');
        dfsSerialize(root, sb);
        String ans = sb.toString();
        return ans;
    }
    
    void dfsSerialize(Node root, StringBuilder sb){
        // end case
        if(root == null){
            return;
        }
        
        sb.append(root.val);
        sb.append(" ");
        List<Node> c = root.children;
        sb.append('[');
        sb.append(" ");
        if(c != null){
           for(Node n : c){
                dfsSerialize(n, sb); 
           } 
        }
        sb.append(']');
        sb.append(" ");
    }
    
    
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        
        if(data.equals("")){
            return null;
        }
        
        // normal case
        String[] elements = data.split(" "); 
        int len = elements.length;
        
        Stack<String> stackNum = new Stack<>();
        Stack<Node> stackNode = new Stack<>();
        
        for(int i = 0; i < len; i++){
            if(elements[i].equals("[")){
                stackNum.push(elements[i]);
            }
            else if(elements[i].equals("]")){
                LinkedList<Node> temp = new LinkedList<>();
                if(stackNum.peek().equals("[")){
                    // do nothing
                }
                else{
                    while(!stackNum.peek().equals("[")){
                        Node tempN = stackNode.pop();
                        temp.addFirst(tempN);
                        stackNum.pop();  
                    }
                    
                }
                stackNum.pop();
                stackNode.peek().children = temp;
            }
            else{ // number
                stackNum.push(elements[i]);
                int v = Integer.parseInt(elements[i]);
                List<Node> c = null;
                Node n = new Node(v, c);
                stackNode.push(n);
            }
            
        }
        return stackNode.pop();
    }
	
}

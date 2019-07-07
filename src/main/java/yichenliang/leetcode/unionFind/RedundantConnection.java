package yichenliang.leetcode.unionFind;

import java.util.Arrays;

/**
 * 684. Redundant Connection
 * 
 * union find
 * 
 * time complexity: O(n^2)
 * space complexity: O(n)
 * 
 */

public class RedundantConnection {
	
//	public int[] findRedundantConnection(int[][] edges) {
//        int len = edges.length;
//        int[] root = new int[len + 1];
//        int[] size = new int[len + 1];
//        
//        Arrays.fill(size, 1);
//        for(int i = 1; i <= len; i++){
//            root[i] = i;
//        }
//        
//        for(int[] each : edges){
//            int u = each[0];
//            int v = each[1];
//            int ru = find(root, u);
//            int rv = find(root, v);
//            if(ru == rv){
//                return each;
//            }
//            
//            if(size[ru] < size[rv]){
//                size[rv] += size[ru];
//                root[ru] = rv;
//            }
//            else{
//                size[ru] += size[rv];
//                root[rv] = ru;
//            }
//        }
//        return new int[] {};
//    }
//    
//    private int find(int[] root, int n){
//        if(root[n] != n){
//            root[n] = find(root, root[n]); 
//        }
//        return root[n];
//    }
	
	public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] root = new int[len + 1];
        int[] size = new int[len + 1];
        for(int i = 1; i <= len; i++){
            root[i] = i;
        }
        Arrays.fill(size, 1);
        for(int i = 0; i < len; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int ru = find(root, u);
            int rv = find(root, v);
            if(ru == rv){
                return edges[i];
            }
            else{ // union them
                int sizeU = size[ru];
                int sizeV = size[rv];
                if(sizeU > sizeV){
                    size[ru] += size[rv];
                    root[rv] = root[ru];
                }
                else{
                    size[rv] += size[ru];
                    root[ru] = root[rv];
                }
            }
        }
        return new int[] {-1, -1};
    }
    
    private int find(int[] root, int n){
        if(root[n] == n) return n;
        return find(root,root[n]);
    }
    
    public static void main(String[] args) {
    	RedundantConnection solution = new RedundantConnection();
    	int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
    	int[] res = solution.findRedundantConnection(edges);
    	System.out.println(res);
    }

}

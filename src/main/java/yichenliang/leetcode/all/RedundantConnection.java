package yichenliang.leetcode.all;

import java.util.Arrays;

/**
 * 684. Redundant Connection
 * 
 * union find
 * 
 * time complexity: 
 * space complexity: 
 * 
 */

public class RedundantConnection {
	
	public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        int[] root = new int[len + 1];
        int[] size = new int[len + 1];
        
        Arrays.fill(size, 1);
        for(int i = 1; i <= len; i++){
            root[i] = i;
        }
        
        for(int[] each : edges){
            int u = each[0];
            int v = each[1];
            int ru = find(root, u);
            int rv = find(root, v);
            if(ru == rv){
                return each;
            }
            
            if(size[ru] < size[rv]){
                size[rv] += size[ru];
                root[ru] = rv;
            }
            else{
                size[ru] += size[rv];
                root[rv] = ru;
            }
        }
        return new int[] {};
    }
    
    private int find(int[] root, int n){
        if(root[n] != n){
            root[n] = find(root, root[n]); 
        }
        return root[n];
    }

}

package yichenliang.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 149. Max Points on a Line
 * 
 * use data type: double !
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(m)
 */


public class MaxPointsOnALine {
	
	public int maxPoints(int[][] points) {
        int max = 0;
        int len = points.length;
        for(int i = 0; i < len; i++){
            int dup = 1;
            int curMax = 0;
            Map<Double, Integer> map = new HashMap<>();
            for(int j = 0; j < len; j++){
                if(i == j) continue; // the same point
                
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]){
                    dup++;
                    continue;
                }
                
                double k = getK(points[i], points[j]);
                map.put(k, map.getOrDefault(k, 0) + 1);
                curMax = Math.max(curMax, map.get(k));
            }
            max = Math.max(max, curMax + dup);
        }
        return max;
    }
    
    private double getK(int[] a, int[] b){
        if(a[0] == b[0]){  // vertical case |
            return Double.MAX_VALUE;
        }
        return (double)(a[0] - b[0]) / (double)(a[1] - b[1]);
    }
	 
}

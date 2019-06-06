package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 *  986. Interval List Intersections
 *  
 *  time complexity: O(n + m)
 *  space complexity: O(1)
 *   
 */

public class IntervalListIntersections {

	public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        int lenA = A.length;
        int lenB = B.length;
        
        int i = 0;
        int j = 0;
        
        List<List<Integer>> res = new ArrayList<>();
        
        while(i < lenA && j < lenB){
            int start = Math.max(A[i][0], B[j][0]);
            int end = Math.min(A[i][1], B[j][1]);
            
            if(start <= end){
                List<Integer> curRes = new ArrayList<>();
                curRes.add(start);
                curRes.add(end);
                res.add(curRes);
            }
            
            if(A[i][1] <= B[j][1]){
                i++;
            }
            else{
                j++;
            }
            
        }
        
        int len = res.size();
        int[][] ans = new int[len][2];
        
        for(int k = 0; k < len; k++){
            ans[k][0] = res.get(k).get(0);
            ans[k][1] = res.get(k).get(1);
        }
        
        return ans;
        
    }

}

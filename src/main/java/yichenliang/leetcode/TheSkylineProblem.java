package yichenliang.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 *  218. The Skyline Problem
 *   
 * 
 */

public class TheSkylineProblem {
	
	public List<int[]> getSkyline(int[][] buildings) {
        
        List<int[]> res = new ArrayList<>();
        List<int[]> buildingPoints = new ArrayList<>();
        
        for(int[] b : buildings){
            buildingPoints.add(new int[] {b[0], -b[2]});  // start point
            buildingPoints.add(new int[] {b[1], b[2]});  // end point
        }
        
        // sort points in buildingPoints
        Collections.sort(buildingPoints, (a, b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            else{  // x coordinate is the same
                return a[1] - b[1];
            }
        });
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(0);
        int preMax = 0;
        for(int[] bp : buildingPoints){
            if(bp[1] < 0){
                maxHeap.offer(-bp[1]);
            }
            else{
                maxHeap.remove(bp[1]);
            }
            int currentHeight = maxHeap.peek();
            if(currentHeight != preMax){
                res.add(new int[] {bp[0], currentHeight});
                preMax = currentHeight;
            }
        }
        return res;   
    }

}

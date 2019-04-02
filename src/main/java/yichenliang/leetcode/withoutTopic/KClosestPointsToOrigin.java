package yichenliang.leetcode.withoutTopic;

import java.util.Arrays;

/**
 *  973. K Closest Points to Origin
 *  
 *  // Quick sort
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 * 
 */

public class KClosestPointsToOrigin {
	public int[][] kClosest(int[][] points, int K) {
	    int len = points.length;
	    int left = 0;
	    int right = len - 1;
	    
	    while(true) {
	    	int pivot = partition(left, right, points);
	    	
	    	if(pivot == K - 1) {
	    		break;
	    	}
	    	else if(pivot > K - 1) {
	    		right = pivot - 1;
	    	}
	    	else if(pivot < K) {
	    		left = pivot + 1;
	    	}
	    }
	    
	    return Arrays.copyOfRange(points, 0, K);
	}
	
	public int partition(int left, int right, int[][] points) {
		int pivot = dist(left, points);
		swap(left, right, points);
		int index = left;
		
		for(int i = left; i < right; i++) {
			if(dist(i, points) < pivot) {
				swap(index, i, points);
				index++;
			}
		}
		swap(index, right, points);
		return index;
	}

	public int dist(int i, int[][]points) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }
	
	public void swap(int left, int right, int[][]points){
		int temp0 = points[left][0];
		int temp1 = points[left][1];
		
		points[left][0] = points[right][0];
		points[left][1] = points[right][1];
		
		points[right][0] = temp0;
		points[right][1] = temp1;		
	}
}

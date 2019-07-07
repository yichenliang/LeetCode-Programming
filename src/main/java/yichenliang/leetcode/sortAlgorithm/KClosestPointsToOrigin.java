package yichenliang.leetcode.sortAlgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *  973. K Closest Points to Origin
 *  
 *  // Quick sort
 *  time complexity: O(nlogn)
 *  space complexity: O(1)
 *  
 *  // priority queue
 *  time complexity: O(nlogn)
 *  space complexity: O(n)
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
	
	// pq
	public int[][] kClosest2(int[][] points, int K) {
        
        if(points == null || points.length == 0 || points[0].length == 0){
            return null;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        int len = points.length;
        
        for(int i = 0; i < len; i++){
            pq.offer(points[i]);
        }
        
        int[][] res = new int[K][2];
        for(int i = 1; i <= K; i++){
            res[i - 1] = pq.poll();
        }
        return res;
    }
}

package yichenliang.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  346. Moving Average from Data Stream
 *  
 *  design + queue
 *  
 *  time complexity: O(n)
 *  space complexity: O(size)
 *  
 *  2019/8/11
 * 
 */

public class MovingAverageFromDataStream {
	
	class MovingAverage {

	    Queue<Integer> q;
	    int size;
	    int sum;
	    /** Initialize your data structure here. */
	    public MovingAverage(int size) {
	        q = new LinkedList<>();
	        this.size = size;
	        sum = 0;
	    }
	    
	    public double next(int val) {
	        if(q.size() == size){
	            int former = q.poll();
	            sum = sum - former;
	        }
	        q.offer(val);
	        sum = sum + val;
	        double d = (double) q.size();
	        return sum / d;
	    }
	}
}

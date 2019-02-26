package yichenliang.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 362. Design Hit Counter
 */

public class DesignHitCounter {
	
	Deque<Integer> queue;
	 
    /** Initialize your data structure here. */
    public DesignHitCounter() {
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);   
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && timestamp - queue.peek() >= 300){
            queue.poll();
        }
        return queue.size();
    }

}

package yichenliang.leetcode.slidingWindow;

/**
 *  239. Sliding Window Maximum
 *  
 *  sliding window + dequeue
 *  
 *  time complexity: o(n)
 *  space complexity: o(k)
 *  
 */

import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] res = new int[nums.length - k + 1];  
        
        if(nums.length == 0) return new int[0]; 
        
        Deque<Integer> deque = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++){
            
        	//remove the element outside the current window
        	if(!deque.isEmpty() && deque.peekFirst() == i-k){
                deque.poll();
            }
            
            // the numbers stored in deque is decreasing, the first one is the largest one
        	while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }
            
            deque.offerLast(i);
            
            // the first element in deque is always want we want inside the current window
            if(i + 1 >= k){
                res[i + 1 - k] = nums[deque.peek()];
            }
        }
          
        return res;
    }
}
	
    

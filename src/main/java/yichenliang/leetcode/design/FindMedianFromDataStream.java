package yichenliang.leetcode.design;

import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * 
 * Design
 * 
 * add
 * time complexity: O(logN)
 * space complexity: O(n)
 * 
 * find
 * time complexity: O(1)
 * space complexity: O(n)
 * 
 **/

public class FindMedianFromDataStream {

	class MedianFinder {
	    
	    PriorityQueue<Integer> minHeap;
	    PriorityQueue<Integer> maxHeap;

	    /** initialize your data structure here. */
	    public MedianFinder() {
	        minHeap = new PriorityQueue<>();
	        maxHeap = new PriorityQueue<>();
	    }
	    
	    // always let minHeap(right half of sorted data Stream) >= maxHeap   In large case, only more than 1
	    public void addNum(int num) {
	        
	        // step one: put it
	        if(minHeap.size() == 0 || num >= minHeap.peek()){
	            minHeap.add(num);
	        }
	        else{
	            maxHeap.add(-num);
	        }
	        
	        // step two: balance it
	        if(maxHeap.size() > minHeap.size()){
	            minHeap.add(-maxHeap.poll());
	        }
	        else if(minHeap.size() - maxHeap.size() == 2){
	            maxHeap.add(-minHeap.poll());
	        }
	    }
	    
	    public double findMedian() {
	        if(minHeap.size() > maxHeap.size()){
	            return minHeap.peek();
	        }
	        else{
	            return (minHeap.peek() - maxHeap.peek())/2.0;
	        }
	    }
	}

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class MedianFinder {

    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    
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

// time complexity: addNum O(logN)   findMedian O(1)
// space complexity: O(N)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] res = new int[nums.length - k + 1];  
        
        if(nums.length == 0) return new int[0]; 
          
        PriorityQueue<Integer> store =
            new PriorityQueue<Integer>((n1, n2) -> n2 - n1);
        
        for(int i = 0; i < k - 1; i++){
            store.add(nums[i]);
        }
        
        int index = 0;
        for(int j = k - 1; j < nums.length; j++){
            store.add(nums[j]);
            res[index] = store.peek();
            store.remove(nums[index]);
            index++;
        }
        return res;
    }
}

// time complexity: o(nlogk) 
// space complexity: O(K)

// simpler API version
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] res = new int[nums.length - k + 1];  
        
        if(nums.length == 0) return new int[0]; 
        
        Deque<Integer> deque = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++){
            if(!deque.isEmpty() && deque.peekFirst() == i-k){
                deque.pollFirst();
            }
            
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            
            deque.add(i);
            
            if(i + 1 >= k){
                res[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
          
        return res;
    }
}
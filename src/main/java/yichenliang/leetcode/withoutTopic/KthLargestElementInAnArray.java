package yichenliang.leetcode.withoutTopic;

public class KthLargestElementInAnArray {
	
	public int findKthLargest(int[] nums, int k) {
        
	       // edge case
	        if(nums == null || nums.length == 0){
	            return 0;
	        }
	        
	        int len = nums.length;
	        int left = 0;
	        int right = len - 1;
	        int target = len - k;
	        while(true){
	            int index = partition(nums, left, right);
	            
	            if(index == target){
	                return nums[index];
	            }
	            
	            if(index > target){
	                right = index - 1;
	            }
	            
	            if(index < target){
	                left = index + 1;
	            }   
	        }
	    }
	    
	    int partition(int[] nums, int left, int right){
	        int pivot = nums[left];
	        
	        // quick sort
	        int slow = left;
	        int fast = left;
	        swap(nums, left, right);
	        while(fast < right){
	            if(nums[fast] < pivot){
	                swap(nums, slow, fast);
	                slow++;
	            }
	            fast++;
	        }
	        swap(nums, slow, right);
	        return slow;
	    }
	    
	    void swap(int[] nums, int a, int b){
	        int temp = nums[a];
	        nums[a] = nums[b];
	        nums[b] = temp;
	    }

}

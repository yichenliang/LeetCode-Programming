package yichenliang.leetcode.sortAlgorithm;

/**
 *  215. Kth Largest Element in an Array
 * 
 *  // Quick sort
 *  time complexity: O(nlogn)
 *  space complexity: O(1)
 * 
 */

public class KthLargestElementInAnArray {
	
//	public int findKthLargest(int[] nums, int k) {
//        
//	       // edge case
//	        if(nums == null || nums.length == 0){
//	            return 0;
//	        }
//	        
//	        int len = nums.length;
//	        int left = 0;
//	        int right = len - 1;
//	        int target = len - k;
//	        while(true){
//	            int index = partition(nums, left, right);
//	            
//	            if(index == target){
//	                return nums[index];
//	            }
//	            
//	            if(index > target){
//	                right = index - 1;
//	            }
//	            
//	            if(index < target){
//	                left = index + 1;
//	            }   
//	        }
//	    }
//	    
//	    int partition(int[] nums, int left, int right){
//	        int pivot = nums[left];
//	        
//	        // quick sort
//	        int slow = left;
//	        int fast = left;
//	        swap(nums, left, right);
//	        while(fast < right){
//	            if(nums[fast] < pivot){
//	                swap(nums, slow, fast);
//	                slow++;
//	            }
//	            fast++;
//	        }
//	        swap(nums, slow, right);
//	        return slow;
//	    }
//	    
//	    void swap(int[] nums, int a, int b){
//	        int temp = nums[a];
//	        nums[a] = nums[b];
//	        nums[b] = temp;
//	    }
	    
	public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int len = nums.length;
        while(true){
            int p = partition(nums, left, right);
            
            if(p == len - k){
                return nums[p];
            }
            else if(p < len - k){
                left = p + 1;
            }
            else{
                right = p - 1;
            }
        }
    }
    
    private int partition(int[] nums, int l, int r){
        int p = nums[l];
        swap(nums, l, r);
        int index = l;
        for(int i = l; i < r; i++){
            if(nums[i] <= p){
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, r);
        return index;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
	    
	    public static void main(String[] args) {
	    	KthLargestElementInAnArray soluetion = new KthLargestElementInAnArray();
//	    	int[] nums = {3,2,1,5,6,4};
//	    	int k = 2;
	    	int[] nums = {-1, 2, 0};
	    	int k = 1;
	    	int res = soluetion.findKthLargest(nums, k);
	    }

}

// using quick sort 

class Solution {
public int findKthLargest(int[] nums, int k) {
        
        if(nums == null || nums.length == 0) return 0;
        
        int left = 0;
        int right = nums.length - 1;
        int k_smallest = nums.length - k;
        while(true){
            //if(left == right) return nums[left];
            
            int pivot = partition(left, right, nums); 
            
            if(k_smallest == pivot){
                return nums[k_smallest];
            }
            else if(k_smallest < pivot){
                right = pivot - 1;
            }
            else if(k_smallest > pivot){
                left = pivot + 1;
            }
            
        }    
    }
    
    public int partition(int left, int right, int[] nums){
        int pivotNum = nums[left];
        swap(left, right, nums);
        int store = left;
        
        for(int i = left; i < right; i++){
            if(nums[i] < pivotNum){
                swap(store, i, nums);
                store++;
            }
        }
        
        swap(store, right, nums);
        return store;
    }
    
    public void swap(int i, int j, int[]nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
  
  public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		int result =  solution.findKthLargest(nums, k);
		System.out.println(result);
		
  }
  
}
	
  
// time complexity: o(n)
// space complexity: o(1)
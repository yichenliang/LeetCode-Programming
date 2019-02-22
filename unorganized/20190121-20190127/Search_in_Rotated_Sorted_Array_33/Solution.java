public class Solution {
	
	int[] nums;
    int target;
    
    
    // use binary search
    public int findPivot(int left, int right){
        
        if(nums[left] < nums[right]){
            return 0;
        }
        
        while(left <= right){
            int middle = (left + right) / 2;
        
            if(nums[middle] > nums[middle + 1]){
                return middle + 1;
            }
        
            if(nums[left] <= nums[middle]){
                left = middle + 1;
            }
            else{
                right = middle - 1;
            }
        }
        return 0;
    }
    
   public int search(int left, int right){
        
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
            	 right = mid - 1;
            }
            else{
               
                left = mid + 1;
            }
        }
        return -1;
    }
    
    
    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int length = nums.length;
        
        if(length == 0){
            return -1;
        }
        
        if(length == 1){
            return nums[0]==target? 0: -1;
        }        
        
        int pivotIndex = findPivot(0, length - 1);
        
        if(nums[pivotIndex] == target) return pivotIndex;
        if (pivotIndex == 0)
		      return search(0, length - 1);
       
        if(nums[0] <= target){
            return search(0, pivotIndex);
        } else{
            return search(pivotIndex, length - 1);
        }
    }
	
		public static void main(String[] args) {
			Solution solution = new Solution();
			int[] num = { 8,9,2,3,4};
			
			int target = 9;
			
			int result = solution.search(num,target);
	
			System.out.println(result);
     }
}


// time complexity: O(logN)
// space complexity: O(1)



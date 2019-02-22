import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
	public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new  LinkedList<>();
        
        for(int i = 0; i < nums.length - 2; i++){
            
            if( i == 0 || (nums[i] != nums[i-1]) ){
               int sum = 0 - nums[i];
            int lo = i + 1;
            int hi = nums.length - 1;
            
            while(lo < hi){
                if(nums[lo] + nums[hi] == sum){
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));  
                    while(lo < hi && nums[lo] == nums[lo +1 ]){lo++;}
                    while(lo < hi && nums[hi] == nums[hi-1]){hi--;}
                    
                    lo++;
                    hi--;
                }
                else if(nums[lo] + nums[hi] < sum){
                    lo++;
                }
                else{
                    hi--;
                }             
            } 
            }
            
           
        }
        return res;
    }

	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		int[] input = {0, 1, 0, 0};
		
		List<List<Integer>>result = solution.threeSum(input);
		
		System.out.println(result);
     }
}


// time complexity: O(n^2)
// space complexity: depend on the sorting algorithm



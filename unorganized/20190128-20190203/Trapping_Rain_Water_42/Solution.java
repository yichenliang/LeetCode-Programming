public class Solution {
	   
	public int trap(int[] height) {
        if(height == null || height.length < 3){
            return 0;
        }
        
        int ans = 0;
        int leftmost = 0;
        int rightmost = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right){
        	leftmost = Math.max(leftmost, height[left]);
        	rightmost = Math.max(rightmost, height[right]);
        	if(leftmost <= rightmost){
                ans += leftmost - height[left];
                left++;
            }
            else{
                ans += rightmost - height[right];
                right--;    
            }
        }
        return ans;
    }
	
	
		public static void main(String[] args) {
			Solution solution = new Solution();
			
			int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
			int result = solution.trap(input);
	
			System.out.println(result);
     }
}


// time complexity: o(n)
// space complexity: o(1)

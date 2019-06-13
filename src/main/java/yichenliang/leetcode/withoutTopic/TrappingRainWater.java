package yichenliang.leetcode.withoutTopic;

/**
 *  42. Trapping Rain Water
 *  
 *  method1 : use two arrays
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 *  method2: two integer to record leftmost and right most
 *  time complexity: O(n)
 *  space complexity: O(1)
 * 
 */

public class TrappingRainWater {
	
	public int trap1(int[] height) {
        
        int len = height.length;
        int[] leftMost = new int[len];
        int[] rightMost = new int[len];
        
        leftMost[0] = 0;
        for(int i = 1; i < len; i++){
            leftMost[i] = Integer.max(height[i - 1], leftMost[i - 1]); 
        }
        
        rightMost[len - 1] = 0;
        for(int j = len - 2; j >= 0; j--){
            rightMost[j] = Integer.max(height[j + 1], rightMost[j + 1]);
        }
        
        int res = 0;
        
        for(int i = 0; i < len; i++){
            int h = Integer.min(leftMost[i], rightMost[i]);
            if(h > height[i]){
                res += h - height[i];
            }
        }
        return res;
    }
	
	public int trap2(int[] height) {
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

}

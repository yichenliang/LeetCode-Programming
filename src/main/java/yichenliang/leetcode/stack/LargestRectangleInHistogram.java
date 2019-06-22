package yichenliang.leetcode.stack;

import java.util.Stack;

/**
 *  84. Largest Rectangle in Histogram
 *  
 *  stack
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class LargestRectangleInHistogram {
	
	public int largestRectangleArea(int[] heights) {
        
        if(heights == null || heights.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            if(stack.empty() || heights[i] >= heights[stack.peek()]){
                stack.push(i);
            }
            else{
                int right = i;
                int index = stack.pop();
                while(!stack.empty() && heights[index] == heights[stack.peek()]){
                    index = stack.pop();
                }
                int leftmost = stack.empty() ? -1 : stack.peek();
                max = Math.max(max, heights[index] * (right - leftmost - 1));
                i--;
            }
        }
        
        int rightmost = stack.peek() + 1;
        while(!stack.empty()){
            int index = stack.pop();
            int left = stack.empty() ? -1 : stack.peek();
            max = Math.max(max, heights[index] * (rightmost - left -1));
        }
        
        return max;
        
    }

}

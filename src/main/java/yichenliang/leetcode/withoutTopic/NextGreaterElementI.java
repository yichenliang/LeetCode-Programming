package yichenliang.leetcode.withoutTopic;

import java.util.HashMap;
import java.util.Stack;

/**
 *  496. Next Greater Element I
 *   
 *   time complexity: O(n)
 *   space complexity: O(n)
 * 
 */

public class NextGreaterElementI {
	
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int len1 = nums1.length;
        int[] res = new int[len1];
        HashMap<Integer, Integer> store = new HashMap<>();
        
        // using stack
        Stack<Integer> stack = new Stack<>();
        int len2 = nums2.length;
        for(int i = len2 - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() < nums2[i]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                store.put(nums2[i], -1);
            }
            else{
                store.put(nums2[i], stack.peek());
            }
            
            stack.push(nums2[i]);
        }
        
        for(int i = 0; i < len1; i++){
            int current = store.get(nums1[i]);
            res[i] = current;
        }
        
        return res;
    }
}

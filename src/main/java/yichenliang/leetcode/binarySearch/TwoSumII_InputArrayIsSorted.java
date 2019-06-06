package yichenliang.leetcode.binarySearch;

import java.util.HashMap;
import java.util.Map;

/**
 *  167. Two Sum II - Input array is sorted
 *  
 *  
 * 
 */

public class TwoSumII_InputArrayIsSorted {
	
	// method 1 : using hashmap
	public int[] twoSum1(int[] numbers, int target) {
        
        int[] ans = new int[2];
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int len = numbers.length;
        for(int i = 0; i < len; i++){
            
            if(map.containsKey(numbers[i])){
                ans[0] = map.get(numbers[i]);
                ans[1] = i + 1;
                break;
            }
            
            int rest = target - numbers[i];
            if(rest < numbers[i]){
                continue;
            }
        
            map.put(rest, i + 1);
        }
        return ans;
    }
	
	
	// method 2 : two pointer
	public int[] twoSum2(int[] numbers, int target) {
        int[] ans = new int[2];
        
        int low = 0;
        int high = numbers.length - 1;
        
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                ans[0] = low + 1;
                ans[1] = high + 1;
                return ans;
            }
            else if(sum < target){
                low++;
            }
            else{
                high--;
            }
        }
        return ans;
    }
	
	// method 3 : with binary search
	public int[] twoSum3(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[2];
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] > target) {
                // move end forward to the last value that numbers[end] <= target - numbers[start]
                end = largestSmallerOrLastEqual(numbers, start, end, target - numbers[start]);
            } else {
                // move start backword to the first value that numbers[start] >= target - numbers[end]
                start = smallestLargerOrFirstEqual(numbers, start, end, target - numbers[end]);
            }
        }
        return new int[2];
    }
    
    private int largestSmallerOrLastEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    
    private int smallestLargerOrFirstEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}

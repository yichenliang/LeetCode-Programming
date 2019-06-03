package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.List;

/**
 *  228. Summary Ranges
 *  
 *  time complexity: O(n)
 *  space complexity: O(1)
 */

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        int len = nums.length;
        int start = nums[0];
        int end = nums[0];
        
        for(int i = 1; i < len; i++){
            if(end + 1 < nums[i]){
                String current = "";
                if(start != end){
                    current = start + "->" + end;
                }
                else{
                    current = end + "";
                }
                res.add(current);
                start = nums[i];
                end = nums[i];
            }
            else{
                end = nums[i];
            }
        }
        
        if(start != end){
            res.add(start + "->" + end);
        }
        else{
            res.add(end + "");
        }
        
        return res;   
    }

}

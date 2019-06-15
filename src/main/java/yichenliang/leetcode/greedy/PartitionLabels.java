package yichenliang.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 *  763. Partition Labels
 *  
 *  Greedy + two pointers
 *  
 *  time complexity: O()
 *  space complexity: O()
 * 
 */

public class PartitionLabels {
	
	public List<Integer> partitionLabels(String S) {
        
        int[] lastShown = new int[26];
        int len = S.length();
        
        for(int i = 0; i < len; i++){
            int pos = S.charAt(i) - 'a';
            lastShown[pos] = i;
        }
        
        List<Integer> res = new ArrayList<>();
        // partition
        int start = 0;
        int end = 0;
        for(int i = 0; i < len; i++){
            int pos = S.charAt(i) - 'a';
            end = Math.max(lastShown[pos], end);
            if(i == end){
                res.add(end - start + 1);
                start = end + 1;
            }   
        }
        return res;
    }

}

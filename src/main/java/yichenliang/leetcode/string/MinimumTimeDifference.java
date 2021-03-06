package yichenliang.leetcode.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *  539. Minimum Time Difference
 *  
 *  String + comparator
 * 
 *  time complexity: O(nlogn)
 *  space complexity: O(n)
 */

public class MinimumTimeDifference {
	
	public int findMinDifference(List<String> timePoints) {
        
        ArrayList<Integer> sortedTime = new ArrayList<>();
        for(String str : timePoints){
            String[] current = str.split("\\:");
            int hour = Integer.parseInt(current[0]);
            int min = Integer.parseInt(current[1]);
            int time = hour * 60 + min;
            sortedTime.add(time);
        }
        
        Comparator<Integer> alg = new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        };
        sortedTime.sort(alg);
        int len = sortedTime.size();
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < len; i++){
            int diff = sortedTime.get(i) - sortedTime.get(i - 1);
            ans = Math.min(ans, diff);
        }
        
        int other = 1440 - sortedTime.get(len - 1) + sortedTime.get(0);
        ans = Math.min(ans, other);
        return ans;
    }

}

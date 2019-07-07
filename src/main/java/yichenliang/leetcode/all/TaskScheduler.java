package yichenliang.leetcode.all;

import java.util.Arrays;

/**
 *  621. Task Scheduler
 *  
 *  Greedy 
 *  
 *  time complexity: O()
 *  space complexity: O()
 * 
 */

public class TaskScheduler {
	
	public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        
        int len = tasks.length;
        
        int[] store = new int[26];
        
        for(char ch: tasks){
            store[ch - 'A']++;
        }
        
        Arrays.sort(store);
        
        int fre = 1;
        int first = store[25];
        for(int i = 24; i >= 0; i--){
            if(first==store[i]){
                fre++;  //the number of elements have the same frequency as first
            }
            else{
                break;
            }
        }
        
        int ans = (first-1)*(n+1) + fre;
        return ans < len ? len : ans;
    }

}

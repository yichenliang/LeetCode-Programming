package yichenliang.leetcode.withoutTopic;

import java.util.List;
import java.util.Stack;

/**
 *  636. Exclusive Time of Functions
 *  
 *  Stack
 *  
 *  time complexity: O(n)
 *  space complexity: O(n/2)
 * 
 */

public class ExclusiveTimeOfFunctions {
	
public int[] exclusiveTime(int n, List<String> logs) {
        
        int[] res = new int[n];
        Stack<Integer> store = new Stack<>();
        String[] s = new String[3];
        int prev = 0;
        for(int i = 0; i < logs.size(); i++){
            s = logs.get(i).split(":");
            //System.out.println(s[1]);
            if(s[1].equals("start")){  // start
                if(!store.isEmpty()){
                   res[store.peek()] += Integer.parseInt(s[2]) - prev;
                }
                store.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            }
            else { // end
                res[store.peek()] += Integer.parseInt(s[2]) - prev + 1;
                store.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
        }
        return res;
    }

}

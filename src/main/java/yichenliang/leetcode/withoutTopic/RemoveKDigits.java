package yichenliang.leetcode.withoutTopic;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  402. Remove K Digits
 *  
 *  deque
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 *   
 */

public class RemoveKDigits {
	
	public String removeKdigits(String num, int k) {
        
        if(num == null || num.length() == 0) return "0";
        if(k == 0) return num;
        
        int len = num.length();
        Deque<Integer> dq = new LinkedList<>();
        dq.push(num.charAt(0) - '0');
        for(int i = 1; i < len; i++){
            int cur = num.charAt(i) - '0';
            while(!dq.isEmpty() && cur < dq.peekLast() && k > 0){
                dq.pollLast();
                k--;
            }
            dq.offerLast(cur);
        }
        
        while(k > 0){
            dq.pollLast();
            k--;
        }
        
        if(dq.isEmpty()) return "0";
        
       while(dq.size() > 1 && dq.peekFirst() == 0){
           dq.pollFirst();
       }
        
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }
}

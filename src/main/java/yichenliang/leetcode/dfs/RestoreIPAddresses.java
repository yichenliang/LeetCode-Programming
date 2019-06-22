package yichenliang.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *  93. Restore IP Addresses
 * 
 *  dfs
 *  
 *  time complexity: O(len)
 *  space complexity: O(len/3)
 *  
 */

public class RestoreIPAddresses {

	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;
        String[] temp = new String[4];
        dfsHelper(res, s, 0, 1, temp);
        return res;  
    }
    
    void dfsHelper(List<String> res, String s, int start, int level, String[] temp){
        
        if(level == 4){
            // eliminate leading zero
            String last = s.substring(start);
            if(last.length() > 1 && last.charAt(0) == '0'){
                return;
            }
            
            int num = Integer.parseInt(last);
            if(num <= 255){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < 3; i++){
                    sb.append(temp[i]);
                    sb.append('.');
                }
                sb.append(num);
                res.add(sb.toString());
            }
            return;
        }
        
        for(int i = start; i < start + 3; i++){
            
            if(s.length() - (i + 1) > 3 * (4 - level)){
                continue;
            }
            
            if(s.length() - (i + 1) < (4 - level)){
                continue;
            }
            
            String current = s.substring(start, i + 1);
            
            // eliminate leading zero
            if(current.length() > 1 && current.charAt(0) == '0'){
                continue;
            }
            
            if(Integer.parseInt(current) < 256){
                temp[level - 1] = current;
                dfsHelper(res, s, i + 1, level + 1, temp); 
            }     
        }   
    }
}

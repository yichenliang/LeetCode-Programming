package yichenliang.leetcode.withoutTopic;

import java.util.LinkedList;
import java.util.List;

/**
 *  6. ZigZag Conversion
 *  
 *  method 1:
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 *  method2:
 *  time complexity: O(n * m)
 *  space complexity: O(n)
 */

public class ZigZagConversion {
	public String convert(String s, int numRows) {
        if(s == null || s == "") return "";
        
        if(numRows == 1 || s.length() < numRows) return s;
        
       
        StringBuilder sb = new StringBuilder();
        
        int len = s.length();
        int distance = numRows * 2 - 2;
        
        // i = 0
        int js = 0;
        while(js*distance < len){
            sb.append(s.charAt(js*distance));
            js++;
        }
        
        for(int i = 1; i < numRows - 1; i++){
            int k = 0;
            sb.append(s.charAt(i + k * distance));
            k++;
            while(true){
                if(i + k*distance - 2*i < len){
                    sb.append(s.charAt(i + k*distance - 2*i));
                }
                else{
                    break;
                }
                
                if(i + k * distance < len){
                    sb.append(s.charAt(i + k*distance));
                }
                else{
                    break;
                }
                k++;
            }
        }
       
        int base = numRows - 1;
        int je = 0;
        while(base + je*distance < len){
            sb.append(s.charAt(base + je*distance));
            je++;
        }
        
        return sb.toString();
    }
	
	public String convert2(String s, int numRows) {
        
        int len = s.length();
        
        if(len <= numRows) return s;
        if(numRows == 1) return s;
        
        List<Integer> p = new LinkedList<>();
        int n = numRows * 2 - 2;
        for(int i = 0; i <= len + n; i++){
            if(i % n == 0) p.add(i);
        }
        
        int prev = -1;
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < p.size(); j++){
                int b = p.get(j);
                if(b - i >= 0 && b - i < len && b - i != prev){
                    ans.append(s.charAt(b - i));
                    prev = b - i;
                }
                
                if(b + i < len && b + i != prev){
                    ans.append(s.charAt(b + i));
                    prev = b + i;
                }
            }
        }
        return ans.toString();
    }

}

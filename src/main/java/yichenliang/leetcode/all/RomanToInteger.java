package yichenliang.leetcode.all;

import java.util.HashMap;
import java.util.Map;

/**
 *  13. Roman to Integer
 *   
 *  method2:
 *  time complexity: O(n)
 *  space complexity: O(1)
 */

public class RomanToInteger {
	
	public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            
            char current = s.charAt(i);
            char next = 'A';
            if(i < s.length() - 1){
                next = s.charAt(i + 1);
            }
            
            if(current == 'I' && (next == 'V' || next == 'X')){
                result += map.get(next) - map.get(current);
                i++;
            }
            else if(current == 'X' && (next == 'L' || next == 'C')){
               result += map.get(next) - map.get(current);
               i++; 
            }
            else if(current == 'C' && (next == 'D' || next == 'M')){
                result += map.get(next) - map.get(current);
                i++; 
            }
            else{
                result += map.get(current);
            }
        }
        return result;
    }
	
	 public int romanToInt2(String s) {
		 if(s == null || s.length() == 0){
	            return 0;
	        }
	        
	        int res = 0;
	        char ch = 'A';
	        int len = s.length();
	        char last = 'A';
	        for(int i = 0; i < len; i++){
	            ch = s.charAt(i);
	            switch(ch){
	                case 'I':
	                    res += 1;
	                    break;
	                case 'X':
	                    res += (last == 'I') ? 8 : 10;
	                    break;
	                case 'C':
	                    res += (last == 'X') ? 80 : 100;
	                    break;
	                case 'V':
	                   res += (last == 'I') ? 3 : 5; 
	                   break;
	                case 'L':
	                    res += (last == 'X') ? 30 : 50; 
	                   break;
	                case 'D':
	                     res += (last == 'C') ? 300 : 500; 
	                   break;
	                case 'M':
	                    res += (last == 'C') ? 800 : 1000; 
	                   break;
	                default:
	                    break;
	            }
	            last = ch;
	        }
	        return res;
	        
	 }

}

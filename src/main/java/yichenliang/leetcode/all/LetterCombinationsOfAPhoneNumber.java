package yichenliang.leetcode.all;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *  17. Letter Combinations of a Phone Number
 *  
 *  method : dfs
 *  
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 */

public class LetterCombinationsOfAPhoneNumber {
	
	HashMap<Character, String> map;
    
    public List<String> letterCombinations(String digits) {
        
        List<String> res = new LinkedList<>();
        if(digits == null || digits.length() == 0) return res;
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        res = dfs(digits);
        return res;
    }
    
    private List<String> dfs(String s){
        if(s.length() == 0) return null;
        
        char ch = s.charAt(0);
        String str = map.get(ch);
        List<String> cur = dfs(s.substring(1));
        List<String> res = new LinkedList<>();
        for(int i = 0; i < str.length(); i++){
            String c = str.substring(i, i + 1);
            if(cur != null){
                for(String r : cur){
                    String newString = c + r;
                    res.add(newString);
                }
            }
            else{
                res.add(c);
            }
        }
        return res;
    }

}

package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 301. Remove Invalid Parentheses
 * 
 * DFS
 * 
 * 
 */

public class RemoveInvalidParentheses {
	
	public List<String> removeInvalidParentheses(String s) {
        int l = 0; 
        int r = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){ 
            	l++;
            }
            else if(s.charAt(i) == ')' && l == 0){
                r++;
            }
            else if(s.charAt(i) == ')'){
                l--;
            }   
        }
        
        List<String> ans = new ArrayList<>();
        //StringBuilder sb = new StringBuilder(s);
        dfs(s, 0, l, r, ans);
        return ans;      
    }
    
    // l ,r : the number of left/right parentheses to remove
    private void dfs(String s, int start, int l, int r, List<String> ans){
        // end case
        if(l == 0 && r == 0){
            if(isValid(s)) ans.add(s);
            return;
        }
       
        // normal case recursion
        for(int i = start; i < s.length(); i++){
 // only remove the first parenthes if there are consecutive ones to avoid duplications
            if(i != 0 &&s.charAt(i) == s.charAt(i - 1)){
                continue;
            }
            
            if(s.charAt(i) == ')' && r > 0){
               StringBuilder tempsb = new StringBuilder(s);
               String temps = tempsb.deleteCharAt(i).toString();
               dfs(temps, i, l, r - 1, ans); 
            }
            else if(s.charAt(i) == '(' && l>0){
            	StringBuilder tempsb = new StringBuilder(s);
                String temps = tempsb.deleteCharAt(i).toString();
                dfs(temps, i, l-1, r, ans);
               
            }
        }
    }
    
    private boolean isValid(String s){
        int count = 0; 
        for(int i = 0; i < s.length(); i++ ){
            if(s.charAt(i) == '('){
                count++;
            }
            if(s.charAt(i) == ')'){
                count--;
            }
            if(count < 0) return false;
        }
        return count == 0;
    }

}

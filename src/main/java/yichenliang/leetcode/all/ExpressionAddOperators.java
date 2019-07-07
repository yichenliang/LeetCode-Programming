package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 282. Expression Add Operators
 * 
 * dfs
 */

public class ExpressionAddOperators {
	 public List<String> addOperators(String num, int target) {
	        
	        List<String> res = new ArrayList<>();
	        if(num == null|| num.length() == 0) return res;
	        
	        dfsHelper(num, target, "", 0, 0, 0, res);
	        return res;    
	    }
	 
	    // curValue, preValue : long  see test2,  the result could case overflow in int    
	    void dfsHelper(String num, int target, String curExp, int pos, long preValue, long curValue, List<String>res){
	        
	        // end case
	        if(pos == num.length()){
	            if(curValue == target){
	                res.add(curExp);
	            }
	            return;
	        }
	       
	        //normal case
	        for(int i = pos; i < num.length(); i++){
	            if(i != pos && num.charAt(pos) == '0'){  // 0X  Ex: 01
	                break;
	            }
	        
	            long currentNum = Long.parseLong(num.substring(pos, i+1)); 
	            if(pos == 0){
	                dfsHelper(num, target, curExp+currentNum, i + 1, currentNum, currentNum, res);
	            }
	            else{
	               dfsHelper(num, target, curExp + '+' + currentNum, i + 1, currentNum, curValue + currentNum, res); 
	               dfsHelper(num, target, curExp + '-' + currentNum, i + 1, -currentNum, curValue - currentNum, res);
	               dfsHelper(num, target, curExp + '*' + currentNum, i + 1, preValue * currentNum, curValue - preValue + preValue * currentNum, res);
	            }          
	        }
	    }
}

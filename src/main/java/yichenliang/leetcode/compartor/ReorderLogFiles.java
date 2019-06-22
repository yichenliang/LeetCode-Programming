package yichenliang.leetcode.compartor;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 937. Reorder Log Files
 * 
 * self define comparator
 * 
 * time complexity: O(logN)
 * space complexity: O(1)
 * 
 */

public class ReorderLogFiles {
	
public String[] reorderLogFiles(String[] logs) {
        
        // write comparator for this case
        Comparator<String> myCompara = new Comparator<String>(){
            @Override
            public int compare(String str1, String str2){
                
                String[] str1Arr = str1.split(" ");
                String[] str2Arr = str2.split(" ");
                
                boolean isChar1Digit = Character.isDigit(str1Arr[1].charAt(0));
                boolean isChar2Digit = Character.isDigit(str2Arr[1].charAt(0));
                
                // both are digits
                if(isChar1Digit && isChar2Digit){
                    return 0;
                }
                
                // both are letter
                if(!isChar1Digit && !isChar2Digit){
                    String sub1 = str1.substring(str1Arr[0].length() + 1);  // remember the empty space after identifier
                    String sub2 = str2.substring(str2Arr[0].length() + 1);
                    
                    int result = sub1.compareTo(sub2);
                    
                    if(result == 0){
                        return str1Arr[0].compareTo(str2Arr[0]);  // comparing identifier
                    }
                    else{
                        return result;
                    }
                }
                
                // one is digits, one is letter
                if(isChar1Digit){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };
        
        // this the comparator implemented above to sort the array
        Arrays.sort(logs, myCompara);
        return logs;
    }

}

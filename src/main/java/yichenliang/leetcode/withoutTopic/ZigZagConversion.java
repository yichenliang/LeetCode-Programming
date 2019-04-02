package yichenliang.leetcode.withoutTopic;

/**
 *  6. ZigZag Conversion
 *  
 *  time complexity: O(n)
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

}

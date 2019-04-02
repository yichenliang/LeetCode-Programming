package yichenliang.leetcode.withoutTopic;

/**
 * 12. Integer to Roman
 * 
 * time complexity: O(n)
 * space complexity: O(n) 
 */

public class IntegerToRoman {
public String intToRoman(int num) {
        
        StringBuilder sb =  new StringBuilder();
        
        while(num > 0){
            if(num >= 1 && num < 4){
                num = num - 1;
                sb.append('I');
            }
            else if(num >=4 && num < 5){
                num = num - 4;
                sb.append('I');
                sb.append('V');
            }
            else if(num >= 5 && num < 9){
                num = num - 5;
                sb.append('V');
            }
            else if(num >= 9 && num < 10){
                num = num - 9;
                sb.append('I');
                sb.append('X');
            }
            else if(num >= 10 && num < 40){
                num = num - 10;
                sb.append('X');
            }
            else if(num >= 40 && num < 50){
                num = num - 40;
                sb.append('X');
                sb.append('L');
            }
            else if(num >= 50 && num < 90){
                num = num - 50;
                sb.append('L');
            }
            else if(num >= 90 && num < 100){
                num = num - 90;
                sb.append('X');
                sb.append('C');
            }
            else if(num >= 100 && num < 400){
                num = num - 100;
                sb.append('C');
            }
            else if(num >= 400 && num < 500){
                num = num - 400;
                sb.append('C');
                sb.append('D');
            }
            else if(num >= 500 && num < 900){
                num = num - 500;
                sb.append('D');
            }
            else if(num >= 900 && num < 1000){
                num = num - 900;
                sb.append('C');
                sb.append('M');
            }
            else if(num >= 1000){
                num = num - 1000;
                sb.append('M');
            }
            
        }
        String res = sb.toString();
        return res;
    }

}

package yichenliang.leetcode.withoutTopic;

public class RemoveKDigits {
	
	public String removeKdigits(String num, int k) {
        
        // edge case
        
        // normal case
	StringBuilder sb = new StringBuilder();
    int len = num.length();
    int currentK = k;
    for(int i = 0; i < len - 1; i++){
        if(num.charAt(i) > num.charAt(i + 1)){
            if(currentK > 0){
                currentK--;
            }
            else{
                sb.append(num.charAt(i));
            }
        }
        else{
            sb.append(num.charAt(i));
        }
    }
    
    sb.append(num.charAt(len - 1));
    
    while(currentK > 0){
    	int l = sb.length();
        sb.deleteCharAt(l - 1);
        currentK--;
    }

    if(sb.length() == 0){
        return "0";
    }
    
    while(sb.length() > 0 && sb.charAt(0) == '0'){
        sb.deleteCharAt(0);
    }
    
     if(sb.length() == 0){
        return "0";
    }
    return sb.toString();
    }

}

package yichenliang.leetcode.string;

/**
 * 28. Implement strStr()
 * 
 * time complexity: O(n)
 * space complexity: O(1)
 * 
 */

public class ImplementStrStr {
	public int strStr(String haystack, String needle) {
        
        if(needle == null || needle.length() == 0){
            return 0;
        }
        
        int start = 0;
        int lenh = haystack.length();
        int lenn = needle.length();
        for(int i = 0; i < lenh; i++){
            if(haystack.charAt(i) == needle.charAt(0)){ // find a candidate
                start = i;
                i++;
                int j = 1;
                while(j < lenn && i < lenh){
                    if(haystack.charAt(i) == needle.charAt(j)){
                        i++;
                        j++;
                    }
                    else{
                        i = start;
                        break;
                    }
                }
                if(j == lenn){
                    return start;
                }
            }
            
        }
        return -1;
    }

}

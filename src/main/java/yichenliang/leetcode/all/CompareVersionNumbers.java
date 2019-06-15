package yichenliang.leetcode.all;

/**
 * 165. Compare Version Numbers
 * 
 *  String
 * 
 *  time complexity: O(n)
 *  space complexity: O(n)
 *  
 */

public class CompareVersionNumbers {
	
	public int compareVersion(String version1, String version2) {
        
        if(version1 == null ||version2 == null){
            return 0;
        }
        
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
//        String[] v1 = version1.split(".");
//        String[] v2 = version2.split(".");
        
//        String str = "1,2,e,s,&&,*,";
//        String[] ve = str.split(",");
        int len = Math.min(v1.length, v2.length);
        
        for(int i = 0; i < len; i++){
            int num1 = Integer.parseInt(v1[i]);
            int num2 = Integer.parseInt(v2[i]);
            if(num1 > num2){
                return 1;
            }
            else if(num1 < num2){
                return -1;
            }
        }
        
        if(v1.length > v2.length){
            int len1 = v1.length;
            for(int i = len; i < len1; i++){
                int n = Integer.parseInt(v1[i]);
                if(n > 0){
                    return 1;
                }
            }
        }
        else if(v1.length < v2.length){
            int len2 = v2.length;
            for(int i = len; i < len2; i++){
                int n = Integer.parseInt(v2[i]);
                if(n > 0){
                    return -1;
                }
            }
        }
        return 0;
    }

}

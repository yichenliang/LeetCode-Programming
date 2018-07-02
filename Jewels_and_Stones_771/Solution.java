// 771. Jewels and Stones

import java.util.HashSet;


class Solution {
    public int numJewelsInStones(String J, String S) {
    	
    HashSet<Character> jewelBox = new HashSet<Character>();  
    
    char[] JArr = J.toCharArray();
    for (char j : JArr) {
    	jewelBox.add(j);
    }
    
    int res = 0;
    
    char[] SArr = S.toCharArray();
    for (char s : SArr) {
    	if (jewelBox.contains(s)) {
    		res++;
    	}
    }
    
    return res;
        
    }
    
    public static void main(String[] agrs) {
    	
    	Solution solution = new Solution();
    	
//    	String J = "aA";
//    	String S = "aAAbbbb";
    	
    	String J = "z";
    	String S = "ZZ";
    	
    	
    	int res = solution.numJewelsInStones(J, S);
    	System.out.print(res);

    }
    
}
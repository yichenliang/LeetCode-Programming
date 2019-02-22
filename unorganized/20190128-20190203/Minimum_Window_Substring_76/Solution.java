import java.util.HashMap;
import java.util.Map;

public class Solution {
public String minWindow(String s, String t) {
        
        if(s == null || t == null) return "";
        if(s.length() < t.length()) return "";
        
        Map<Character, Integer> store = store(t);
        int slow = 0, minLength = Integer.MAX_VALUE, index = 0, matchCount = 0;
        
        for(int fast = 0; fast < s.length(); fast++ ){
            char ch = s.charAt(fast);
            Integer count = store.get(ch);
            
            if(count == null){
                continue;
            }
            
            store.put(ch, count - 1);
            if(count == 1){
                matchCount++;
            }
            
            while(matchCount == store.size()){
                // find a valid substring, try to move slow pointer to short it
                if(fast - slow + 1< minLength){
                    minLength = fast - slow + 1;
                    // point to the first character of valid substring
                    index = slow;
                }
                char leftmost = s.charAt(slow);  //
                Integer leftmostCount = store.get(leftmost);
                if(leftmostCount == null){
                    slow++;
                    continue;
                }
                
                store.put(leftmost, leftmostCount + 1);
                slow++;
                if(leftmostCount == 0){
                    // substring becomes invalid
                    matchCount--;
                    //slow++;
                }
            }
            
        }
        return minLength == Integer.MAX_VALUE? "": s.substring(index, index + minLength);
    }
    
    
    Map<Character, Integer> store(String t){
        Map<Character, Integer> store = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            Integer number = store.get(ch);
            if(number == null){
                store.put(ch, 1);
            }
            else{
                store.put(ch, number + 1);
            }
        }
        return store;
    }
	
    

		public static void main(String[] args) {
			Solution solution = new Solution();
			
			String s = "ADOBECODEBANC";
			String t = "ABC";
			String result = solution.minWindow(s, t);
	
			System.out.println(result);
     }
}


// time complexity: o(n)
// space complexity: o(m)

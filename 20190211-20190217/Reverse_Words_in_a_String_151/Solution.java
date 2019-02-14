public class Solution {
    public String reverseWords(String s) {
        String res = "";
        if(s == null || s.length() == 0) return res;
        List<String> store = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                continue;
            }
            else{
                StringBuilder sb = new StringBuilder();
                while(i < s.length() && s.charAt(i) != ' '){
                  sb.append(s.charAt(i));
                  i++;
                }
                store.add(sb.toString());  
            }
        }
        
        int len = store.size();
        if(len == 0) return res;
        
        for(int i = len -1; i > 0; i--){
            res += store.get(i);
            res += " ";
        }
        
        res += store.get(0);
        return res;
        
    }
}

// time complexity: O(N)
// space complexity: O(N)
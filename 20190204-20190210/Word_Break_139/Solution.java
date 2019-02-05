// DP

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(wordDict == null|| s == null) return false;
         
        Set<String> store = new HashSet<>();
        for(String str: wordDict){
            store.add(str);
        }
        
        boolean[] result = new boolean[s.length() + 1];
        result[0]=true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = i; j>0; j--){
                String sub = s.substring(i-j,i);
                if(store.contains(sub)){
                    if(result[i-j]){
                         result[i] = true;
                         break;
                    }   
                }
            }
        }
        
        return result[s.length()];
    }
}


// time complexity: O(N^2)
// space complexity: O(M+N)


// resource: https://www.youtube.com/watch?v=pYKGRZwbuzs
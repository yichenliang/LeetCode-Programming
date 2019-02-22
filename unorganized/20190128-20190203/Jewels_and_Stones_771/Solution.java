class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.length() < 1 || S == null || S.length() < 1){
            return 0;
        }
        
        Set<Character> jewels = new HashSet<>();
        int lengthJ = J.length();
        for(int i = 0; i<lengthJ; i++ ){
            jewels.add(J.charAt(i)); 
        }
        
        int result = 0;
        for(int j = 0; j < S.length(); j++){
            if(jewels.contains(S.charAt(j))){
                result++;
            }
        }
        return result;
    }
}


// time complexity: O(J.length+S.length)
// space complexity: O(J.length)
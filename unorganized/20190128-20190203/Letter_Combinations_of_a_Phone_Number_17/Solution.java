class Solution {
    
    Map<Integer, String> numberMap(){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        return map;
    }
     
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
       
        if(digits==null || digits.length()<1){
            return result;
        }
        
        Map<Integer, String> map = numberMap();
        
        StringBuilder sb = new StringBuilder();
        dfsHelper(digits, map, result, 0, sb);
        return result;        
    }
    
    public void dfsHelper(String digits, Map<Integer, String> map,  List<String> result, int level, StringBuilder sb ){
        // end case
        if(digits.length() == level){
            result.add(sb.toString());
            return;
        }
        
        // normal case
        int key = digits.charAt(level) - '0';
        String value = map.get(key);
        for(char c : value.toCharArray()){
            sb.append(c);
            dfsHelper(digits, map, result, level + 1, sb);
            sb.deleteCharAt(level);     
        }
        
    }
}

//time complexity: O(4^n)
//space complexity: O(n)
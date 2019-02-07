class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            
            char current = s.charAt(i);
            char next = 'A';
            if(i < s.length() - 1){
                next = s.charAt(i + 1);
            }
            
            if(current == 'I' && (next == 'V' || next == 'X')){
                result += map.get(next) - map.get(current);
                i++;
            }
            else if(current == 'X' && (next == 'L' || next == 'C')){
               result += map.get(next) - map.get(current);
               i++; 
            }
            else if(current == 'C' && (next == 'D' || next == 'M')){
                result += map.get(next) - map.get(current);
                i++; 
            }
            else{
                result += map.get(current);
            }
        }
        return result;
    }
}

// time complexity: O(N)
// space complexity: O(1)
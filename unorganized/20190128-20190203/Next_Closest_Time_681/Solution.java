class Solution {
    public String nextClosestTime(String time) {
        // change the time in min
        int cur = 60 * Integer.parseInt(time.substring(0,2));
        cur += Integer.parseInt(time.substring(3));
        Set<Integer> record = new HashSet<>();
        
        // put valid number into record
        for(char c : time.toCharArray()){
            if(c != ':'){
               record.add(c - '0'); 
            }    
        }
        
        // simulate the passing of time one min by one min
        while(true){
            cur = (cur + 1) % (24*60);
            int[] digits = {cur/60/10, cur/60%10, cur%60/10, cur%60%10};
            check: {
                for(int d : digits){
                    if(!record.contains(d)){
                        break check;
                    }
                }
                return String.format("%02d:%02d", cur/60, cur%60);
            }
        }
        
    }
}

// time complexity: o(1)
// space complexity: o(1)
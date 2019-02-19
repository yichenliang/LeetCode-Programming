class Solution {
    
    Random randGenerate;
    int[] wSum;
    
    public Solution(int[] w) {
        this.randGenerate = new Random();
        for(int i = 1; i < w.length; i++){
            w[i] = w[i] + w[i-1];
        }
        this.wSum = w;
    }
    
    public int pickIndex() {
        int len = wSum.length;
        int randIdx = randGenerate.nextInt(wSum[len-1]) + 1;
        int left = 0, right = len - 1;
        
        // search position
        while(left < right){
            int mid = left + (right - left)/2;
            
            if(wSum[mid] == randIdx){
                return mid;
            }
            else if(wSum[mid] < randIdx){
                left = mid + 1;
            }
            else if(wSum[mid] > randIdx){
                right = mid;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
 
 // time complexity:  O(n) to init, O(logn) for one pick
 // space complexity: O(n)
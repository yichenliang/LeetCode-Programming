// greedy

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0) return 0;
        
        int len = tasks.length;
        
        int[] store = new int[26];
        
        for(char ch: tasks){
            store[ch - 'A']++;
        }
        
        Arrays.sort(store);
        
        int fre = 1;
        int first = store[25];
        for(int i = 24; i >= 0; i--){
            if(first==store[i]){
                fre++;
            }
            else{
                break;
            }
        }
        
        int ans = (first-1)*(n+1) + fre;
        return ans < len ? len : ans;
    }
}

// time complexity: O(N)
// space complexity: O(1)

// resource: https://www.youtube.com/watch?v=YCD_iYxyXoo&t=611s
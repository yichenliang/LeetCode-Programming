class Solution {
    public int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null) return 0;
        
        int m = word1.length();
        int n = word2.length();
        
        // dp state
        int[][] dis = new int[m + 1][n + 1];
        
        //initial dp state
        for(int i = 0; i < m + 1; i++){
            dis[i][0] = i;
        }
        for(int j = 0; j < n + 1; j++){
            dis[0][j] = j;
        }
        
        // transfer function
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                dis[i][j] = Integer.MAX_VALUE;
                // the last letter equal
                if(word1.charAt(i - 1) == word2.charAt(j -1)){
                    dis[i][j] = Math.min(dis[i][j-1], dis[i-1][j]) + 1;
                    dis[i][j] = Math.min(dis[i][j], dis[i - 1][j - 1]);
                }
                else{  // the last letter different
                    dis[i][j] = Math.min(dis[i][j-1], dis[i-1][j]) + 1;
                    dis[i][j] = Math.min(dis[i][j], dis[i - 1][j - 1] + 1);
                }
            }
        }
        
        // the end case, the return case, what we want
        return dis[m][n];
    }
}

// time complexity: O(MN)
// space complexity: O(MN)
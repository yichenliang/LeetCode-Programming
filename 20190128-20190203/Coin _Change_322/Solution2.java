class Solution {
    public int coinChange(int[] coins, int amount) {
        //int[][] f =new int[coins.length + 1][amount+1];
        int[] g = new int[amount+1];
        //Arrays.fill(f[coins.length], Integer.MAX_VALUE);
        Arrays.fill(g, Integer.MAX_VALUE);
        //f[coins.length][0] = 0;
        g[0] = 0;
        
        for(int i = coins.length - 1; i >= 0; i--){
            for(int j = 0; j <= amount; j++ ){
                //f[i][j] = f[i+1][j];
                if(j>=coins[i]){
                    int prev = g[j-coins[i]];
                    if(prev < Integer.MAX_VALUE){
                        g[j] = Math.min(g[j], prev + 1);
                    }
                }
            }
        }
        
        return g[amount] == Integer.MAX_VALUE? -1 : g[amount];
    }
}

// time complexity: O(mn)
// space complexity: O(n)
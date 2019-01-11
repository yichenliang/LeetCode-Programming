//807. Max Increase to Keep City Skyline
//Approach #1: Row and Column Maximums

public class Solution {
 
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int ii = grid.length;
        int jj = grid[0].length;
        
        int[] aiMax = new int[ii];
        int[] ajMax = new int[jj];
        
        for (int i = 0; i < ii; i++) {
        	for(int j = 0; j < jj; j++) {
        		aiMax[i] = Math.max(aiMax[i], grid[i][j]);
        		ajMax[j] = Math.max(ajMax[j], grid[i][j]);  //!!!
        	}
        }
        
        int res = 0;
        
        for(int i = 0; i < ii; i++) {
        	for(int j = 0; j < jj; j++) {
        		res += Math.min(aiMax[i], ajMax[j]) - grid[i][j];
        	}
        }
        
        return res;
    }
    
    public static void main(String[] agrs) {
    	Solution solution = new Solution();
    	int[][] input = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
    	int rep = solution.maxIncreaseKeepingSkyline(input);
    	System.out.println(rep);
    }
    
}



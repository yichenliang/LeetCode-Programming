package yichenliang.leetcode.all;

/**
 * 59. Spiral Matrix II
 * 
 * 
 * time complexity: O(n)
 * space complexity: O(n)
 * 
 * 2019/8/8
 */
public class SpiralMatrixII {

	public int[][] generateMatrix(int n) {
        
        int[][] res = new int[n][n];
        
        int rf = 0, cf = 0;
        int rl = n - 1, cl = n - 1;
        
        int cur = 1;
        
        while(rf <= rl && cf <= cl){
            for(int i = cf; i <= cl; i++){
                res[rf][i] = cur;
                cur++;
            }
            rf++;
        
            for(int i = rf; i <= rl; i++){
                res[i][cl] = cur;
                cur++;
            }
            cl--;
        
            if(cl >= cf){
                for(int i = cl; i >= cf; i--){
                    res[rl][i] = cur;
                    cur++;
                }
                rl--;
            }
            
        
            if(rl >= rf){
               for(int i = rl; i >= rf; i--){
                    res[i][cf] = cur;
                    cur++;
                }
                cf++;
            }
        }
        return res;
    }
}

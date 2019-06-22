package yichenliang.leetcode.withoutTopic;

/**
 *  223. Rectangle Area
 * 
 *  Math
 * 
 *  time complexity: O(1)
 *  space complexity: O(1)
 */


public class RectangleArea {
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x_l = Math.max(A,E);
        int x_r = Math.min(C, G);
        
        int res = (C-A) * (D-B) + (G - E) * (H - F);
        
        // check overlap
        if(x_l < x_r){  // find overlap int x-axis
            int y_t = Math.min(D, H);
            int y_b = Math.max(B, F);
            if(y_t > y_b){ // find overlap in y-axis
                return res - (x_r - x_l) * (y_t - y_b);
            }
        }
        return res;
    }

}

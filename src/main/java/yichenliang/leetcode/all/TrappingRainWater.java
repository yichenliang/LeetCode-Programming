package yichenliang.leetcode.all;

public class TrappingRainWater {
	
	public int trap(int[] height) {
        
        int len = height.length;
        int[] leftMost = new int[len];
        int[] rightMost = new int[len];
        
        leftMost[0] = 0;
        for(int i = 1; i < len; i++){
            leftMost[i] = Integer.max(height[i - 1], leftMost[i - 1]); 
        }
        
        rightMost[len - 1] = 0;
        for(int j = len - 2; j >= 0; j--){
            rightMost[j] = Integer.max(height[j + 1], rightMost[j + 1]);
        }
        
        int res = 0;
        
        for(int i = 0; i < len; i++){
            int h = Integer.min(leftMost[i], rightMost[i]);
            if(h > height[i]){
                res += h - height[i];
            }
        }
        return res;
    }

}

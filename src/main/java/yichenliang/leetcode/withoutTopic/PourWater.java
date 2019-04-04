package yichenliang.leetcode.withoutTopic;

/**
 * 755. Pour Water
 * 
 * time complexity: O(nV)
 * space complexity: O(1)
 */

public class PourWater {
	
	public int[] pourWater(int[] heights, int V, int K) {
        
        int len = heights.length;
        
        for(int i = V; i > 0; i--){
            
            // find left
            int leftIndex = K - 1;
            int leftCandidate = K;
            while(leftIndex >= 0 && heights[leftIndex] <= heights[leftIndex + 1]){
            
                if(heights[leftIndex] < heights[leftCandidate]){
                    leftCandidate = leftIndex;
                }
                leftIndex--;
            }
            
            int rightIndex = K + 1;
            int rightCandidate = K;
            if(leftCandidate == K) {  // only in this case do we need to find right candidate
            	// find right
                
                while(rightIndex < len && heights[rightIndex] <= heights[rightIndex - 1]){
                    if(heights[rightIndex] < heights[rightCandidate]){
                        rightCandidate = rightIndex;
                    }
                    rightIndex++;
                }
            }
        
         
            if(heights[leftCandidate] <= heights[rightCandidate]){
                heights[leftCandidate]++;
            }
            else{
                heights[rightCandidate]++;
            }
            
        }
        
        return heights;
    }
}

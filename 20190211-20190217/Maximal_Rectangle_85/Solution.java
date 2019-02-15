class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){return 0;}
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int maxArea = 0;
        int[] heights = new int[col];
        
        for(int i = 0; i < row; i++){
           for(int j = 0; j < col; j++){
               if(matrix[i][j] == '0'){
                   heights[j] = 0;
               }
               else{
                   heights[j]++;
               }
           }
           
           int area = largestRectangleArea(heights);
           maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
    
    public int largestRectangleArea(int[] heights) {
        
        if(heights == null || heights.length == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++){
            if(stack.empty() || heights[i] >= heights[stack.peek()]){
                stack.push(i);
            }
            else{
                int right = i;
                int index = stack.pop();
                while(!stack.empty() && heights[index] == heights[stack.peek()]){
                    index = stack.pop();
                }
                int leftmost = stack.empty() ? -1 : stack.peek();
                max = Math.max(max, heights[index] * (right - leftmost - 1));
                i--;
            }
        }
        
        int rightmost = stack.peek() + 1;
        while(!stack.empty()){
            int index = stack.pop();
            int left = stack.empty() ? -1 : stack.peek();
            max = Math.max(max, heights[index] * (rightmost - left -1));
        }
        
        return max;
        
    }
}

// time complexity: O(mn)
// space complexity: O(n)
class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int ptr1 = 0;
        int ptr2 = length - 1;
        int max = 0;
        while(ptr1 < ptr2 ){
            int len = ptr2 - ptr1;
            int hei = Math.min(height[ptr1], height[ptr2]);
            max = Math.max(max, len * hei);
            if(height[ptr1] < height[ptr2]){
                ptr1++;
            }
            else{
                ptr2--;
            }
        }
       return max; 
    }
}
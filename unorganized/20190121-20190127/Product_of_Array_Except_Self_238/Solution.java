class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        
        res[0] = 1;
        for(int i = 1; i < length; i++){
            res[i] = nums[i-1] * res[i-1];
        }
        
        int right = 1;
        for(int i = length - 1; i >= 0; i--){
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }
}
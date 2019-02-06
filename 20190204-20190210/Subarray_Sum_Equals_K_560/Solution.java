class Solution {
    public int subarraySum(int[] nums, int k) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        int prefixSum = 0;
        int count = 0;
        
        for(int i : nums){
            prefixSum += i;
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}

// TC : O(N)
// SC: O(N)

// resource : https://www.youtube.com/watch?v=aYfwus5T3Bs
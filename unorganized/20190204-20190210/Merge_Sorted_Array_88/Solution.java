class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(nums2 == null || nums2.length == 0){
            return;
        }
        
        if(nums1 == null) return;
        
        int len1 = nums1.length;
       
        
        int index1 = Math.max(m - 1, 0);
        int index2 = Math.max(n - 1, 0);
        int index = len1 - 1;
        while(index1 >= 0 && index2 >=  0){
            if(nums1[index1] > nums2[index2]){
                nums1[index] = nums1[index1];
                index1--;
            }
            else{
                nums1[index] = nums2[index2];
                index2--;
            }
            index--;
        }
        
        if(index1 < 0){
           for(int i = 0; i <= index2; i++ ){
               nums1[i] = nums2[i];
           } 
        }
    }
}

// time complexity: O(m+n)
// space complexity: O(1)
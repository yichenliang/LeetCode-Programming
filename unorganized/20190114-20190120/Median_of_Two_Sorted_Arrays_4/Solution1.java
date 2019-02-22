
public class Solution {
	
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 int m = nums1.length;
	        int n = nums2.length;
	        
	        if(m > n){
	            int[] temp = nums1;
	            nums1 = nums2;
	            nums2 = temp;
	            
	            int itemp = m;
	            m = n;
	            n = itemp;
	        }
	        
	        int iMin = 0, iMax = m;
	        int halfLength = (m + n + 1)/2;
	        while(iMin <= iMax){
	          int i = (iMin + iMax)/2;
	          
	          int j = halfLength - i;
	          
	          if(i>iMin && nums1[i-1]>nums2[j]){
	              // i is too big
	              iMax = i-1;
	          }
	          else if(i<iMax && nums1[i] < nums2[j-1]){
	              // i is too small
	              iMin = i+1;
	          }
	          else{
	              int leftMax = 0;
	              
	              if(i == 0){
	                  leftMax = nums2[j-1];
	              }
	              else if(j == 0){
	                    leftMax = nums1[i-1];   
	              }
	            else{
	               leftMax = Math.max(nums1[i-1], nums2[j-1]); 
	            }
	              
	              if((m+n)%2 == 1){
	                  return leftMax;
	              }
	              
	              int rightMin = 0;
	              if(i == m){
	                  rightMin = nums2[j];
	              }
	              else if(j == n){
	                    rightMin = nums1[i];   
	              }
	            else{
	               rightMin = Math.min(nums1[i], nums2[j]); 
	            }
	              double median = (leftMax + rightMin)/2.0;
	             return median;
	              
	          }
	        
	        }
	        return 0.0;
	        
	    }

	
	public static void main(String[] args) {
		
		Solution solution = new Solution();
		
		int[] num1 = {1, 3, 5};
		int[] num2 = {2, 4, 6};
		
		double result = solution.findMedianSortedArrays(num1,num2);
		
		System.out.println(result);
     }
}



// time complexity: O(log(min(m,n))). At first, the searching range is [0,m].
//                  And the length of this searching range will be reduced by half after each loop. 
//                  So, we only need log(m) loops. 
//                  Since we do constant operations in each loop, so the time complexity is O(log(m)) 
// Space complexity: O(1). only need constant memory several local variables (m,n,iMin,iMax,...)




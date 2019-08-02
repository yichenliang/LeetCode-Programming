package yichenliang.leetcode.all;

/**
 * 977. Squares of a Sorted Array
 * 
 * Binary Search
 * 
 * time complexity: O(n + logn)
 * space complexity: O(n)
 * 
 * 2019/8/2
 */

public class SquaresOfASortedArray {
	
	public int[] sortedSquares(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        
        int a = 0, b = len - 1;
        while(a < b && A[a] < 0){
            int mid = a + (b - a) / 2;
            if(A[mid] >= 0){
                b = mid;
            }
            else{
                a = mid + 1;
            }
        }
        
        if(a == 0){
            for(int i = 0; i < len; i++){
                ans[i] = A[i] * A[i];
            }
        }
        else{
            b = a - 1;
            for(int i = 0; i < len; i++){
                if(b < 0){
                    ans[i] = A[a] * A[a];
                    a++;
                }
                else if(a >= len){
                    ans[i] = A[b] * A[b];
                    b--;
                }
                else if(A[b] * A[b] < A[a] * A[a]){
                    ans[i] = A[b] * A[b];
                    b--;
                }
                else{
                    ans[i] = A[a] * A[a];
                    a++;
                }
            }
        }
        return ans;
    }

}

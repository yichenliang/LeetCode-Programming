package yichenliang.leetcode.tree.binaryTree;

/**
 * 255. Verify Preorder Sequence in Binary Search Tree
 * 
 * recursion
 * 
 * time complexity: O(n)
 * space complexity: O(height)
 * 
 */

public class VerifyPreorderSequenceInBinarySearchTree {
	
//	public boolean verifyPreorder(int[] preorder) {
//        
//        if(preorder == null){
//            return false;
//        }
//        
//        if(preorder.length == 1 || preorder.length == 0){
//            return true;
//        }
//        
//        return validBST(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE); 
//    }
//    
//    boolean validBST(int[] preorder, int start, int end, int low, int high){
//        
//        
//        // return case
//        if(start >= end){
//            return true;
//        }
//        
//        // normal case
//        int root = preorder[start];
//        
//        int index = end + 1;
//        for(int i = start; i <= end; i++){
//            if(preorder[i] > root){
//                index = i;
//                break;
//            }
//        }
//        
//        // check left part
//        for(int i = start + 1; i < index; i++){
//            int current = preorder[i];
//            if(current <= low || current >= root){
//                return false;
//            }
//        }
//        
//        // check right part
//        for(int i = index; i <= end; i++){
//            int current = preorder[i];
//            if(current >= high || current <= root){
//                return false;
//            }
//        }
//        
//        return validBST(preorder, start + 1, index - 1, low, root) && validBST(preorder, index, end, root, high);   
//    }
	
	public boolean verifyPreorder(int[] preorder) {
	    return verify(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean verify(int[] preorder, int start, int end, int min, int max) {
	    if (start > end) {
	        return true;
	    }
	    int root = preorder[start];
	    if (root > max || root < min) {
	        return false;
	    }
	    
	    int rightIndex = start;
	    while (rightIndex <= end && preorder[rightIndex] <= root) {
	        rightIndex++;
	    }
	    return verify(preorder, start + 1, rightIndex - 1, min, root) && verify(preorder, rightIndex, end, root, max);
	}
    
    public static void main(String[] arg) {
    	VerifyPreorderSequenceInBinarySearchTree solution = new VerifyPreorderSequenceInBinarySearchTree();
    	//int[] pre = {2, 1};
    	int[] pre = {5, 2, 6, 1, 3};
    	boolean res = solution.verifyPreorder(pre);
    	System.out.println(res);
    }
}

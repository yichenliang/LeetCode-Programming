package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClosestLeafInABinaryTreeTest {
	
	private  ClosestLeafInABinaryTree solution;

    @BeforeEach
    void beforeEach() {
        solution = new ClosestLeafInABinaryTree();
    }
    
    @Test
    void test1() {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	int a = 2;
    	Assertions.assertEquals(a, solution.findClosestLeaf(root, 1));   
    }

}

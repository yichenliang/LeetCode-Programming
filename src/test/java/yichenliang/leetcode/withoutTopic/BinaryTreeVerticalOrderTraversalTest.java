package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinaryTreeVerticalOrderTraversalTest {
	
	private  BinaryTreeVerticalOrderTraversal solution;

    @BeforeEach
    void beforeEach() {
        solution = new BinaryTreeVerticalOrderTraversal();
    }
    
    @Test
    void test1() {
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	root.right = new TreeNode(20);
    	root.right.left = new TreeNode(15);
    	root.right.right = new TreeNode(7);
    	List<List<Integer>> ans = new ArrayList<>();
    	List<Integer> l1 = new ArrayList<>();
    	l1.add(9);
    	ans.add(l1);
    	List<Integer> l2 = new ArrayList<>();
    	l2.add(3);
    	l2.add(15);
    	ans.add(l2);
    	List<Integer> l3 = new ArrayList<>();
    	l3.add(20);
    	ans.add(l3);
    	List<Integer> l4 = new ArrayList<>();
    	l4.add(7);
    	ans.add(l4);
        Assertions.assertEquals(ans,solution.verticalOrder(root));
    }

}

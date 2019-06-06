package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AllNodesDistanceKInBinaryTreeTest {
	
	private AllNodesDistanceKInBinaryTree solution;

    @BeforeEach
    void beforeEach() {
        solution = new AllNodesDistanceKInBinaryTree();
    }

    @Test
    void test1() {
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(5);
    	root.right =new TreeNode(1);
    	root.left.left = new TreeNode(6);
    	root.left.right = new TreeNode(2);
    	root.left.right.left = new TreeNode(7);
    	root.left.right.right = new TreeNode(4);
    	root.right.left = new TreeNode(0);
    	root.right.right = new TreeNode(8);
    	TreeNode target = root.left;
    	int K = 2;
    	List<Integer> res = new ArrayList<>();
    	res.add(7);
    	res.add(4);
    	res.add(1);
        Assertions.assertEquals(res,solution.distanceK(root, target, K));
       
    }

}

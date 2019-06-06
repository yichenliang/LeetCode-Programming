package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.VerifyPreorderSequenceInBinarySearchTree;

public class VerifyPreorderSequenceInBinarySearchTreeTest {
	private VerifyPreorderSequenceInBinarySearchTree solution;

    @BeforeEach
    void beforeEach() {
        solution = new VerifyPreorderSequenceInBinarySearchTree();
    }

    @Test
    void test1() {
    	//int[] preorder = {1, 2, 3};
    	int[] preorder = {5, 2, 1, 3, 6};
        Assertions.assertTrue(solution.verifyPreorder(preorder));
    }
}

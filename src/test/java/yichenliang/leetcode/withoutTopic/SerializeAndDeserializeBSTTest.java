package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SerializeAndDeserializeBSTTest {
	
	private SerializeAndDeserializeBST solution;

    @BeforeEach
    void beforeEach() {
        solution = new SerializeAndDeserializeBST();
    }

    @Test
    void test1() {
    	TreeNode root = new TreeNode(10);
    	root.left = new TreeNode(5);
    	root.left.left = new TreeNode(1);
    	root.left.right = new TreeNode(6);
    	root.right = new TreeNode(14);
    	root.right.right = new TreeNode(16);
    	String data = solution.serialize(root);
        Assertions.assertEquals("10 5 14 1 6 * 16 * * * * * * ", data);
        Assertions.assertEquals(root.val, solution.deserialize(data).val);
    }

}

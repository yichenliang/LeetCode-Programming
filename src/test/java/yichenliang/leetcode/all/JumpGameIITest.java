package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.JumpGameII;

public class JumpGameIITest {
	
	private JumpGameII solution;

    @BeforeEach
    void beforeEach() {
        solution = new JumpGameII();
    }

    @Test
    void test1() {
    	int[] nums = {2,3,1,1,4};
        Assertions.assertEquals(2,solution.jump(nums));
       
    }
}

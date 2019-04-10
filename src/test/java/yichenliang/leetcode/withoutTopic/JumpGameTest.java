package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class JumpGameTest {
	
	private JumpGame solution;

    @BeforeEach
    void beforeEach() {
        solution = new JumpGame();
    }

    @Test
    void test1() {
    	int[] nums = {3, 2, 1, 0, 4};
        Assertions.assertEquals(false, solution.canJump1(nums));
       
    }
	
	

}

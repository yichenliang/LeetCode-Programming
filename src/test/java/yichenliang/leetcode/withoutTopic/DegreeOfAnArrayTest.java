package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DegreeOfAnArrayTest {
	
	private DegreeOfAnArray solution;

    @BeforeEach
    void beforeEach() {
        solution = new DegreeOfAnArray();
    }

    @Test
    void test1() {
    	int[] nums = {1, 2, 2, 3, 1};
        Assertions.assertEquals(2,solution.findShortestSubArray(nums));
       
    }

}

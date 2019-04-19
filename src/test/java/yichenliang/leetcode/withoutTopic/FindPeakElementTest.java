package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindPeakElementTest {
	
	private FindPeakElement solution;

    @BeforeEach
    void beforeEach() {
        solution = new FindPeakElement();
    }

    @Test
    void test1() {
    	int[] nums = {3, 2, 1};
        Assertions.assertEquals(0,solution.findPeakElement(nums));
       
    }

}

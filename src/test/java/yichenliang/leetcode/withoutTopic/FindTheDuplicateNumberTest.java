package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindTheDuplicateNumberTest {
	
	private  FindTheDuplicateNumber solution;

    @BeforeEach
    void beforeEach() {
        solution = new FindTheDuplicateNumber();
    }
    
    @Test
    void test1() {
    	int[] nums = {1, 3, 4, 2,2};
        Assertions.assertEquals(2, solution.findDuplicate(nums));   
    }

}

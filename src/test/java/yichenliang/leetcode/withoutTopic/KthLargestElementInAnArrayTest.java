package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KthLargestElementInAnArrayTest {
	
	private  KthLargestElementInAnArray solution;

    @BeforeEach
    void beforeEach() {
        solution = new KthLargestElementInAnArray();
    }
    
    @Test
    void test1() {
    	int[] nums = {3, 2, 1, 5, 6, 4}; 
    	int k = 2;
    	Assertions.assertEquals(5, solution.findKthLargest(nums, k));   
    }

}

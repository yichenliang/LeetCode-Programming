package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SlidingWindowMedianTest {
	private SlidingWindowMedian solution;

    @BeforeEach
    void beforeEach() {
        solution = new SlidingWindowMedian();
    }

    @Test
    void test1() {
    	int[] nums = {1,3,-1,-3,5,3,6,7};
    	int k = 3;
    	double[] ans = {1.0,-1.0,-1.0,3.0,5.0,6.0};
        Assertions.assertArrayEquals(ans,solution.medianSlidingWindow(nums, k));
        
    }
    
    @Test
    void test2() {
    	int[] nums = {1,3};
    	int k = 2;
    	double[] ans = {2.0};
        Assertions.assertArrayEquals(ans,solution.medianSlidingWindow(nums, k));
        
    }
    
    @Test
    void test3() {
    	int[] nums = {1, 4, 3, 2};
    	int k = 4;
    	double[] ans = {2.5};
        Assertions.assertArrayEquals(ans,solution.medianSlidingWindow(nums, k));
        
    }
    
    @Test
    void test4() {
    	int[] nums = {5,5,8,1,4,7,1,3,8,4};
    	int k = 8;
    	double[] ans = {4.5,4.5,4.0};
        Assertions.assertArrayEquals(ans,solution.medianSlidingWindow(nums, k));
        
    }
}

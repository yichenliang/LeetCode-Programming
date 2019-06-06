package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.PourWater;


public class PourWaterTest {
	
	private PourWater solution;

    @BeforeEach
    void beforeEach() {
        solution = new PourWater();
    }

    @Test
    void test1() {
    	int[] heights = {4,3,2,1,2,3,4,3,2,1};
    	int V = 5;
    	int K = 2;
        Assertions.assertArrayEquals(new int[] {4,3,4,3,3,3,4,3,2,1} , solution.pourWater(heights, V, K));
    }
    
    @Test
    void test3() {
    	int[] heights = {1,2,3,4,3,2,1,2,3,4,3,2,1};
    	int V = 5;
    	int K = 2;
        Assertions.assertArrayEquals(new int[] {3,4,4,4,3,2,1,2,3,4,3,2,1}, solution.pourWater(heights, V, K));
    }

}

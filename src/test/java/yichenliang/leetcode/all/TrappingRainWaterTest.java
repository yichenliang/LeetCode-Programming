package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.TrappingRainWater;

	public class TrappingRainWaterTest {
		private TrappingRainWater solution;

		@BeforeEach
		void beforeEach() {
			solution = new TrappingRainWater();
		}
		
		@Test
	    void test1() {
			int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
	        Assertions.assertEquals(6, solution.trap1(height));
	        
	    }
}

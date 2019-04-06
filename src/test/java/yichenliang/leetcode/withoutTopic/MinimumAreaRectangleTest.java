package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MinimumAreaRectangleTest {
	
	private MinimumAreaRectangle solution;

    @BeforeEach
    void beforeEach() {
        solution = new MinimumAreaRectangle();
    }

    @Test
    void test1() {
    	int[][] points = {{1,1},{1,3},{3,1},{3,3},{4,1},{4,3}};
        Assertions.assertEquals(2, solution.minAreaRect(points));
    }


}

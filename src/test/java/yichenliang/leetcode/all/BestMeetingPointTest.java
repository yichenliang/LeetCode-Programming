package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BestMeetingPointTest {
	
	private BestMeetingPoint solution;

    @BeforeEach
    void beforeEach() {
        solution = new BestMeetingPoint();
    }

    @Test
    void test() {
    	int[][] grid = {{1,0,0,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        Assertions.assertEquals(6,solution.minTotalDistance2(grid));
       
    }

}

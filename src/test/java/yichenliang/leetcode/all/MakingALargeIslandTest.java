package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.MakingALargeIsland;

public class MakingALargeIslandTest {
	
	private MakingALargeIsland solution;

    @BeforeEach
    void beforeEach() {
        solution = new MakingALargeIsland();
    }

    @Test
    void test1() {
    	int[][] grid = {{1, 1}, {0, 1}};
        Assertions.assertEquals(4, solution.largestIsland(grid));
       
    }

}

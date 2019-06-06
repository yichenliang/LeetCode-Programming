package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

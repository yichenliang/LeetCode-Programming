package yichenliang.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class KClosestPointsToOriginTest {
	private KClosestPointsToOrigin solution;

    @BeforeEach
    void beforeEach() {
        solution = new KClosestPointsToOrigin();
    }

    @Test
    void test1() {
        Assertions.assertArrayEquals(new int[][] {{3,3},{-2,4}} , solution.kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2));
    }

    
}

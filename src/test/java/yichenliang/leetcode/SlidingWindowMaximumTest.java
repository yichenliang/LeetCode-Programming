package yichenliang.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SlidingWindowMaximumTest {
    private SlidingWindowMaximum solution;

    @BeforeEach
    void beforeEach() {
        solution = new SlidingWindowMaximum();
    }

    @Test
    void test1() {
        Assertions.assertArrayEquals(new int[] {3,3,5,5,6,7}, solution.maxSlidingWindow(new int[] { 1,3,-1,-3,5,3,6,7 }, 3));
        
    }

}

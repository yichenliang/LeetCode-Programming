package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.SlidingPuzzle;

public class SlidingPuzzleTest {

	private SlidingPuzzle solution;

    @BeforeEach
    void beforeEach() {
        solution = new SlidingPuzzle();
    }

    @Test
    void test1() {
    	int[][] board = {{1,2,3},{4,0,5}};
        Assertions.assertEquals(1, solution.slidingPuzzle(board));
        
    }
    
    @Test
    void test2() {
    	int[][] board = {{4,1,2},{5,0,3}};
        Assertions.assertEquals(5, solution.slidingPuzzle(board));
        
    }
    
    @Test
    void test3() {
    	int[][] board = {{1,2,3},{5,4,0}};
        Assertions.assertEquals(-1, solution.slidingPuzzle(board));
        
    }
    
    @Test
    void test4() {
    	int[][] board = {{1,2,3},{4,5,0}};
        Assertions.assertEquals(0, solution.slidingPuzzle(board));
        
    }
}

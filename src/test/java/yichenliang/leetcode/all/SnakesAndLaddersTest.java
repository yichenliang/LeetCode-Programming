package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SnakesAndLaddersTest {
	private SnakesAndLadders solution;

    @BeforeEach
    void beforeEach() {
        solution = new SnakesAndLadders();
    }

    @Test
    void test1() {
//    	int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
    	int[][] board = {{1,1,-1},{1,1,1},{-1,1,1}};
        Assertions.assertEquals(4, solution.snakesAndLadders(board));
        
    }	
	

}

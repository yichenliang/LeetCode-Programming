package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MaximalSquareTest {
	
	private MaximalSquare solution;

    @BeforeEach
    void beforeEach() {
        solution = new MaximalSquare();
    }

    @Test
    void test1() {
    	char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        Assertions.assertEquals(4, solution.maximalSquare1(matrix));
    }
    
    @Test
    void test2() {
    	char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        Assertions.assertEquals(4, solution.maximalSquare2(matrix));
    }
}

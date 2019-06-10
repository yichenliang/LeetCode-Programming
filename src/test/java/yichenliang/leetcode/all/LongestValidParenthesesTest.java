package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.LongestValidParentheses;

public class LongestValidParenthesesTest {
	
	private LongestValidParentheses solution;

    @BeforeEach
    void beforeEach() {
        solution = new LongestValidParentheses();
    }

    @Test
    void test1() {
        Assertions.assertEquals(8, solution.longestValidParentheses("(()())())()"));    
    }
}

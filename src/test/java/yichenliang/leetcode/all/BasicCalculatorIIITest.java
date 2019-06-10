package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.BasicCalculatorIII;

public class BasicCalculatorIIITest {
	
	private BasicCalculatorIII solution;

    @BeforeEach
    void beforeEach() {
        solution = new BasicCalculatorIII();
    }

    @Test
    void test1() {
        Assertions.assertEquals(21,solution.calculate("2*(5+5*2)/3+(6/2+8)"));
       
    }
    
}
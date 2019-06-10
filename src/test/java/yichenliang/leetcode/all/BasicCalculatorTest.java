package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.BasicCalculator;

public class BasicCalculatorTest {
	private BasicCalculator solution;

    @BeforeEach
    void beforeEach() {
        solution = new BasicCalculator();
    }

    @Test
    void test1() {
        Assertions.assertEquals(2,solution.calculate2("1 + 1"));
        Assertions.assertEquals(-4,solution.calculate2("1-(5)"));
       
    }
	

}

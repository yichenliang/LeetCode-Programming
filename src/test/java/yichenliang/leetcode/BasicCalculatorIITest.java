package yichenliang.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicCalculatorIITest {
	
	private BasicCalculatorII solution;

    @BeforeEach
    void beforeEach() {
        solution = new BasicCalculatorII();
    }

    @Test
    void test1() {
        Assertions.assertEquals(48,solution.calculate("32+5*3+1"));
       
    }
    
}

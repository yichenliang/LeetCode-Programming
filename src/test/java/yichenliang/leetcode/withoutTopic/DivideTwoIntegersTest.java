package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DivideTwoIntegersTest {
	
	private DivideTwoIntegers solution;

    @BeforeEach
    void beforeEach() {
        solution = new DivideTwoIntegers();
    }

    @Test
    void test1() {
    	int dividend = 10;
    	int divisor = 3;
        Assertions.assertEquals(3, solution.divide(dividend, divisor));
       
    }
    
    @Test
    void test2() {
    	int dividend = 2147483647;
    	int divisor = 1; 
        Assertions.assertEquals(2147483647, solution.divide(dividend, divisor));
       
    }

}

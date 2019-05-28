package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

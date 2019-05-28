package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReverseIntegerTest {
	
	private ReverseInteger solution;

    @BeforeEach
    void beforeEach() {
        solution = new ReverseInteger();
    }

    @Test
    void test1() {
    	int x = -123;
        Assertions.assertEquals(-321, solution.reverse(x));
       
    }

}

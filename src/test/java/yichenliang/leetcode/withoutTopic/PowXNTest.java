package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.PowXN;


public class PowXNTest {
	private PowXN solution;

    @BeforeEach
    void beforeEach() {
        solution = new PowXN();
    }

    @Test
    void test1() {
        Assertions.assertEquals(1024.00000,solution.myPow(2.00000, 10));
        Assertions.assertEquals(0.25000,solution.myPow(2.00000, -2));
    }
}

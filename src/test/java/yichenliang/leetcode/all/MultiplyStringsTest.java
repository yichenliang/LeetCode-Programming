package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.MultiplyStrings;


public class MultiplyStringsTest {
	private  MultiplyStrings solution;

    @BeforeEach
    void beforeEach() {
        solution = new MultiplyStrings();
    }

    @Test
    void test1() {
        Assertions.assertEquals("998001", solution.multiply("999", "999"));   
    }
}

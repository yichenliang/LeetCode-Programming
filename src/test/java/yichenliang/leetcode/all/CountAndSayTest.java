package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.CountAndSay;

public class CountAndSayTest {
	
	private CountAndSay solution;

    @BeforeEach
    void beforeEach() {
        solution = new CountAndSay();
    }

    @Test
    void test1() {
    	int n = 4;
        Assertions.assertEquals("1211",solution.countAndSay(n));
       
    }

}

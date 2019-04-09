package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

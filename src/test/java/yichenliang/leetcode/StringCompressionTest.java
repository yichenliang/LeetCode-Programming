package yichenliang.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCompressionTest {
	
	private  StringCompression solution;

    @BeforeEach
    void beforeEach() {
        solution = new StringCompression();
    }

    @Test
    void test1() {
        Assertions.assertEquals(6, solution.compress(new char[] {'a', 'a', 'b','b', 'c','c','c'}));
    }

}

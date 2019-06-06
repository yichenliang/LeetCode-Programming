package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.WildcardMatching;


public class WildcardMatchingTest {
	
	private WildcardMatching solution;

    @BeforeEach
    void beforeEach() {
        solution = new WildcardMatching();
    }

    @Test
    void test1() {
    	String s = "aa";
    	String p = "a";
        Assertions.assertFalse(solution.isMatch(s, p));
       
    }
	
	

}

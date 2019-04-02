package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.ReverseWordsInAString;

public class ReverseWordsInAStringTest {
	
	    private ReverseWordsInAString solution;

	    @BeforeEach
	    void beforeEach() {
	        solution = new ReverseWordsInAString();
	    }

	    @Test
	    void test1() {
	        Assertions.assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
	        
	    }
}

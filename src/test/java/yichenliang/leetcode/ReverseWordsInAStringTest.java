package yichenliang.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReverseWordsInAStringTest {
	
	    private ReverseWordsInAString solution;

	    @BeforeEach
	    void beforeEach() {
	        solution = new ReverseWordsInAString();
	    }

	    @Test
	    void isOneBitCharacter() {
	        Assertions.assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
	        
	    }
}

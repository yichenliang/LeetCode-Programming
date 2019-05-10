package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RemoveKDigitsTest {
	
	
		
		private RemoveKDigits solution;

	    @BeforeEach
	    void beforeEach() {
	        solution = new RemoveKDigits();
	    }

	    @Test
	    void test1() {
//	    	String num = "10200"; 
//	    	int k = 1;
	    	String num = "112"; 
	    	int k = 1;
	        Assertions.assertEquals("11",solution.removeKdigits(num, k));
	       
	    }

}

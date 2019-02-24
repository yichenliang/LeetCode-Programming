package yichenliang.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TextJustificationTest {
	
	    private TextJustification solution;

	    @BeforeEach
	    void beforeEach() {
	        solution = new TextJustification();
	    }

	    @Test
	    void test1() {
	    	List<String> res = new ArrayList<>();
	    	res.add("This    is    an");
	    	res.add("example  of text");
	    	res.add("justification.  ");
	        Assertions.assertEquals(res,solution.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}
	        		, 16));
	        
	    }

	   
	
}

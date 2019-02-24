package yichenliang.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OddEvenJumpTest {
	
	    private OddEvenJump solution;

	    @BeforeEach
	    void beforeEach() {
	        solution = new OddEvenJump();
	    }

	    @Test
	    void isOneBitCharacter() {
	        
	        Assertions.assertEquals(2 ,solution.oddEvenJumps(new int[] {10,13,12,14,15}));
	    }

	   
	}



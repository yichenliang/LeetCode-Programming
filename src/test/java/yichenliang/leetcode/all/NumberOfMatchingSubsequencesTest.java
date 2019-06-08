package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NumberOfMatchingSubsequencesTest {
	
	private NumberOfMatchingSubsequences solution;

    @BeforeEach
    void beforeEach() {
        solution = new NumberOfMatchingSubsequences();
    }

    @Test
    void test1() {
    	String S = "abcde";
    	String[] words = {"a","bb","acd","ace"};
        Assertions.assertEquals(3, solution.numMatchingSubseq(S, words));
       
    }

}

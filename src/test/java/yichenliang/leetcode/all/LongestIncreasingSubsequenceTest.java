package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.LongestIncreasingSubsequence;

public class LongestIncreasingSubsequenceTest {
	
	private LongestIncreasingSubsequence  solution;

    @BeforeEach
    void beforeEach() {
        solution = new LongestIncreasingSubsequence();
    }

    @Test
    void test1() {
        Assertions.assertEquals(4, solution.lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));  
    }
    
    @Test
    void test2() {
        Assertions.assertEquals(3, solution.lengthOfLIS(new int[] {0, 8, 4, 12, 2}));  
    }
    
    @Test
    void test3() {
        Assertions.assertEquals(4, solution.lengthOfLIS(new int[] {0, 8, 4, 12, 2, 16}));  
    }

}

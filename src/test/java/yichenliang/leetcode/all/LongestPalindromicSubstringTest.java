package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.LongestPalindromicSubstring;

public class LongestPalindromicSubstringTest {
	
	private LongestPalindromicSubstring solution;

    @BeforeEach
    void beforeEach() {
        solution = new LongestPalindromicSubstring();
    }

    @Test
    void test1() {
    	String s = "aaaaaa";
        Assertions.assertEquals("aaaaaa",solution.longestPalindrome(s));
       
    }

}

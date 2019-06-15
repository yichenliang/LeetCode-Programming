package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharactersTest {
	
	private LongestSubstringWithoutRepeatingCharacters solution;

    @BeforeEach
    void beforeEach() {
        solution = new LongestSubstringWithoutRepeatingCharacters();
    }

    @Test
    void test1() {
    	String s = "abcabcbb";
        Assertions.assertEquals(3, solution.lengthOfLongestSubstring(s));
       
    }

}

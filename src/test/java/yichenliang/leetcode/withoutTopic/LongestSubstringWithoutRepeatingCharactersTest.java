package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

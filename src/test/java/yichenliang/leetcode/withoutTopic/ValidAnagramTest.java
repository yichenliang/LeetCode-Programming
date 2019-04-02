package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.ValidAnagram;


public class ValidAnagramTest {
	private ValidAnagram solution;

    @BeforeEach
    void beforeEach() {
        solution = new ValidAnagram();
    }

    @Test
    void test1() {
        Assertions.assertEquals(true,solution.isAnagram("anagram", "nagaram"));
        Assertions.assertEquals(false,solution.isAnagram("rat", "car"));
    }
    
    @Test
    void test2() {
        Assertions.assertEquals(false,solution.isAnagram2("a", "b"));
    }
}

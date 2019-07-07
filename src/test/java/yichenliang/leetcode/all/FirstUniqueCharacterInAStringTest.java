package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.FirstUniqueCharacterInAString;

public class FirstUniqueCharacterInAStringTest {
	
	private FirstUniqueCharacterInAString solution;

    @BeforeEach
    void beforeEach() {
        solution = new FirstUniqueCharacterInAString();
    }

    @Test
    void test1() {
    	String s = "leetcode";
        Assertions.assertEquals(0,solution.firstUniqChar(s));
       
    }

}

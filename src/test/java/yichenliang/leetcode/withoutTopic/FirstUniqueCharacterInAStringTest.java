package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

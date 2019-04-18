package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompareVersionNumbersTest {
	private CompareVersionNumbers solution;

    @BeforeEach
    void beforeEach() {
        solution = new CompareVersionNumbers();
    }

    @Test
    void test1() {
    	String version1 = "0.1";
    	String version2 = "1.1";
        Assertions.assertEquals(-1,solution.compareVersion(version1, version2));
       
    }

}

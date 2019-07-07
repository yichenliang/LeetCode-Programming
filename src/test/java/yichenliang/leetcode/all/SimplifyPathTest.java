package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.SimplifyPath;

public class SimplifyPathTest {
	
	private SimplifyPath solution;

    @BeforeEach
    void beforeEach() {
        solution = new SimplifyPath();
    }

    @Test
    void test1() {
    	String path = "/a/.///b/c/";
        Assertions.assertEquals("/a/b/c", solution.simplifyPath(path));
       
    }

}

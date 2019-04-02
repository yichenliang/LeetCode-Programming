package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.ZigZagConversion;

public class ZigZagConversionTest {
	
	private ZigZagConversion  solution;

    @BeforeEach
    void beforeEach() {
        solution = new ZigZagConversion();
    }

    @Test
    void test1() {
    	String s = "AB";
    	int numRows = 3;
        Assertions.assertEquals("AB", solution.convert(s, numRows));   
    }
    
    @Test
    void test2() {
    	String s = "PAYPALISHIRING";
    	int numRows = 4;
        Assertions.assertEquals("PINALSIGYAHRPI", solution.convert(s, numRows));   
    }

}

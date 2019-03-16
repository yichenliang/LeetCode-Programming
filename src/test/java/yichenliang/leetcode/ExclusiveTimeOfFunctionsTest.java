package yichenliang.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExclusiveTimeOfFunctionsTest {
	
	private  ExclusiveTimeOfFunctions solution;

    @BeforeEach
    void beforeEach() {
        solution = new ExclusiveTimeOfFunctions();
    }
    
    @Test
    void test1() {
    	List<String> logs = new ArrayList<>();
    	logs.add("0:start:0");
    	logs.add("1:start:2");
    	logs.add("1:end:5");
    	logs.add("0:end:6");
    	int[] res = {3,4};
        Assertions.assertArrayEquals(res, solution.exclusiveTime(2, logs));   
    }

}

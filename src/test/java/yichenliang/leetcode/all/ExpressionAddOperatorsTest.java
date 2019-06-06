package yichenliang.leetcode.all;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.ExpressionAddOperators;

public class ExpressionAddOperatorsTest {
	private ExpressionAddOperators solution;

    @BeforeEach
    void beforeEach() {
        solution = new ExpressionAddOperators();
    }

    @Test
    void test1() {
    	//["1*0+5","10-5"]
    	List<String> ans = new ArrayList<>();
    	ans.add("1*0+5");
    	ans.add("10-5");
        Assertions.assertEquals(ans, solution.addOperators("105", 5));
        
    }
    
    @Test
    void test2() {
    	//num = "3456237490", target = 9191   Output: []
    	List<String> ans = new ArrayList<>();
        Assertions.assertEquals(ans, solution.addOperators("3456237490", 9191));
        
    }

}

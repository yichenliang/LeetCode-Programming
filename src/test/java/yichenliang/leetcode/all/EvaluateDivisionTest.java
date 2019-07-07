package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.unionFind.EvaluateDivision;

public class EvaluateDivisionTest {
	
	private EvaluateDivision solution;

    @BeforeEach
    void beforeEach() {
        solution = new EvaluateDivision();
    }

    @Test
    void test1() {
    	//public double[] calcEquation(String[][] equations, double[] values, String[][] queries)
    	String[][] equations = { {"a", "b"}, {"b", "c"} };
    	double[] values = {2.0, 3.0};
    	String[][] queries = { {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
        Assertions.assertArrayEquals(new double[] {6.0, 0.5, -1.0, 1.0, -1.0}, solution.calcEquation(equations, values, queries));
    }
    
    @Test
    void test2() {
    	//public double[] calcEquation(String[][] equations, double[] values, String[][] queries)
    	String[][] equations = { {"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"} };
    	double[] values = {3.0,4.0,5.0,6.0};
    	String[][] queries ={ {"x1","x5"}, {"x2","x4"}, {"x2","x2"}, {"x2","x9"}, {"x9","x9"}};
        Assertions.assertArrayEquals(new double[] {360.0,20.0,1.0,-1.0,-1.0}, solution.calcEquation(equations, values, queries));
    }

}

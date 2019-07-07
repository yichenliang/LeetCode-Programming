package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.TwoSumII_InputArrayIsSorted;

public class TwoSumII_InputArrayIsSortedTest {

	private  TwoSumII_InputArrayIsSorted solution;

    @BeforeEach
    void beforeEach() {
        solution = new TwoSumII_InputArrayIsSorted();
    }

    @Test
    void test1() {
    	int[] numbers = {1,2,3,4,5,6,7,11,15};
    	int target = 9;
    	int[] ans = {2, 7};
        Assertions.assertArrayEquals(ans, solution.twoSum(numbers, target));   
    }
}

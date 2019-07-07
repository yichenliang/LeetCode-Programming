package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindAllDuplicatesInAnArrayTest {
	
	private FindAllDuplicatesInAnArray solution;

    @BeforeEach
    void beforeEach() {
        solution = new FindAllDuplicatesInAnArray();
    }

    @Test
    void test1() {
    	int[] nums = {4,3,2,7,8,2,3,1};
    	List<Integer> res = new ArrayList<>();
    	res.add(3);
    	res.add(2);
        Assertions.assertEquals(res,solution.findDuplicates(nums));
       
    }

}

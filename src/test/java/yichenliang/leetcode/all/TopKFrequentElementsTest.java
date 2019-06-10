package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.TopKFrequentElements;


public class TopKFrequentElementsTest {
	private TopKFrequentElements solution;

    @BeforeEach
    void beforeEach() {
        solution = new TopKFrequentElements();
    }

    @Test
    void test1() {
    	List<Integer> res = new ArrayList<>();
    	res.add(1);
    	res.add(2);
        Assertions.assertEquals(res, solution.topKFrequent(new int[] {1,1,1,2,2,2}, 1));
    }

}

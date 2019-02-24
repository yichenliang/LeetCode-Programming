package yichenliang.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TopK_FrequentElementsTest {
	private TopK_FrequentElements solution;

    @BeforeEach
    void beforeEach() {
        solution = new TopK_FrequentElements();
    }

    @Test
    void test1() {
    	List<Integer> res = new ArrayList<>();
    	res.add(1);
    	res.add(2);
        Assertions.assertEquals(res, solution.topKFrequent(new int[] {1,1,1,2,2,2}, 1));
    }

}

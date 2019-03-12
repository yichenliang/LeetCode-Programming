package yichenliang.leetcode;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopKFrequentWordsTest {
	
	private TopKFrequentWords solution;

    @BeforeEach
    void beforeEach() {
        solution = new TopKFrequentWords();
    }

    @Test
    void test1() {
    	List<String> res = new LinkedList<>();
    	res.add("i");
    	res.add("love");
        Assertions.assertEquals(res,solution.topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }

}

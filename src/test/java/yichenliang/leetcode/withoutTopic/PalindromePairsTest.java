package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.PalindromePairs;

public class PalindromePairsTest {
	 private  PalindromePairs solution;

	    @BeforeEach
	    void beforeEach() {
	        solution = new PalindromePairs();
	    }
	    
	    @Test
	    void test1() {
	    	List<Integer> list1 = new ArrayList<>();
	    	list1.add(1);
	    	list1.add(0);
	    	List<Integer> list2 = new ArrayList<>();
	    	list2.add(0);
	    	list2.add(1);
	    	List<List<Integer>> res = new ArrayList<>();
	    	res.add(list1);
	    	res.add(list2);
	        Assertions.assertEquals(res,solution.palindromePairs(new String[] {"bat","tab","cat"}));
	    }
}

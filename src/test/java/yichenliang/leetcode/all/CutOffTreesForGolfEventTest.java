package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CutOffTreesForGolfEventTest {
	
	private CutOffTreesForGolfEvent solution;

    @BeforeEach
    void beforeEach() {
        solution = new CutOffTreesForGolfEvent();
    }

    @Test
    void test1() {
    	
    	List<List<Integer>> forest = new ArrayList<>();
    	List<Integer> t1 = new ArrayList<>();
    	t1.add(1);
    	t1.add(2);
    	t1.add(3);
    	forest.add(t1);
    	List<Integer> t2 = new ArrayList<>();
    	t2.add(0);
    	t2.add(0);
    	t2.add(4);
    	forest.add(t2);
    	List<Integer> t3 = new ArrayList<>();
    	t3.add(7);
    	t3.add(6);
    	t3.add(5);
    	forest.add(t3);
        Assertions.assertEquals(6,solution.cutOffTree(forest));
       
    }

}

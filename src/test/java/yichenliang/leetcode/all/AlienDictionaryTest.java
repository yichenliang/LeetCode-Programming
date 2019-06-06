package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.AlienDictionary;

public class AlienDictionaryTest {
	
	private  AlienDictionary solution;

    @BeforeEach
    void beforeEach() {
        solution = new AlienDictionary();
    }
    
    @Test
    void test1() {
    	String[] words = { "wrt", "wrf", "er", "ett", "rftt"};
    	String res = "wertf";
    	Assertions.assertEquals(res, solution.alienOrder(words));   
    }

}

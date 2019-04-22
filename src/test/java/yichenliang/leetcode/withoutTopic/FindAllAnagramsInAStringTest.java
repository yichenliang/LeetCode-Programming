package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindAllAnagramsInAStringTest {
	
	private  FindAllAnagramsInAString solution;

    @BeforeEach
    void beforeEach() {
        solution = new FindAllAnagramsInAString();
    }
    
    @Test
    void test1() {
    	String s = "ababababab";
    	String p = "aab";
    	List<Integer> ans = new ArrayList<>();
    	ans.add(0);
    	ans.add(2);
    	ans.add(4);
    	ans.add(6);
        Assertions.assertEquals(ans, solution.findAnagrams(s, p));   
    }

}

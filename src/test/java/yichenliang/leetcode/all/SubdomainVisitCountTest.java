package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.SubdomainVisitCount;

public class SubdomainVisitCountTest {
	
	private SubdomainVisitCount solution;

    @BeforeEach
    void beforeEach() {
        solution = new SubdomainVisitCount();
    }

    @Test
    void test1() {
    	//public List<String> subdomainVisits(String[] cpdomains)
    	String[] cpdomains = {"9001 discuss.leetcode.com"};
    	List<String> res = new ArrayList<>();
    	res.add("9001 com");
    	res.add("9001 leetcode.com");
    	res.add("9001 discuss.leetcode.com");
        Assertions.assertEquals(res, solution.subdomainVisits(cpdomains));
        
    }	

}

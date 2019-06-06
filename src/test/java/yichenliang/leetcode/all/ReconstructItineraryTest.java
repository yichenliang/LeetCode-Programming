package yichenliang.leetcode.all;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.ReconstructItinerary;


public class ReconstructItineraryTest {
	
	private ReconstructItinerary solution;

	@BeforeEach
	void beforeEach() {
	    solution = new ReconstructItinerary();
	}

	@Test
	void test1() {
		List<String> res = new ArrayList<>();
		res.add("JFK");
		res.add("ATL");
		res.add("JFK");
		res.add("SFO");
		res.add("ATL");
		res.add("SFO");
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		                                                                                                                                                                                                                                 
		//String[][] tickets = {{"EZE","TIA"},{"EZE","HBA"},{"AXA","TIA"},{"JFK","AXA"},{"ANU","JFK"},{"ADL","ANU"},{"TIA","AUA"},{"AUA","ANU"},{"ANU","EZE"},{"TIA","ADL"},{"EZE","ANU"},{"AUA","ADL"},{"AXA","AUA"},{"JFK","AXA"},{"AUA","AXA"},{"AXA","EZE"},{"ANU","AUA"},{"ADL","EZE"},{"ADL","EZE"},{"EZE","ADL"}};
	    Assertions.assertEquals(res, solution.findItinerary(tickets));    
	}
	
	@Test
	void test2() {
		List<String> res = new ArrayList<>();
		res.add("JFK");
		res.add("NRT");
		res.add("JFK");
		res.add("KUL");
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
	    Assertions.assertEquals(res, solution.findItinerary(tickets));    
	}
	
}

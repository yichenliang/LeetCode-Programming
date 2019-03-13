package yichenliang.leetcode;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


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
	    Assertions.assertEquals(res, solution.findItinerary(tickets));    
	}
	
}

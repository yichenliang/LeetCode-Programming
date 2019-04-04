package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindDuplicateFileInSystemTest {
	
		private  FindDuplicateFileInSystem solution;

	    @BeforeEach
	    void beforeEach() {
	        solution = new FindDuplicateFileInSystem();
	    }

	    @Test
	    void test1() {
	    	//List<List<String>> findDuplicate(String[] paths)
	    	String[] paths = {"root/cgcgc/vjjumw/enueowqwvjjpfk/lc/xqttxhgsluvp/i/mcgfuns/bphcylafabzq ylmenjgkhxtr.txt(ayncelfdpotwjcvlhgtxdjnemci) hv.txt(ayncelfdpotwjcvlhgtxdjnemci) wvlt.txt(ayncelfdpotwjcvlhgtxdjnemci) nwtpxoxypxyaw.txt(ayncelfdpotwjcvlhgtxdjnemci)"};
	    	List<List<String>> res = new ArrayList<>();
	    	List<String> r = new ArrayList<>();
	    	r.add("root/cgcgc/vjjumw/enueowqwvjjpfk/lc/xqttxhgsluvp/i/mcgfuns/bphcylafabzq/ylmenjgkhxtr.txt");
	    	r.add("root/cgcgc/vjjumw/enueowqwvjjpfk/lc/xqttxhgsluvp/i/mcgfuns/bphcylafabzq/hv.txt");
	    	r.add("root/cgcgc/vjjumw/enueowqwvjjpfk/lc/xqttxhgsluvp/i/mcgfuns/bphcylafabzq/wvlt.txt");
	    	r.add("root/cgcgc/vjjumw/enueowqwvjjpfk/lc/xqttxhgsluvp/i/mcgfuns/bphcylafabzq/nwtpxoxypxyaw.txt");
	    	res.add(r);
	        Assertions.assertEquals(res, solution.findDuplicate(paths));   
	    }

}

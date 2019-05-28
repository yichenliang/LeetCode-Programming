package yichenliang.leetcode.withoutTopic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordSearchIITest {

	private WordSearchII solution;

    @BeforeEach
    void beforeEach() {
        solution = new WordSearchII();
    }

    @Test
    void test1() {
    	char[][] board = {{'o','a','a','n'},{'e','t','a','e'}, {'i','h','k','r'},{'i','f','l','v'}};
    	                              
    	String[] words = {"oath","pea","eat","rain"};
    	String[] ans = {"eat","oath"};
        Assertions.assertEquals(ans,solution.findWords(board, words));
        
    }
}

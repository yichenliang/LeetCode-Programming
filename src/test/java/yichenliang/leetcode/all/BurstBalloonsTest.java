package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.withoutTopic.BurstBalloons;

public class BurstBalloonsTest {
	private  BurstBalloons solution;

    @BeforeEach
    void beforeEach() {
        solution = new BurstBalloons();
    }
    
    @Test
    void test1() {
        Assertions.assertEquals(167,solution.maxCoins(new int[] {3,1,5,8}));
    }
}

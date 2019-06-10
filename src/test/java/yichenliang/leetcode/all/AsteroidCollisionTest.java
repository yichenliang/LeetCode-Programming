package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.AsteroidCollision;

public class AsteroidCollisionTest {
	
	private AsteroidCollision solution;

    @BeforeEach
    void beforeEach() {
        solution = new AsteroidCollision();
    }

    @Test
    void test1() {
    	int[] asteroids = {-2, -1, 1, 2};
        Assertions.assertArrayEquals(new int[] {-2, -1, 1, 2}, solution.asteroidCollision(asteroids));
       
    }
    
    @Test
    void test2() {
    	int[] asteroids = {5, 10, -5};
        Assertions.assertArrayEquals(new int[] {5, 10},solution.asteroidCollision(asteroids));
       
    }
    
    @Test
    void test3() {
    	int[] asteroids = {8, -8};
        Assertions.assertArrayEquals(new int[] {},solution.asteroidCollision(asteroids));
       
    }

}

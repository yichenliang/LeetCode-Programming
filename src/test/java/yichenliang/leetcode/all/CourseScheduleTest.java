package yichenliang.leetcode.all;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import yichenliang.leetcode.all.CourseSchedule;

public class CourseScheduleTest {
	private  CourseSchedule solution;

    @BeforeEach
    void beforeEach() {
        solution = new CourseSchedule();
    }
    
    @Test
    void test1() {
    	int numCourses = 2;
    	int[][] prerequisites = {{0,1},{1,0}};
        Assertions.assertFalse(solution.canFinish(numCourses, prerequisites));
    }
    
    @Test
    void test2() {
    	int numCourses = 3;
    	int[][] prerequisites = {{1,0},{1,2},{0,1}};
        Assertions.assertFalse(solution.canFinish(numCourses, prerequisites));
    }
}

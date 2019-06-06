package yichenliang.leetcode.all;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  735. Asteroid Collision
 * 
 *  stack
 * 
 *  time complexity: O(n)
 *  space complexity: O(n)
 */

public class AsteroidCollision {
	
public int[] asteroidCollision(int[] asteroids) {
        
        // corner case
        if(asteroids == null || asteroids.length == 0){
            int[] res = {};
            return res;
        }
        
        // normal case
        Deque<Integer> stack = new LinkedList<>();
        int len = asteroids.length;
        
        //stack.addFirst(asteroids[0]);
        
        for(int i = 0; i < len; i++){
            if(stack.size() == 0 || asteroids[i] * stack.peekFirst() > 0){
                stack.addFirst(asteroids[i]);
            }
            else if(stack.peekFirst() < 0 && asteroids[i] > 0){
                stack.addFirst(asteroids[i]);
            }
            else{
                int curValue = asteroids[i];
                while(stack.size() > 0 && curValue < 0 && stack.peekFirst() > 0){
                    int stackTop = stack.removeFirst();
                    if(Math.abs(curValue) > Math.abs(stackTop)){
                        //curValue = curValue;
                    }
                    else if(Math.abs(curValue) < Math.abs(stackTop)){
                        curValue = stackTop;
                    }
                    else{
                        curValue = 0;
                        break;
                    }
                }
                if(curValue != 0){
                    stack.addFirst(curValue);
                }
            }
        }
        
        // return res
        int stackSize = stack.size();
        int[] res = new int[stackSize];
        
        for(int i = stackSize - 1; i >=0; i--){
            res[i] = stack.removeFirst();
        }
        return res;
    }

}

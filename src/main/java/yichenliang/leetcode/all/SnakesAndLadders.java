package yichenliang.leetcode.all;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *  909. Snakes and Ladders
 *   
 *  BFS
 *  time complexity: O(m*n)
 *  space complexity: O(m*n)
 *  
 */


public class SnakesAndLadders {
	
	public int snakesAndLadders(int[][] board) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int N = board.length;
        visited.add(1);
        q.offer(1);
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int cur = q.poll();
                if(cur == N*N) return steps;
                if(cur % N == 0){
                    int d = cur / N;
                    int r = N - 1 - (d - 1), c;
                    if(d % 2 == 0){
                      c = 0;
                    }
                    else{
                      c = N - 1;
                    }
                    if(board[r][c] != -1){
                        cur = board[r][c];
                        if(cur == N * N) return steps;
                    } 
                }
                else{
                    int div = cur / N, m = cur % N;
                    int r = N - 1 - div, c;
                    if(div % 2 == 0){
                        c = m - 1;
                    }
                    else{
                        c = N - m;
                    }
                    if(board[r][c] != -1){
                        cur = board[r][c];
                        if(cur == N * N) return steps;
                    }    
                }
                
                for(int dis = 1; dis <= 6; dis++){
                    if(!visited.contains(cur + dis) && cur + dis <= N*N ) {
                    	q.offer(cur + dis);
                    	visited.add(cur + dis);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}

package yichenliang.leetcode.all;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  490. The Maze
 *  
 * method1: bfs
 * time complexity: o(n*m)
 * space complexity: o(n*m)
 * 
 * method2: dfs
 * time complexity: O(n*m)
 * space complexity: O(n*m)
 *  
 */

public class TheMaze {
	
	// bfs
	public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        
        int m = maze.length;
        int n = maze[0].length;
        
        if(start[0] == destination[0] && start[1] == destination[1]){
            return true;
        }
        
        int[] dir = new int[]{0, -1, 0, 1, 0};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {start[0], start[1]});
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i = 0; i < 4; i++){
                int tx = cx, ty = cy;
                while(tx >= 0 && ty >= 0 && tx < m && ty < n && maze[tx][ty] == 0){
                    tx += dir[i];
                    ty += dir[i + 1];
                }
                tx -= dir[i];
                ty -= dir[i + 1];
                if(visited[tx][ty]) continue;
                visited[tx][ty] = true;
                if(tx == destination[0] && ty == destination[1]) return true;
                q.offer(new int[] {tx, ty});
            }
        }
        return false;
    }
	
	// dfs
	int[] dir = {0, -1, 0, 1, 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) return false;
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(maze, start, destination, visited);
    }
    
    private boolean dfs(int[][] maze, int[] s, int[] d, boolean[][] v){
        if(v[s[0]][s[1]]) return false;
        if(s[0] == d[0] &&s[1] == d[1]) return true;
        
        v[s[0]][s[1]] = true;
        
        // check 4 directions
        for(int i = 0; i < 4; i++){
            int[] newStart = roll(maze, s[0], s[1], dir[i], dir[i + 1]);
            if(dfs(maze, newStart, d, v)) return true;
        }
        //v[s[0]][s[1]] = false;   // if add this line, it will cause TLE
        return false;
    }
    
    private int[] roll(int[][] maze, int sx, int sy, int dx, int dy){
        while(sx >= 0 && sy >= 0 && sx < maze.length && sy < maze[0].length && maze[sx][sy] == 0){
            sx = sx + dx;
            sy = sy + dy;
        }
        sx = sx - dx;
        sy = sy - dy;
        return new int[] {sx, sy};
    }
}

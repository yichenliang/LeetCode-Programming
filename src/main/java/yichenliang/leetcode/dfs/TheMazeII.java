package yichenliang.leetcode.dfs;

/**
 *  505. The Maze II
 *  
 *  dfs
 *  
 *  time complexity: O()
 *  space complexity: O()
 * 
 */

public class TheMazeII {
	int[] dir = {0, -1, 0, 1, 0};
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0) return -1;
        int row = maze.length, col = maze[0].length;
        int[][]visited = new int[row][col];
        int[] min = {Integer.MAX_VALUE};
        dfs(maze, start[0], start[1], destination, visited, min, 0);
        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
    }
    
    private boolean dfs(int[][] maze, int x, int y, int[] destination, int[][] visited, int[] min, int steps){
        // edge case
        if(visited[x][y] == 1) return false;
        if(x == destination[0] && y == destination[1]){
            min[0] = Math.min(min[0], steps);
            return true;
        }
        
        
        visited[x][y] = 1;
        // roll to 4 directions
        
        for(int i = 0; i < 4; i++){
            int dstep = 0;
            int nx = x;
            int ny = y;
            int dx = dir[i], dy = dir[i + 1];
            while(nx + dx >= 0 && nx + dx < maze.length && ny + dy >= 0 && ny + dy < maze[0].length && maze[nx + dx][ny + dy] == 0){
                nx = nx + dx;
                ny = ny + dy;
                dstep++;
            }
            //int[] newP = roll(maze, x, y, i);
            if(dfs(maze, nx, ny, destination, visited, min, steps + dstep)) return true;
        }
        return false;
    }
    
    public static void main(String[] agrs) {
    	TheMazeII solution = new TheMazeII();
    	int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
    	int[] start = {0, 4}; 
    	int[] destination = {4, 4};
    	int res = solution.shortestDistance(maze, start, destination);
    }
}

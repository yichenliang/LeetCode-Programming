package yichenliang.leetcode.all;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 *  773. Sliding Puzzle
 * 
 *  bfs
 *  
 *  time complexity: O((2*3)!)  the upper bound, can be seen as the arrange of all number
 *  space complexity: O((2*3)!)
 */

public class SlidingPuzzle {
	
	public int slidingPuzzle(int[][] board) {
        int row = 2;
        int col = 3;
        
        String goal = "123450";
        String start = "";
        
        // build the original start string
        for(int i = 0; i < row; i++){
            for(int j =0; j < col; j++){
                start += board[i][j];
            }
        }
        
        if(start.equals(goal)){
            return 0;
        }
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // up, down, left, right
        Set<String> visited = new HashSet<>();
        visited.add(start);
        
        int steps = 0;
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast(start);
        
        // bfs
        while(!queue.isEmpty()){
            steps++;
            
            int size = queue.size();
            for(int si = size; si > 0; si--){
                
            	String s = queue.removeFirst();
                int position = s.indexOf("0");
                int i = position / col;
                int j = position % col;
                for(int d = 0; d < 4; d++){
                    int ti = i + dirs[d][0];
                    int tj = j + dirs[d][1];
                    
                    if(ti < 0 || tj < 0 || ti >= row || tj >= col){
                        continue;
                    }
                    
                    int newPosition = ti * col + tj;
                    
                    StringBuilder temp = new StringBuilder(s);
                    char number = temp.charAt(newPosition);
                    temp.setCharAt(newPosition, '0');
                    temp.setCharAt(position, number);  
                    String newStr = temp.toString();
                                  
                    if(visited.contains(newStr)){
                        continue;
                    }
                    
                    if(newStr.equals(goal)){
                        return steps;
                    }
                    visited.add(newStr);
                    queue.addLast(newStr);
                }
                
            }
            
        }
        
        return -1;
    }

}

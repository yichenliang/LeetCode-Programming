package yichenliang.leetcode.all;

import java.util.HashSet;

/**
 *  489. Robot Room Cleaner
 *  
 *  DFS + Design
 *  
 */

interface Robot {
     // Returns true if the cell in front is open and robot moves into the cell.
     // Returns false if the cell in front is blocked and robot stays in the current cell.
     public boolean move();

     // Robot will stay in the same cell after calling turnLeft/turnRight.
     // Each turn will be 90 degrees.
     public void turnLeft();
     public void turnRight();

     // Clean the current cell.
     public void clean();
}

public class RobotRoomCleaner {
	public void cleanRoom(Robot robot) {
        HashSet<String> set = new HashSet<>();
        dfs(robot, 0, 0, 0, set);
    }
    
    private void dfs(Robot r, int x, int y, int d, HashSet<String> set){
        String str = x + "," + y;
        if(set.contains(str)) return;
        set.add(str);
        r.clean();
        
        // 0 up; 90 right; 180 down; 270 left
        for(int i = 0; i < 4; i++){
            if(r.move()){
               int nx = x, ny = y;
                switch(d){
                    case 0:
                        nx = x - 1;
                        break;
                    case 90:
                        ny = y + 1;
                        break;
                    case 180:
                        nx = x + 1;
                        break;
                    case 270:
                        ny = y - 1;
                        break;
                    default:
                        break;      
                }
                dfs(r, nx, ny, d, set);
                r.turnLeft();
                r.turnLeft();
                r.move();
                r.turnLeft();
                r.turnLeft();
            }
            r.turnRight();
            d = d + 90;
            d = d % 360;  
        }
    }
}

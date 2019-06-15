package yichenliang.leetcode.bfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 675. Cut Off Trees for Golf Event
 * 
 * bfs
 *
 * time complexity:O(m^2*n^2) 
 * space complexity: O(mn)
 * 
 */

public class CutOffTreesForGolfEvent {
	
public int cutOffTree(List<List<Integer>> forest) {
        
        int m = forest.size();
        int n = forest.get(0).size();
        
        List<int[]> trees = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(forest.get(i).get(j) > 0){
                    trees.add(new int[] {forest.get(i).get(j), i, j});
                }
            }
        }
        
        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        };
        
        trees.sort(comp);
        
        int si = 0;
        int sj = 0;
        int totalSteps = 0;
        int len = trees.size();
        for(int i = 0; i < len; i++ ){
            int ti = trees.get(i)[1];
            int tj = trees.get(i)[2];
            int steps = bfs(forest, si, sj, ti, tj);
            if(steps == -1) return -1;
            totalSteps += steps;
            si = ti;
            sj = tj;
        }
        return totalSteps;
    }
    
    private int bfs(List<List<Integer>> forest, int si, int sj, int ti, int tj){
        int[] dir = {0, -1, 0, 1, 0};
        int m = forest.size();
        int n = forest.get(0).size(); 
        int[][]  visited = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {si, sj});
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0){
                int[] cur = q.poll();
                int ci = cur[0];
                int cj = cur[1];
                if(ci == ti && cj == tj){
                    return steps;
                }
                
                for(int i = 0; i < 4; i++){
                    int ni = ci + dir[i];
                    int nj = cj + dir[i + 1];
                    
                    if(ni < 0 || ni >= m || nj < 0 || nj >= n || forest.get(ni).get(nj) == 0 || visited[ni][nj] == 1){
                        continue;
                    }
                    
                    visited[ni][nj] = 1;
                    q.offer(new int[] {ni, nj});
                }
                size--;
            }
            steps++;
        }
        return -1;
    }

}

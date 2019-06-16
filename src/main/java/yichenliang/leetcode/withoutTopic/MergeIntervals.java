package yichenliang.leetcode.withoutTopic;

import java.util.Comparator;
import java.util.LinkedList;

/**
 *  56. Merge Intervals
 *  
 *  Write self define comparator
 *  
 *  time complexity: O(nlogn)
 *  space complexity: O(n)
 * 
 */

public class MergeIntervals {
	
	public int[][] merge(int[][] intervals) {
        
        LinkedList<LinkedList<Integer>> store = new LinkedList<>();
        
        for(int i = 0; i < intervals.length; i++){
            int[] current = intervals[i];
            LinkedList<Integer> e = new LinkedList<>();
            for(int j = 0; j <= 1; j++){
                e.add(current[j]);
            }
            store.add(e);
        }
        
        // sort
        Comparator<LinkedList<Integer>> c = new Comparator<LinkedList<Integer>>(){
            public int compare(LinkedList<Integer> a, LinkedList<Integer> b){
                return a.get(0) - b.get(0);
            }
        }; 
        
        store.sort(c);
        LinkedList<LinkedList<Integer>> res = new LinkedList<>();
        
        for(LinkedList<Integer> each : store){
            if(res.isEmpty() || res.getLast().getLast() < each.get(0)){
                res.add(new LinkedList<Integer>(each));
            }
            else{
                LinkedList<Integer> pre = res.removeLast();
                LinkedList<Integer> cur = new LinkedList<>();
                cur.add(pre.getFirst());
                int max = Math.max(each.getLast(), pre.getLast());
                cur.add(max);
                res.add(cur);
            }
        }
        
        int len = res.size();
        int[][] ans = new int[len][2];
        
        for(int i = 0; i < len; i++){
            ans[i][0] = res.get(i).getFirst();
            ans[i][1] = res.get(i).getLast();
        }
        
        return ans;
    }
}

package yichenliang.leetcode.withoutTopic;

import java.util.ArrayList;
import java.util.List;

/**
 *  57. Insert Interval
 * 
 *  time complexity: O(n)
 *  space complexity: O(n)
 */


 // Definition for an interval.
 class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
 }


public class InsertInterval {
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<>();
        
        // end cases
        if(intervals == null || intervals.size() == 0){
            ans.add(newInterval);
            return ans;
        }
        
        if(newInterval == null){
            return intervals;
        }
        
        int len = intervals.size();
        if(newInterval.end < intervals.get(0).start){
            ans.add(newInterval);
            for(int i = 0; i < len; i++ ){
                ans.add(intervals.get(i));
            }
            return ans;
        }
        
        if(newInterval.start > intervals.get(len - 1).end){
           for(int i = 0; i < len; i++ ){
                ans.add(intervals.get(i));
            }
            ans.add(newInterval);
            return ans;
        }
        
        // normal case
           //find new start
        int start = newInterval.start;
        
        int newStart = newInterval.start;
        int curIndex = len;
        int i = 0;
        for( ; i < len; i++){
            if(start > intervals.get(i).end){
                ans.add(intervals.get(i));
            }
            else{
                newStart = intervals.get(i).start <= start ? intervals.get(i).start : start;
                //curIndex = i;
                break;
            }
        }
        
        // find new end
        int end = newInterval.end;
        int newEnd = newInterval.end;
        int j = i;
        for( ; j < len; j++){
            if(end >= intervals.get(j).start){
                continue;
            }
            else{
                int formerEnd = intervals.get(j - 1).end;
                if(formerEnd > end){
                    if(intervals.get(j - 1).start > end){
                        newEnd = end;
                        curIndex = j - 1;
                    }
                    else{
                       newEnd = formerEnd;
                       curIndex = j;
                    }
                }
                else{  // formerEnd <= end
                   newEnd = end;
                   curIndex = j;
                }
                break;
            }
        }
        
        // create the interval to insert
        newEnd = end < intervals.get(j - 1).end? intervals.get(j - 1).end : end;
        Interval newOne = new Interval(newStart, newEnd);
        ans.add(newOne);
        
        // append the following intervals from intervals list
        for(int k = curIndex; k < len; k++){
            ans.add(intervals.get(k));   
        }
        return ans;
    }

}

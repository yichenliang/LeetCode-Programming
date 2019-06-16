package yichenliang.leetcode.all;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 253. Meeting Rooms II
 * 
 *  write my own comparator
 * 
 * time complexity: O(nlogn)
 * space complexity: O(n)
 * 
 */

public class MeetingRoomsII {
	
	public int minMeetingRooms(Interval[] intervals) {
        
        int length = intervals.length;
        if(length == 0){
            return 0;
        }
        
        // sort intervals array first
        Arrays.sort(intervals, new Comparator<Interval>(){
           public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        
        // initial a min heap to manage room
        PriorityQueue<Integer> rooms = new PriorityQueue<Integer>(
              length,
              new Comparator<Integer>(){
                 public int compare(Integer a, Integer b){
                     return a - b;
                  }
              }
        );
        
        rooms.add(intervals[0].end);
        
        for(int i = 1; i < length; i++){
            if(intervals[i].start >= rooms.peek()){
                rooms.poll();
            }
            
            rooms.add(intervals[i].end);   
        }
        
        return rooms.size();   
    }
}

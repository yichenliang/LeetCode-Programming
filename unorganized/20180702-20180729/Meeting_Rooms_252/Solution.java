import java.util.Arrays;
import java.util.Comparator;

//252. Meeting Rooms
//Approach #2 (Sorting)

//Definition for an interval.
    class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

class Solution {
	
	public boolean canAttendMeetings(Interval[] intervals) {
	    Arrays.sort(intervals, new Comparator<Interval>() {
	        public int compare(Interval i1, Interval i2) {
	            return i1.start - i2.start;
	        }        
	    });
	    for (int i = 0; i < intervals.length - 1; i++) {
	        if (intervals[i].end > intervals[i + 1].start) return false;
	    }
	    return true;
	}
	

   public static void main(String args[])
    {
		Solution solution = new Solution();
		
//		Interval a = new Interval(0,30);
//		Interval b = new Interval(5,10);
//		Interval c = new Interval(15,20);
//		Interval[] input = {a, b, c};
		
		Interval a = new Interval(7,10);
		Interval b = new Interval(2,4);
		Interval[] input = {a, b};
		
		boolean res = solution.canAttendMeetings(input);
		System.out.println(res);
    }
}


// 1. Comparator interface is used to order the objects of user-defined class.
//  https://www.geeksforgeeks.org/arrays-sort-in-java-with-examples/
//  http://tutorials.jenkov.com/java/interfaces.html
//  https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html\
//  https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(T[],%20java.util.Comparator)
//  https://www.geeksforgeeks.org/comparator-interface-java/



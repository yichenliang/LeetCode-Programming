/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {

    class IntervalComparator implements Comparator<Interval> {   // 1
        @Override
        public int compare(Interval a, Interval b) {   // 2
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }
    
    public List<Interval> merge(List<Interval> intervals) {  // 3
        Collections.sort(intervals, new IntervalComparator());  // 4
        LinkedList<Interval> merged = new LinkedList<>();  // 5
        
        for(Interval interval : intervals){
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
			if(merged.isEmpty() || merged.getLast().end < interval.start){  // 6
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
			else{
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }
        return merged;   
        
    }
}


// first sort the original intervals, and then merge it. In the process of sorting, we need the help of Collection.sort,
// int the Collection.sort, we need to introduce the Comparator to guide the sort, thus we need implements the IntervalComparator

// 1: https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html#compare-T-T-
// 2: https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html#compare-T-T-   compare
// 3: https://docs.oracle.com/javase/7/docs/api/java/util/List.html
// 4: https://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#sort(java.util.List,%20java.util.Comparator) sort
// 5: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html
// 6: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html  some API of linkedlist (isEmpty, add, getLast)

// time complexity: O(nlgn)O(nlgn), Other than the sort invocation, we do a simple linear scan of the list, 
//                  so the runtime is dominated by the O(nlgn) complexity of sorting.

// space complexity: O(n)
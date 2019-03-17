package yichenliang.leetcode;

//import java.util.HashMap;
//import java.util.Map;

//import javafx.util.Pair;

/**
 * 
 * 149. Max Points on a Line
 * 
 * Time complexity: O(n^2)
 * Space complexity: O(n)
 */


  class Point {
	      int x;
	      int y;
	      Point() { x = 0; y = 0; }
	      Point(int a, int b) { x = a; y = b; }
  }

public class MaxPointsOnALine {
	
//	public int maxPoints(Point[] points) {
//        if(points == null || points.length == 0) return 0;
//        
//        int n = points.length;
//        if(n == 1 || n == 2) return n;
//        
//        int ans = 0;
//        
//        for(int i = 0; i < n; i++){
//            Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
//            int samePoint = 1;
//            int max = 0; // max point in this round
//            Point p1 = points[i];
//            for(int j = i + 1; j < n; j++){
//                Point p2 = points[j];
//                
//                // same point 
//                if(p1.x == p2.x && p1.y == p2.y){
//                    samePoint++;
//                }
//                else{
//                    Pair key = getSlope(p1, p2);
//                    if(map.containsKey(key)){
//                        Integer v = map.get(key);
//                        v++;
//                        map.put(key, v);
//                    }
//                    else{
//                        map.put(key, 1);
//                    }
//                    max = Math.max(max, map.get(key));
//                } 
//                
//            }
//            ans = Math.max(ans, max + samePoint);
//        }
//        return ans;     
//    }
//    
//    Pair<Integer, Integer> getSlope(Point p1, Point p2){
//        int dx = p2.x - p1.x;
//        int dy = p2.y - p1.y;
//        
//        // horizantal line ---
//        if(dy == 0){
//            return new Pair(p1.y, 0);
//        }
//        // vertical line |
//        if(dx == 0){
//            return new Pair(0, p1.x);
//        }
//        
//        int gcd = gcd(dx, dy);
//        return new Pair(dx/gcd, dy/gcd);
//    }
//    
//    int gcd(int a, int b){
//        return b==0? a : gcd(b, a%b);
//    }
	 
}

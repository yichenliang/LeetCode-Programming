package yichenliang.leetcode.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  399. Evaluate Division
 * 
 *  graph dfs 
 * 
 *  
 */

public class EvaluateDivision {
	
	 public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		    // build graph
		        HashMap<String, HashMap<String, Double>> g = new HashMap<>();
		        buildGraph(g,equations, values);
		        int size = queries.size();
		        double[] res = new double[size];
		        Arrays.fill(res, -1.0);
		        int index = 0;
		        for(int i = 0; i < size; i++){
		            String op1 = queries.get(i).get(0);
		            String op2 = queries.get(i).get(1);
		            if(g.containsKey(op1) && g.containsKey(op1)){
		                dfs(g, op1, op2, index, res, new HashSet<String>(), 1.0);
		            }
		            index++;
		        }
		        return res;
		    }
		    private void dfs(HashMap<String, HashMap<String, Double>> g, String start, String end, int idx, double[] res, Set<String> visited, Double cost){
		        // end case
		        if(start.equals(end)){
		            res[idx] = cost;
		            return;
		        }
		        
		        // normal case
		        HashMap<String, Double> nei = g.get(start);
		        for(String each : nei.keySet()){
		            if(visited.contains(each)) continue;
		            visited.add(each);
		            dfs(g, each, end, idx, res, visited, cost * nei.get(each));
		        }
		    }
		    private void buildGraph(HashMap<String, HashMap<String, Double>> g, List<List<String>> equ, double[] values){
		        int len = equ.size();
		        for(int i = 0; i < len; i++){
		            String a = equ.get(i).get(0);
		            String b = equ.get(i).get(1);
		            if(!g.containsKey(a)){
		                HashMap<String, Double> m = new HashMap<>();
		                g.put(a, m);
		            }
		            if(!g.containsKey(b)){
		                HashMap<String, Double> m = new HashMap<>();
		                g.put(b, m);
		            }
		            g.get(a).put(b, values[i]);
		            g.get(b).put(a, 1.0 / values[i]);
		            g.get(a).put(a, 1.0);
		            g.get(b).put(b, 1.0);
		        }
		        
		    }
}
